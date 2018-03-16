package com.favorites.appmvvm.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.favorites.appmvvm.R;
import com.favorites.appmvvm.databinding.ItemCollectionBinding;
import com.favorites.appmvvm.viewmodel.ItemCollentionsViewModel;
import com.favorites.core.favorites.models.Favorites;

import java.util.Collections;
import java.util.List;

/**
 * 14/03/18
 */
public class CollectionsAdapter extends RecyclerView.Adapter<CollectionsAdapter.FavoritesViewHolder> {

    private List<Favorites> favoritesList;

    public CollectionsAdapter() {
        this.favoritesList = Collections.emptyList();
    }

    @Override
    public FavoritesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemCollectionBinding itemCollectionBinding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.layout.item_collection,
                        parent, false);

        return new FavoritesViewHolder(itemCollectionBinding);
    }

    public void setFavoritesList(List<Favorites> favoritesList) {
        this.favoritesList = favoritesList;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(FavoritesViewHolder holder, int position) {
        holder.binding.setItemCollentionsViewModel(new ItemCollentionsViewModel(favoritesList.get(position), holder.itemView.getContext()));
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

        final ItemCollectionBinding binding;

        public FavoritesViewHolder(ItemCollectionBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
