package com.christiankula.users.list;

import com.christiankula.users.list.rest.UsersService;
import com.christiankula.users.list.rest.models.User;
import com.christiankula.users.list.rest.models.UsersResult;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Callback;

public class UsersListModel implements UsersListMvp.Model {

    private final UsersService usersService;

    @Inject
    public UsersListModel(UsersService usersService) {
        this.usersService = usersService;
    }

    @Override
    public void getUsers(Callback<UsersResult> callback) {
        usersService.getUsers().enqueue(callback);
    }

    @Override
    public List<User> getUsersFromCache() {
        //TODO implement caching mechanism
        return new ArrayList<>();
    }
}
