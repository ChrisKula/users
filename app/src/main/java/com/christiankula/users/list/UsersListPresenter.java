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
    }

    @Override
    public void onResume() {
        updateUsers();
    }

    @Override
    public void onRefresh() {
        updateUsers();
    }

    @Override
    public void onResponse(@NonNull Call<UsersResult> call, @NonNull Response<UsersResult> response) {
        if (response.isSuccessful()) {
            List<User> users = response.body().getUsers();

            if (users == null || users.isEmpty()) {
                usersListView.showNoUsersFoundMessage();
            } else {
                usersListModel.saveUsers(users);
                usersListView.showUsersList(users);
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

    private void updateUsers() {
        usersListView.setRefreshing(true);

        usersListModel.getUsers(this);
    }

    private void showUsersFromCache() {
        usersListView.showInOfflineMode();

        List<User> users = usersListModel.getUsersFromCache();
        if (users.isEmpty()) {
            usersListView.showNoUsersFoundMessage();
        } else {
            usersListView.showUsersList(usersListModel.getUsersFromCache());
        }

        usersListView.setRefreshing(false);
    }
}
