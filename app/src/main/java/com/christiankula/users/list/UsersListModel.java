package com.christiankula.users.list;

import com.christiankula.users.list.persistence.UsersPersistenceService;
import com.christiankula.users.list.rest.UsersService;
import com.christiankula.users.list.rest.models.User;
import com.christiankula.users.list.rest.models.UsersResult;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Callback;

public class UsersListModel implements UsersListMvp.Model {

    private final UsersService usersService;
    private final UsersPersistenceService usersPersistenceService;

    @Inject
    public UsersListModel(UsersService usersService, UsersPersistenceService usersPersistenceService) {
        this.usersService = usersService;
        this.usersPersistenceService = usersPersistenceService;
    }

    @Override
    public void getUsers(Callback<UsersResult> callback) {
        usersService.getUsers().enqueue(callback);
    }

    @Override
    public List<User> getUsersFromCache() {
        return usersPersistenceService.getUsers();
    }

    @Override
    public void saveUsers(List<User> users) {
        usersPersistenceService.saveUsers(users);
    }
}
