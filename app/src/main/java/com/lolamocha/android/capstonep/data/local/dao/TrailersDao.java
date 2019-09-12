package com.lolamocha.android.capstonep.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.lolamocha.android.capstonep.data.local.model.Trailer;

import java.util.List;


@Dao
public interface TrailersDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllTrailers(List<Trailer> trailers);

}
