package com.christiankula.users.list.persistence;


import com.christiankula.users.list.rest.models.User;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;

public class UsersPersistenceService {
    private final Realm realm;

    @Inject
    public UsersPersistenceService(Realm realm) {
        this.realm = realm;
    }


    public List<User> getUsers(){
        return realm.where(User.class).findAll();
    }


    public void saveUsers(final List<User> users){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(users);
            }
        });
    }

}
