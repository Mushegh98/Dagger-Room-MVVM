package com.test.myapplication.application;

import android.app.Application;

import com.test.myapplication.di.components.AppComponent;
import com.test.myapplication.di.components.DaggerAppComponent;
import com.test.myapplication.di.modules.ClientServiceModule;
import com.test.myapplication.data.database.DatabaseBuilder;

public class App extends Application {

    public static final String DATABASE = "database";
    private AppComponent appComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }


    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .clientServiceModule(ClientServiceModule.getInstance())
                .build();

        DatabaseBuilder.getInstance().buildDatabase(this);

    }
}
