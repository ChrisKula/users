package com.christiankula.users.injection.modules;


import com.christiankula.users.list.persistence.UsersPersistenceService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

@Module
public class PersistenceModule {

    @Provides
    @Singleton
    Realm provideRealmInstance() {
        return Realm.getDefaultInstance();
    }

    @Provides
    @Singleton
    UsersPersistenceService provideUsersPersistenceService(Realm realm) {
        return new UsersPersistenceService(realm);
    }
}
