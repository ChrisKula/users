package com.christiankula.users.injection.components;


import com.christiankula.users.injection.modules.ApplicationModule;
import com.christiankula.users.injection.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
interface ApplicationComponent extends UsersAppComponent {

}
