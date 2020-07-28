package com.test.myapplication.di.modules;


import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.test.myapplication.di.ViewModelKey;
import com.test.myapplication.viewmodel.UserViewModel;
import com.test.myapplication.viewmodel.ViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    //View Modelner@ Bind anelu hamar a mek el ViewModelFactoryn
    //ViewModelKey@ mer stexcacna vor@ @ndunum a merViewModel@
    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel.class)
    abstract ViewModel bindViewModel(UserViewModel userViewModel);


    @Binds
    abstract ViewModelProvider.Factory bindFactory(ViewModelFactory factory);

}
