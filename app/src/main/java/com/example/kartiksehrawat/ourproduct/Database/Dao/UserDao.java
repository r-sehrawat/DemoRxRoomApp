package com.example.kartiksehrawat.ourproduct.Database.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.kartiksehrawat.ourproduct.Model.User;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;

/**
 * Created by kartiksehrawat on 25/09/18.
 */

@Dao
public interface UserDao {

//    @Query("SELECT * FROM User")
//    Single<List<User>> getAll();

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM User WHERE userId= :key")
    Single<User> findById(String key);
}
