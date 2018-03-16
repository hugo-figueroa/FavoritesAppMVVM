package com.favorites.appmvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.favorites.appmvvm.model.FavoritesRepository;

/**
 * 14/03/18
 */
public class FavoritesViewModel<T> extends AndroidViewModel {

    private FavoritesRepository favoritesRepository;
    private final LiveData<T> favoritesList;

    public FavoritesViewModel(@NonNull Application application) {
        super(application);
        favoritesRepository = new FavoritesRepository(application);

        favoritesList = favoritesRepository.getFavorites();
    }

    public LiveData<T> getFavoritesListObservable() {
        return favoritesList;
    }

}
