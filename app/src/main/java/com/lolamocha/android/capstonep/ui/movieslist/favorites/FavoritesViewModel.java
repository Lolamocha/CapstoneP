package com.lolamocha.android.capstonep.ui.movieslist.favorites;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.lolamocha.android.capstonep.data.MovieRepository;
import com.lolamocha.android.capstonep.data.local.model.Movie;

import java.util.List;


public class FavoritesViewModel extends ViewModel {

    //    private final MovieRepository movieRepository;
    private LiveData<List<Movie>> favoriteListLiveData;

    public FavoritesViewModel(MovieRepository repository) {
        favoriteListLiveData = repository.getAllFavoriteMovies();
    }

    public LiveData<List<Movie>> getFavoriteListLiveData() {
        return favoriteListLiveData;
    }
}
