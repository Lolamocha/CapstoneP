package com.lolamocha.android.capstonep.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.lolamocha.android.capstonep.data.local.model.Review;

import java.util.List;


@Dao
public interface ReviewsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllReviews(List<Review> reviews);

}
