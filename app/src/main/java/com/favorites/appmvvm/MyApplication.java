package com.favorites.appmvvm;

import android.app.Application;

import com.favorites.core.favorites.FCFavoritesView;

/**
 * 14/03/18
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FCFavoritesView.getInstance().initialize(this);
    }

}
