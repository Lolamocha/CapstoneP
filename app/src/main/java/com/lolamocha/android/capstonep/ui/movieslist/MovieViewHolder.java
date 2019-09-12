package com.lolamocha.android.capstonep.ui.movieslist;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lolamocha.android.capstonep.data.local.model.Movie;
import com.lolamocha.android.capstonep.databinding.ItemMovieBinding;
import com.lolamocha.android.capstonep.ui.moviedetails.DetailsActivity;


public class MovieViewHolder extends RecyclerView.ViewHolder {

    private final ItemMovieBinding binding;

    public MovieViewHolder(@NonNull ItemMovieBinding binding) {
        super(binding.getRoot());

        this.binding = binding;
    }

    public void bindTo(final Movie movie) {
        binding.setMovie(movie);
        // movie click event
        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailsActivity.class);
                intent.putExtra(DetailsActivity.EXTRA_MOVIE_ID, movie.getId());
                view.getContext().startActivity(intent);
            }
        });

        binding.executePendingBindings();
    }

    public static MovieViewHolder create(ViewGroup parent) {
        // Inflate
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        // Create the binding
        ItemMovieBinding binding =
                ItemMovieBinding.inflate(layoutInflater, parent, false);
        return new MovieViewHolder(binding);
    }
}
