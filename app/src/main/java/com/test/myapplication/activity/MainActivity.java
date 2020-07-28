package com.test.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.Toast;

import com.test.myapplication.R;
import com.test.myapplication.application.App;
import com.test.myapplication.data.model.User;
import com.test.myapplication.data.resource.StatusResource;
import com.test.myapplication.viewmodel.UserViewModel;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((App) getApplication()).getAppComponent().inject(this);
        userViewModel = ViewModelProviders.of(this,viewModelFactory).get(UserViewModel.class);

        userViewModel.getUser().observe(this, new Observer<StatusResource<User>>() {
            @Override
            public void onChanged(StatusResource<User> userModelStatusResource) {
                switch (userModelStatusResource.status){
                    case SUCCESS:
//                        Toast.makeText(MainActivity.this,userModelStatusResource.data.toString(),Toast.LENGTH_LONG).show();
                        userViewModel.insertUser(userModelStatusResource.data).observe(MainActivity.this, new Observer<StatusResource<Boolean>>() {
                            @Override
                            public void onChanged(StatusResource<Boolean> booleanStatusResource) {
                                switch (booleanStatusResource.status){
                                    case SUCCESS:
                                        userViewModel.getUserRoom().observe(MainActivity.this, new Observer<StatusResource<User>>() {
                                            @Override
                                            public void onChanged(StatusResource<User> userStatusResource) {
                                                switch (userStatusResource.status){
                                                    case SUCCESS:
                                                        Toast.makeText(MainActivity.this,userStatusResource.data.toString(),Toast.LENGTH_LONG).show();
                                                        break;
                                                    case LOADING:
                                                        break;
                                                    case ERROR:
                                                        break;
                                                }
                                            }
                                        });
                                        break;
                                    case LOADING:
                                        break;
                                    case ERROR:
                                        break;
                                }
                            }
                        });
                        break;
                    case LOADING:
                        break;
                    case ERROR:
                        break;
                }
            }
        });

    }
}