package com.lolamocha.android.capstonep.ui.moviedetails;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.lolamocha.android.capstonep.R;
import com.lolamocha.android.capstonep.data.local.model.Genre;
import com.lolamocha.android.capstonep.utils.Constants;
import com.lolamocha.android.capstonep.utils.GlideApp;
import com.lolamocha.android.capstonep.utils.UiUtils;

import java.util.List;


public class BindingAdapters {

    @BindingAdapter({"imageUrl", "isBackdrop"})
    public static void bindImage(ImageView imageView, String imagePath, boolean isBackdrop) {
        String baseUrl;
        if (isBackdrop) {
            baseUrl = Constants.BACKDROP_URL;
        } else {
            baseUrl = Constants.IMAGE_URL;
        }

        GlideApp
                .with(imageView.getContext())
                .load(baseUrl + imagePath)
                .placeholder(R.color.md_grey_200)
                .into(imageView);
    }

    /**
     * Movie details poster image
     */
    @BindingAdapter({"imageUrl"})
    public static void bindImage(ImageView imageView, String imagePath) {
        GlideApp
                .with(imageView.getContext())
                .load(Constants.IMAGE_URL + imagePath)
                .placeholder(R.color.md_grey_200)
                .apply(new RequestOptions().transforms(new CenterCrop(),
                        new RoundedCorners((int) UiUtils.dipToPixels(imageView.getContext(), 8))))
                .into(imageView);
    }

    @BindingAdapter("visibleGone")
    public static void showHide(View view, Boolean show) {
        if (show) view.setVisibility(View.VISIBLE);
        else view.setVisibility(View.GONE);
    }

    @BindingAdapter("items")
    public static void setItems(ChipGroup view, List<Genre> genres) {
        if (genres == null
                // Since we are using liveData to observe data, any changes in that table(favorites)
                // will trigger the observer and hence rebinding data, which can lead to duplicates.
                || view.getChildCount() > 0)
            return;

        // dynamically create & add genre chips
        Context context = view.getContext();
        for (Genre genre : genres) {
            Chip chip = new Chip(context);
            chip.setText(genre.getName());

            chip.setTextColor(ColorStateList.valueOf(
                    context.getResources().getColor(R.color.md_orange_400)));

            chip.setChipStrokeWidth(UiUtils.dipToPixels(context, 1));
            chip.setChipStrokeColor(ColorStateList.valueOf(
                    context.getResources().getColor(R.color.md_orange_400)));
            chip.setChipBackgroundColorResource(android.R.color.transparent);
            view.addView(chip);
        }
    }

}
