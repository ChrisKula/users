package com.christiankula.users.list;

import android.support.annotation.NonNull;

import com.christiankula.users.list.rest.models.User;
import com.christiankula.users.list.rest.models.UsersResult;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersListPresenter implements UsersListMvp.Presenter, Callback<UsersResult> {

    private static final String TAG = UsersListPresenter.class.getSimpleName();

    private UsersListMvp.View usersListView;

    private UsersListMvp.Model usersListModel;

    @Inject
    public UsersListPresenter(UsersListMvp.Model model) {
        this.usersListModel = model;
    }

    @Override
    public void attachView(UsersListMvp.View view) {
        this.usersListView = view;
    }

    @Override
    public void detachView() {
        this.usersListView = null;

        usersListModel.setCurrentDisplayedUsers(null);
    }

    @Override
    public void onResume() {
        List<User> users = usersListModel.getCurrentDisplayedUsers();

        if (users == null || users.isEmpty()) {
            usersListView.setRefreshing(true);

            usersListModel.getUsers(this);
        }
    }

    @Override
    public void onRefresh() {
        usersListModel.getUsers(this);
    }

    @Override
    public void onSortByLastNameMenuItemClick() {
        int sortOrder = usersListModel.getCurrentUsersSortOrder();

        switch (sortOrder) {
            case UsersListModel.SORT_UNSORTED:
            case UsersListModel.SORT_DESCENDING:
                usersListView.showUsersList(usersListModel.sortUsersList(UsersListModel.SORT_ASCENDING));
                break;

            case UsersListModel.SORT_ASCENDING:
                usersListView.showUsersList(usersListModel.sortUsersList(UsersListModel.SORT_DESCENDING));
                break;
        }
    }

    @Override
    public void onResponse(@NonNull Call<UsersResult> call, @NonNull Response<UsersResult> response) {
        if (response.isSuccessful()) {
            List<User> users = response.body().getUsers();

            if (users == null || users.isEmpty()) {
                usersListView.showNoUsersFoundMessage();
            } else {
                showUsers(users);

                usersListModel.saveUsers(users);
            }

            usersListView.setRefreshing(false);
        } else {
            showUsersFromCache();
        }
    }

    @Override
    public void onFailure(@NonNull Call<UsersResult> call, @NonNull Throwable t) {
        showUsersFromCache();
    }

    private void showUsers(List<User> users) {
        usersListView.showUsersList(users);

        usersListModel.setCurrentDisplayedUsers(users);
    }

    private void showUsersFromCache() {
        usersListView.showInOfflineMode();

        List<User> users = usersListModel.getUsersFromCache();
        if (users.isEmpty()) {
            usersListView.showNoUsersFoundMessage();
        } else {
            showUsers(users);
        }

        usersListView.setRefreshing(false);
    }
}
