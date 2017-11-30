package com.christiankula.users.injection.components;


import com.christiankula.users.injection.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
interface ApplicationComponent extends UsersAppComponent {

}
