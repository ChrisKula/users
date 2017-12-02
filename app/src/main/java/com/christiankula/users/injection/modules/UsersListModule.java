package com.christiankula.users.injection.modules;

import com.christiankula.users.list.UsersListModel;
import com.christiankula.users.list.UsersListMvp;
import com.christiankula.users.list.UsersListPresenter;
import com.christiankula.users.rest.UsersService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UsersListModule {

    @Provides
    @Singleton
    UsersListMvp.Model provideModel(UsersService usersService) {
        return new UsersListModel(usersService);
    }


    @Singleton
    @Provides
    UsersListMvp.Presenter providePresenter(UsersListMvp.Model model) {
        return new UsersListPresenter(model);
    }
}
