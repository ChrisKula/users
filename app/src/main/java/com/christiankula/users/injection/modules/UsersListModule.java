package com.christiankula.users.injection.modules;

import com.christiankula.users.list.UsersListModel;
import com.christiankula.users.list.UsersListMvp;
import com.christiankula.users.list.UsersListPresenter;
import com.christiankula.users.list.persistence.UsersPersistenceService;
import com.christiankula.users.list.rest.UsersService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UsersListModule {

    @Provides
    @Singleton
    UsersListMvp.Model provideModel(UsersService usersService, UsersPersistenceService usersPersistenceService) {
        return new UsersListModel(usersService, usersPersistenceService);
    }


    @Singleton
    @Provides
    UsersListMvp.Presenter providePresenter(UsersListMvp.Model model) {
        return new UsersListPresenter(model);
    }
}
