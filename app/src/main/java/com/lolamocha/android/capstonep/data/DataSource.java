package com.lolamocha.android.capstonep.data;

import androidx.lifecycle.LiveData;

import com.lolamocha.android.capstonep.data.local.model.Movie;
import com.lolamocha.android.capstonep.data.local.model.MovieDetails;
import com.lolamocha.android.capstonep.data.local.model.RepoMoviesResult;
import com.lolamocha.android.capstonep.data.local.model.Resource;
import com.lolamocha.android.capstonep.ui.movieslist.MoviesFilterType;

import java.util.List;


public interface DataSource {

    LiveData<Resource<MovieDetails>> loadMovie(long movieId);

    RepoMoviesResult loadMoviesFilteredBy(MoviesFilterType sortBy);

    LiveData<List<Movie>> getAllFavoriteMovies();

    void favoriteMovie(Movie movie);

    void unfavoriteMovie(Movie movie);
}
