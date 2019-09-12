package com.lolamocha.android.capstonep.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.lolamocha.android.capstonep.data.local.model.Cast;

import java.util.List;


@Dao
public interface CastsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllCasts(List<Cast> castList);

}
