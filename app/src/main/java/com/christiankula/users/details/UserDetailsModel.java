package com.christiankula.users.details;


import com.christiankula.users.list.rest.models.User;

import javax.inject.Inject;

public class UserDetailsModel implements UserDetailsMvp.Model {

    private User currentDisplayedUser;

    @Inject
    public UserDetailsModel() {

    }

    @Override
    public User getCurrentDisplayedUser() {
        return currentDisplayedUser;
    }

    @Override
    public void setCurrentDisplayedUser(User user) {
        this.currentDisplayedUser = user;
    }
}
