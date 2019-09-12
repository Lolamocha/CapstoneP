package com.lolamocha.android.capstonep.ui.moviedetails.cast;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.lolamocha.android.capstonep.data.local.model.Cast;

import java.util.List;


public class CastBinding {

    @BindingAdapter("items")
    public static void setItems(RecyclerView recyclerView, List<Cast> items) {
        CastAdapter adapter = (CastAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.submitList(items);
        }
    }
}
