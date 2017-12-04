package com.christiankula.users.injection.components;


import com.christiankula.users.injection.modules.ApplicationModule;
import com.christiankula.users.injection.modules.NetworkModule;
import com.christiankula.users.injection.modules.PersistenceModule;
import com.christiankula.users.injection.modules.UserDetailsModule;
import com.christiankula.users.injection.modules.UsersListModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class, UsersListModule.class, UserDetailsModule.class,
        PersistenceModule.class})
interface ApplicationComponent extends UsersAppComponent {

}
