package com.favorites.appmvvm.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.favorites.appmvvm.R;
import com.favorites.appmvvm.databinding.ItemFavoriteBinding;
import com.favorites.appmvvm.viewmodel.ItemFavoritesViewModel;
import com.favorites.core.favorites.models.Favorites;

import java.util.LinkedHashMap;

/**
 * 15/03/18
 */
public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder> {

    private LinkedHashMap<String, Favorites.Products> favoritesList;
    private Object[] keys;

    public FavoritesAdapter() {
        this.favoritesList = new LinkedHashMap<>();
    }

    @Override
    public FavoritesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemFavoriteBinding itemFavoriteBinding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.layout.item_favorite,
                        parent, false);

        return new FavoritesViewHolder(itemFavoriteBinding);
    }

    public void setFavoritesList(LinkedHashMap<String, Favorites.Products> favoritesList) {
        this.favoritesList = favoritesList;
        keys = favoritesList.keySet().toArray();
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(FavoritesViewHolder holder, int position) {
        holder.binding.setItemFavoritesViewModel(new ItemFavoritesViewModel(favoritesList.get(keys[position]), holder.itemView.getContext()));
        holder.binding.executePendingBindings();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return favoritesList.size();
    }

    public static class FavoritesViewHolder extends RecyclerView.ViewHolder {

        final ItemFavoriteBinding binding;

        public FavoritesViewHolder(ItemFavoriteBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}