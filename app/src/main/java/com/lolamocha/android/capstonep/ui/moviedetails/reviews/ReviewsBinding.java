package com.lolamocha.android.capstonep.ui.moviedetails.reviews;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.lolamocha.android.capstonep.data.local.model.Review;

import java.util.List;


public class ReviewsBinding {

    @BindingAdapter("items")
    public static void setItems(RecyclerView recyclerView, List<Review> items) {
        ReviewsAdapter adapter = (ReviewsAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.submitList(items);
        }
    }
}
