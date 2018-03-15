package com.favorites.appmvvm.view.ui;


import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.favorites.appmvvm.R;
import com.favorites.appmvvm.databinding.FragmentFavoritesBinding;
import com.favorites.appmvvm.view.adapter.FavoritesAdapter;
import com.favorites.appmvvm.viewmodel.FavoritesViewModel;
import com.favorites.core.favorites.models.Favorites;
import com.favorites.core.generics.models.FCError;
import com.favorites.core.generics.models.FCResponse;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritesFragment<T> extends LifecycleFragment {

    public static final String TAG = FavoritesFragment.class.getSimpleName();

    private FragmentFavoritesBinding binding;
    private FavoritesViewModel favoritesViewModel;
    private FavoritesAdapter favoritesAdapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        favoritesViewModel = ViewModelProviders.of(getActivity()).get(FavoritesViewModel.class);

        observeFavoritesViewModel(favoritesViewModel);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorites, container, false);

        favoritesAdapter = new FavoritesAdapter();
        binding.rcvCollections.setNestedScrollingEnabled(false);
        binding.rcvCollections.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        binding.rcvCollections.setAdapter(favoritesAdapter);
        return binding.getRoot();
    }

    private void observeFavoritesViewModel(FavoritesViewModel favoritesViewModel) {
        // Update the list when the data changes
        ((FavoritesActivity) getActivity()).showLoading();
        favoritesViewModel.getFavoritesListObservable().observe(this, new Observer<T>() {
            @Override
            public void onChanged(@Nullable T favorites) {
                if (favorites instanceof FCResponse) {
                    List<Favorites> favoritesList = (List<Favorites>) ((FCResponse) favorites).getResponse();
                    favoritesAdapter.setFavoritesList(favoritesList);
                } else if (favorites instanceof FCError) {
                    FCError fcError = ((FCError) favorites);
                    Toast.makeText(getActivity(), fcError.getMessage(), Toast.LENGTH_SHORT).show();
                }
                ((FavoritesActivity) getActivity()).hideLoading();
            }
        });
    }

}
