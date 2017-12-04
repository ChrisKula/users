package com.christiankula.users.injection.modules;

import com.christiankula.users.details.UserDetailsModel;
import com.christiankula.users.details.UserDetailsMvp;
import com.christiankula.users.details.UserDetailsPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UserDetailsModule {

    @Singleton
    @Provides
    UserDetailsMvp.Model provideModel() {
        return new UserDetailsModel();
    }

    @Singleton
    @Provides
    UserDetailsMvp.Presenter providePresenter(UserDetailsMvp.Model model) {
        return new UserDetailsPresenter(model);
    }
}
