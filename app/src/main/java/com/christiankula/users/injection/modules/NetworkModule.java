package com.christiankula.users.injection.modules;

import android.content.Context;

import com.christiankula.users.R;
import com.christiankula.users.list.rest.UsersService;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Module
public class NetworkModule {

    private final static String USERS_SERVICE_BASE_URL_NAME = "usersBaseUrl";

    @Provides
    @Singleton
    @Named(USERS_SERVICE_BASE_URL_NAME)
    String provideUsersServiceBaseUrl(Context context) {
        return context.getString(R.string.users_service_base_url);
    }

    @Singleton
    @Provides
    UsersService provideUsersService(@Named(USERS_SERVICE_BASE_URL_NAME) String usersServiceBaseUrl) {
        return new Retrofit.Builder()
                .baseUrl(usersServiceBaseUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(UsersService.class);
    }
}
