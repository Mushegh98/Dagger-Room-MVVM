package com.test.myapplication.data.network;

import com.test.myapplication.data.model.User;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
  Interface for API Calls
 **/
public interface ClientApi {

    @GET("/users/2")
    Single<User> getUserModel();
}
