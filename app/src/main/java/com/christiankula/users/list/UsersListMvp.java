package com.christiankula.users.list;

import com.christiankula.users.mvp.BasePresenter;
import com.christiankula.users.mvp.BaseView;
import com.christiankula.users.rest.models.User;
import com.christiankula.users.rest.models.UsersResult;

import java.util.List;

import retrofit2.Callback;

public interface UsersListMvp {

    interface Model {
        void getUsers(Callback<UsersResult> callback);

        List<User> getUsersFromCache();
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
    }
}
