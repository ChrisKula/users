package com.christiankula.users.list;

import com.christiankula.users.list.rest.models.User;
import com.christiankula.users.list.rest.models.UsersResult;
import com.christiankula.users.mvp.BasePresenter;
import com.christiankula.users.mvp.BaseView;

import java.util.List;

import retrofit2.Callback;

public interface UsersListMvp {

    interface Model {
        void getUsers(Callback<UsersResult> callback);

        List<User> getUsersFromCache();

        void saveUsers(List<User> users);

        List<User> sortUsersList(int sortOrder);

        int getCurrentUsersSortOrder();

        void setCurrentDisplayedUsers(List<User> currentDisplayedUsers);

        List<User> getCurrentDisplayedUsers();
    }

    interface View extends BaseView<Presenter> {
        void showUsersList(List<User> users);

        void showNoUsersFoundMessage();

        void showInOfflineMode();

        void setRefreshing(boolean enable);
    }

    interface Presenter extends BasePresenter<View> {
        void onRefresh();

        void onResume();

        void onSortByLastNameMenuItemClick();
    }
}
