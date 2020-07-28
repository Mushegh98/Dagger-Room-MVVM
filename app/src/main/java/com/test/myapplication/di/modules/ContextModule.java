package com.test.myapplication.di.modules;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ContextModule {

    //mer modulner@ nshum enq Module Annotacioni mej
        private final Context context;

        public ContextModule(Context context) {
            this.context = context;
        }

        //Context@ Bind enq anum
        @Binds
        abstract Context bindContext(Application application);


}
