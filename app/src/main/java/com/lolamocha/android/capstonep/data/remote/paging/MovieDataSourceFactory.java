package com.lolamocha.android.capstonep.data.remote.paging;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.lolamocha.android.capstonep.data.local.model.Movie;
import com.lolamocha.android.capstonep.data.remote.api.MovieService;
import com.lolamocha.android.capstonep.ui.movieslist.MoviesFilterType;

import java.util.concurrent.Executor;

/**
 * A simple data source factory provides a way to observe the last created data source.

 */
public class MovieDataSourceFactory extends DataSource.Factory<Integer, Movie> {

    public MutableLiveData<MoviePageKeyedDataSource> sourceLiveData = new MutableLiveData<>();

    private final MovieService movieService;
    private final Executor networkExecutor;
    private final MoviesFilterType sortBy;

    public MovieDataSourceFactory(MovieService movieService,
                                  Executor networkExecutor, MoviesFilterType sortBy) {
        this.movieService = movieService;
        this.sortBy = sortBy;
        this.networkExecutor = networkExecutor;
    }

    @Override
    public DataSource<Integer, Movie> create() {
        MoviePageKeyedDataSource movieDataSource =
                new MoviePageKeyedDataSource(movieService, networkExecutor, sortBy);
        sourceLiveData.postValue(movieDataSource);
        return movieDataSource;
    }
}
