package com.christiankula.users.injection.components;


import com.christiankula.users.details.UserDetailsActivity;
import com.christiankula.users.list.UsersListActivity;

public interface UsersAppComponent {

    void inject(UsersListActivity target);

    void inject(UserDetailsActivity target);
}
