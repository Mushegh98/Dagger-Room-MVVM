package com.test.myapplication.di.modules;

import com.test.myapplication.data.network.ClientApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ClientServiceModule {

    private static volatile ClientServiceModule clientService = null;

    private ClientServiceModule() {

    }

    public static ClientServiceModule getInstance() {
        if (clientService == null) {
            synchronized (ClientServiceModule.class) {
                if (clientService == null) {
                    clientService = new ClientServiceModule();
                }
            }
        }
        return clientService;
    }


    @Provides
    @Singleton
    public ClientApi createClientApi() {

        return new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(ClientApi.class);
    }
}
