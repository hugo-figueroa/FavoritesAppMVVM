package com.favorites.appmvvm.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.favorites.core.favorites.FCFavoritesView;
import com.favorites.core.favorites.models.Favorites;
import com.favorites.core.generics.interfaces.OnFCListener;
import com.favorites.core.generics.models.FCError;
import com.favorites.core.generics.models.FCResponse;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

/**
 * 14/03/18
 */
public class FavoritesRepository<T> {

    private FCFavoritesView fcFavoritesView;
    private Context context;

    public FavoritesRepository(Context context) {
        fcFavoritesView = FCFavoritesView.getInstance();
    }

    public LiveData<T> getFavorites() {
        final MutableLiveData<T> data = new MutableLiveData<>();
        fcFavoritesView.getFavorites(new OnFCListener() {
            @Override
            public void onResponse(FCResponse fcResponse) {
                data.setValue((T) fcResponse);
            }

            @Override
            public void onError(FCError fcError) {
                data.setValue((T) fcError);
            }
        });
        return data;
    }

}
