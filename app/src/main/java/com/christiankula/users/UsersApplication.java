package com.christiankula.users;

import android.app.Application;

import com.christiankula.users.injection.components.DaggerApplicationComponent;
import com.christiankula.users.injection.components.UsersAppComponent;
import com.christiankula.users.injection.modules.ApplicationModule;
import com.christiankula.users.injection.modules.NetworkModule;
import com.christiankula.users.injection.modules.PersistenceModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;


public class UsersApplication extends Application {

    private final UsersAppComponent component = createUsersAppComponent();


    @Override
    public void onCreate() {
        super.onCreate();
        initRealm();
    }

    private void initRealm() {
        Realm.init(this);

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);
    }

    protected UsersAppComponent createUsersAppComponent() {
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule())
                .persistenceModule(new PersistenceModule())
                .build();
    }

    public UsersAppComponent getComponent() {
        return component;
    }
}
