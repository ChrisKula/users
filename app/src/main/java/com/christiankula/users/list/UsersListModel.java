package com.christiankula.users.list;

import com.christiankula.users.list.persistence.UsersPersistenceService;
import com.christiankula.users.list.rest.UsersService;
import com.christiankula.users.list.rest.models.User;
import com.christiankula.users.list.rest.models.UsersResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Callback;

public class UsersListModel implements UsersListMvp.Model {

    static final int SORT_UNSORTED = -1;
    static final int SORT_ASCENDING = 0;
    static final int SORT_DESCENDING = 1;

    private final UsersService usersService;
    private final UsersPersistenceService usersPersistenceService;

    private List<User> currentDisplayedUsers;

    private int currentUsersSortOrder;

    @Inject
    public UsersListModel(UsersService usersService, UsersPersistenceService usersPersistenceService) {
        this.usersService = usersService;
        this.usersPersistenceService = usersPersistenceService;

        currentDisplayedUsers = new ArrayList<>();
        currentUsersSortOrder = SORT_UNSORTED;
    }

    @Override
    public void setCurrentDisplayedUsers(List<User> currentDisplayedUsers) {
        this.currentDisplayedUsers = currentDisplayedUsers;
        currentUsersSortOrder = SORT_UNSORTED;
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

    @Override
    public List<User> sortUsersList(int sortOrder) {
        if (sortOrder == SORT_ASCENDING || sortOrder == SORT_DESCENDING) {
            Collections.sort(currentDisplayedUsers);

            currentUsersSortOrder = sortOrder;

            if (sortOrder == SORT_DESCENDING) {
                Collections.reverse(currentDisplayedUsers);
            }
        }

        return currentDisplayedUsers;
    }

    @Override
    public int getCurrentUsersSortOrder() {
        return currentUsersSortOrder;
    }

    @Override
    public List<User> getCurrentDisplayedUsers() {
        return currentDisplayedUsers;
    }
}
