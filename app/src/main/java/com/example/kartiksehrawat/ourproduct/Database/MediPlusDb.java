package com.example.kartiksehrawat.ourproduct.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.kartiksehrawat.ourproduct.Database.Dao.UserDao;
import com.example.kartiksehrawat.ourproduct.Model.User;

/**
 * Created by kartiksehrawat on 25/09/18.
 */

@Database(entities = {User.class}, version = 1,exportSchema = false)
public abstract class MediPlusDb extends RoomDatabase {
    public abstract UserDao userDao();

}
