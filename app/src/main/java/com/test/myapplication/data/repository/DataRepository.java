package com.test.myapplication.data.repository;

import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;

import com.test.myapplication.data.dao.UserDao;
import com.test.myapplication.data.model.User;
import com.test.myapplication.data.network.ClientApi;
import com.test.myapplication.data.network.NetworkBoundStatusResource;
import com.test.myapplication.data.resource.StatusResource;
import com.test.myapplication.data.database.DatabaseBuilder;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class DataRepository {

    private ClientApi clientApi;
    private UserDao userDao;

    @Inject
    public DataRepository(ClientApi userService) {
        this.clientApi = userService;
        userDao = DatabaseBuilder.getInstance().getUserDao();
    }

    public MutableLiveData<StatusResource<User>> getUser() {
        return new NetworkBoundStatusResource<User>() {

            @Override
            protected void createCall() {
                clientApi.getUserModel()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(user -> {
                            postMutableLiveData(StatusResource.success(user));
                        }, thowable -> {
                            postMutableLiveData(StatusResource.error(thowable.getMessage()));
                        });
            }
        }.getMutableLiveData();

    }

    public MutableLiveData<StatusResource<Boolean>> insertUser(User user) {
        return new NetworkBoundStatusResource<Boolean>() {

            @Override
            protected void createCall() {
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        userDao.insert(user);
                        postMutableLiveData(StatusResource.success(true));
                    }
                });
            }
        }.getMutableLiveData();
    }

    public MutableLiveData<StatusResource<User>> getUserRoom() {
        return new NetworkBoundStatusResource<User>() {
            @Override
            protected void createCall() {
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        postMutableLiveData(StatusResource.success(userDao.getUser()));
                    }
                });
            }
        }.getMutableLiveData();
    }
}
