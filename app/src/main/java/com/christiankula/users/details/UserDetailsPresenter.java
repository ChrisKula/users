package com.christiankula.users.details;

import com.christiankula.users.list.rest.models.User;
import com.christiankula.users.utils.StringUtils;

import java.util.Date;

import javax.inject.Inject;

public class UserDetailsPresenter implements UserDetailsMvp.Presenter {

    private UserDetailsMvp.View userDetailsView;
    private UserDetailsMvp.Model userDetailsModel;

    @Inject
    public UserDetailsPresenter(UserDetailsMvp.Model userDetailsModel) {
        this.userDetailsModel = userDetailsModel;
    }

    @Override
    public void attachView(UserDetailsMvp.View view) {
        this.userDetailsView = view;

        userDetailsModel.setCurrentDisplayedUser(userDetailsView.getUserFromIntent());
    }

    @Override
    public void detachView() {
        this.userDetailsView = null;
    }


    @Override
    public void onCreate() {
        User user = userDetailsModel.getCurrentDisplayedUser();

        userDetailsView.setUserTitle(StringUtils.capitalize(user.getName().getTitle()));
        userDetailsView.setUserFirstName(StringUtils.capitalize(user.getName().getFirst()));
        userDetailsView.setUserLastName(StringUtils.capitalize(user.getName().getLast()));

        userDetailsView.setUserGender(user.getGender());

        userDetailsView.setUserEmail(user.getEmail());

        userDetailsView.setUserNationality(user.getNationality());

        userDetailsView.setUserProfilePicture(user.getProfilePicture().getLarge());

        userDetailsView.setUserPhone(user.getPhoneNumber());
        userDetailsView.setUserCellphone(user.getCellphoneNumber());

        userDetailsView.setUserAddress(user.getAddress().toString());

        userDetailsView.setUserDateOfBirth(new Date(user.getDateOfBirth() * 1000));

        userDetailsView.setUserRegisteredOn(new Date(user.getRegisteredOn() * 1000));

        userDetailsView.setUserId(user.getId().toString());

        userDetailsView.setUserLogin(user.getLogin().toString());
    }
}
