package com.test.myapplication.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.test.myapplication.data.dao.UserDao;
import com.test.myapplication.data.model.User;

@Database(entities = {User.class} , version = 2 , exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao usersDao();
}
