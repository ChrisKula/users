package com.christiankula.users;

import android.app.Application;

import com.christiankula.users.injection.components.DaggerApplicationComponent;
import com.christiankula.users.injection.components.UsersAppComponent;
import com.christiankula.users.injection.modules.ApplicationModule;
import com.christiankula.users.injection.modules.NetworkModule;


public class UsersApplication extends Application {

    private final UsersAppComponent component = createUsersAppComponent();

    protected UsersAppComponent createUsersAppComponent() {
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule())
                .build();
    }

    public UsersAppComponent getComponent() {
        return component;
    }
}
