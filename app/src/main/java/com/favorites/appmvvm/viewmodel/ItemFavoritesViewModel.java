package com.favorites.appmvvm.viewmodel;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.favorites.core.favorites.models.Favorites;
import com.favorites.ui.controls.FUIFavoritesView;

/**
 * 15/03/18
 */
public class ItemFavoritesViewModel {

    private static Favorites.Products favorites;
    private static Context context;

    public ItemFavoritesViewModel(Favorites.Products favorites, Context context) {
        this.favorites = favorites;
        this.context = context;
    }

    @BindingAdapter("productImageDrawable")
    public static void productImageDrawable(final FUIFavoritesView fuiFavoritesView, String url) {
        Glide.with(context)
                .load(url)
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        fuiFavoritesView.setProductImageDrawable(resource);
                    }
                });

    }

    public String getConditionType() {
        return favorites.getConditionType();
    }

    public boolean getFreeShipping() {

        return favorites.isFreeShipping();
    }

    public boolean getImported() {
        return favorites.isImported();
    }

    public int getPlusLevel() {
        return favorites.getLinioPlusLevel();
    }

    public String getProductImageUrl() {
        return favorites.getImage();
    }

}
