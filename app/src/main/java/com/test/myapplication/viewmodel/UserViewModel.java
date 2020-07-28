package com.test.myapplication.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.test.myapplication.data.model.User;
import com.test.myapplication.data.repository.DataRepository;
import com.test.myapplication.data.resource.StatusResource;
import javax.inject.Inject;

public class UserViewModel extends ViewModel {

    private DataRepository userRepository;


    //Inject enq anum vortex kdrvi Repoyi instance@
    @Inject
    public UserViewModel(DataRepository userRepository) {
        this.userRepository = userRepository;
    }

    public MutableLiveData<StatusResource<User>> getUser(){
        return userRepository.getUser();
    }

    public MutableLiveData<StatusResource<Boolean>> insertUser(User user){
       return userRepository.insertUser(user);
    }

    public MutableLiveData<StatusResource<User>> getUserRoom(){
       return userRepository.getUserRoom();
    }


}
