package com.christiankula.users.details;


import com.christiankula.users.list.rest.models.User;
import com.christiankula.users.mvp.BasePresenter;
import com.christiankula.users.mvp.BaseView;

import java.util.Date;

public interface UserDetailsMvp {

    interface Model {
        User getCurrentDisplayedUser();

        void setCurrentDisplayedUser(User currentDisplayedUser);

    }

    interface View extends BaseView<Presenter> {
        User getUserFromIntent();

        void setUserProfilePicture(String pictureUrl);

        void setUserTitle(String title);

        void setUserFirstName(String firstName);

        void setUserLastName(String lastName);

        void setUserGender(String gender);

        void setUserEmail(String email);

        void setUserAddress(String address);

        void setUserPhone(String phone);

        void setUserCellphone(String cellphone);

        void setUserDateOfBirth(Date dateOfBirth);

        void setUserNationality(String nationality);

        void setUserRegisteredOn(Date registeredOn);

        void setUserId(String id);

        void setUserLogin(String login);
    }

    interface Presenter extends BasePresenter<View> {
        void onCreate();
    }
}
