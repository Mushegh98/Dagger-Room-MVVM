package com.test.myapplication.data.database;

import android.content.Context;

import androidx.room.Room;

import com.test.myapplication.application.App;
import com.test.myapplication.data.dao.UserDao;
import com.test.myapplication.di.modules.ClientServiceModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


public class DatabaseBuilder {


    private UserDao userDao;
    private static DatabaseBuilder databaseBuilder;

    public UserDao getUserDao() {
        return userDao;
    }

    public void buildDatabase(Context context){
      AppDatabase database =  Room.databaseBuilder(context,AppDatabase.class, App.DATABASE)
                .fallbackToDestructiveMigration()
                .build();

        userDao = database.usersDao();
    }

    public static DatabaseBuilder getInstance() {
        if (databaseBuilder == null) {
            synchronized (ClientServiceModule.class) {
                if (databaseBuilder == null) {
                    databaseBuilder = new DatabaseBuilder();
                }
            }
        }
        return databaseBuilder;
    }

}
