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
import com.favorites.ui.controls.FUICollectionView;

/**
 * 14/03/18
 */
public class ItemFavoriteViewModel {

    private static Favorites favorites;
    private static Context context;
    private Object[] keys;

    public ItemFavoriteViewModel(Favorites favorites, Context context) {
        this.favorites = favorites;
        keys = favorites.getProducts().keySet().toArray();
        this.context = context;
    }

    public String getCollectionTitle() {
        return favorites.getName();
    }

    public int getCollectionQuantity() {
        return favorites.getProducts().size();
    }

    public String getImageUrlCollectionImage1() {
        return favorites.getProducts().get(keys[0]).getImage();
    }

    public String getImageUrlCollectionImage2() {
        return favorites.getProducts().get(keys[1]).getImage();
    }

    public String getImageUrlCollectionImage3() {
        return favorites.getProducts().get(keys[2]).getImage();
    }

    @BindingAdapter("collectionImage1Drawable")
    public static void setCollectionImage1Drawable(final FUICollectionView fuiCollectionView, String url) {
        if (favorites != null && favorites.getProducts().size() >= 1) {
            Glide.with(context)
                    .load(url)
                    .into(new SimpleTarget<Drawable>() {
                        @Override
                        public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                            fuiCollectionView.setCollectionImage1Drawable(resource);

                        }
                    });
        }
    }

    @BindingAdapter({"collectionImage2Drawable"})
    public static void setCollectionImage2Drawable(final FUICollectionView fuiCollectionView, String url) {
        if (favorites != null && favorites.getProducts().size() >= 2) {
            Glide.with(context)
                    .load(url)
                    .into(new SimpleTarget<Drawable>() {
                        @Override
                        public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                            fuiCollectionView.setCollectionImage2Drawable(resource);

                        }
                    });
        }
    }

    @BindingAdapter({"collectionImage3Drawable"})
    public static void setCollectionImage3Drawable(final FUICollectionView fuiCollectionView, String url) {
        if (favorites != null && favorites.getProducts().size() >= 3) {
            Glide.with(context)
                    .load(url)
                    .into(new SimpleTarget<Drawable>() {
                        @Override
                        public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                            fuiCollectionView.setCollectionImage3Drawable(resource);

                        }
                    });
        }
    }
}
