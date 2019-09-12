package com.lolamocha.android.capstonep.utils;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.lolamocha.android.capstonep.data.MovieRepository;
import com.lolamocha.android.capstonep.ui.moviedetails.MovieDetailsViewModel;
import com.lolamocha.android.capstonep.ui.movieslist.discover.DiscoverMoviesViewModel;
import com.lolamocha.android.capstonep.ui.movieslist.favorites.FavoritesViewModel;


public class ViewModelFactory implements ViewModelProvider.Factory {

    private final MovieRepository repository;

    public static ViewModelFactory getInstance(MovieRepository repository) {
        return new ViewModelFactory(repository);
    }

    private ViewModelFactory(MovieRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(DiscoverMoviesViewModel.class)) {
            //noinspection unchecked
            return (T) new DiscoverMoviesViewModel(repository);
        } else if (modelClass.isAssignableFrom(FavoritesViewModel.class)) {
            //noinspection unchecked
            return (T) new FavoritesViewModel(repository);
        } else if (modelClass.isAssignableFrom(MovieDetailsViewModel.class)) {
            //noinspection unchecked
            return (T) new MovieDetailsViewModel(repository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
