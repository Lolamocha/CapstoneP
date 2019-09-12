package com.lolamocha.android.capstonep.ui.moviedetails.trailers;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.lolamocha.android.capstonep.data.local.model.Trailer;

import java.util.List;


public class TrailersListBindings {

    @BindingAdapter("items")
    public static void setItems(RecyclerView recyclerView, List<Trailer> items) {
        TrailersAdapter adapter = (TrailersAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.submitList(items);
        }
    }
}
