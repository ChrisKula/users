package com.christiankula.users.details;

import com.christiankula.users.list.rest.models.Address;
import com.christiankula.users.list.rest.models.Id;
import com.christiankula.users.list.rest.models.Login;
import com.christiankula.users.list.rest.models.Name;
import com.christiankula.users.list.rest.models.ProfilePicture;
import com.christiankula.users.list.rest.models.User;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Date;

public class UserDetailsPresenterTest {

    @Mock
    private UserDetailsMvp.Model model;

    @Mock
    private UserDetailsMvp.View view;

    private UserDetailsMvp.Presenter presenter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        presenter = new UserDetailsPresenter(model);
        presenter.attachView(view);

        User user = new User();

        Name name = new Name();

        name.setFirst("John");
        name.setLast("Doe");
        name.setTitle("Mr");

        ProfilePicture profilePicture = new ProfilePicture();

        profilePicture.setLarge("");
        profilePicture.setMedium("");
        profilePicture.setThumbnail("");

        user.setProfilePicture(profilePicture);
        user.setName(name);
        user.setGender("");
        user.setEmail("john.doa@example.com");
        user.setAddress(new Address());
        user.setPhoneNumber("");
        user.setCellphoneNumber("");
        user.setDateOfBirth(1000);
        user.setId(new Id());
        user.setNationality("FR");
        user.setRegisteredOn(2000);

        user.setLogin(new Login());

        Mockito.when(model.getCurrentDisplayedUser()).thenReturn(user);
    }


    @Test
    public void OnCreate_Should_Display_User_Info() {
        presenter.onCreate();

        Mockito.verify(model, Mockito.times(1)).getCurrentDisplayedUser();

        Mockito.verify(view, Mockito.times(1)).setUserTitle(Mockito.anyString());
        Mockito.verify(view, Mockito.times(1)).setUserFirstName(Mockito.anyString());
        Mockito.verify(view, Mockito.times(1)).setUserLastName(Mockito.anyString());
        Mockito.verify(view, Mockito.times(1)).setUserGender(Mockito.anyString());
        Mockito.verify(view, Mockito.times(1)).setUserNationality(Mockito.anyString());
        Mockito.verify(view, Mockito.times(1)).setUserProfilePicture(Mockito.anyString());
        Mockito.verify(view, Mockito.times(1)).setUserCellphone(Mockito.anyString());
        Mockito.verify(view, Mockito.times(1)).setUserPhone(Mockito.anyString());
        Mockito.verify(view, Mockito.times(1)).setUserAddress(Mockito.anyString());
        Mockito.verify(view, Mockito.times(1)).setUserEmail(Mockito.anyString());
        Mockito.verify(view, Mockito.times(1)).setUserDateOfBirth(Mockito.any(Date.class));
        Mockito.verify(view, Mockito.times(1)).setUserRegisteredOn(Mockito.any(Date.class));
        Mockito.verify(view, Mockito.times(1)).setUserId(Mockito.anyString());
        Mockito.verify(view, Mockito.times(1)).setUserLogin(Mockito.anyString());
    }


}
