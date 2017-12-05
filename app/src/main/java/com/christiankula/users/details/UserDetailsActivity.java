package com.christiankula.users.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.christiankula.users.R;
import com.christiankula.users.UsersApplication;
import com.christiankula.users.list.rest.models.User;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserDetailsActivity extends AppCompatActivity implements UserDetailsMvp.View {

    public static final String USER_EXTRA = "USER";

    @BindView(R.id.iv_user_profile_picture)
    ImageView ivUserProfilePicture;

    @BindView(R.id.tv_user_title)
    TextView tvUserTitle;

    @BindView(R.id.tv_user_first_name)
    TextView tvUserFirstName;

    @BindView(R.id.tv_user_last_name)
    TextView tvUserLastName;

    @BindView(R.id.udsv_user_gender)
    UserDetailSectionView usdvUserGender;

    @BindView(R.id.udsv_user_email)
    UserDetailSectionView usdvUserEmail;

    @BindView(R.id.udsv_user_address)
    UserDetailSectionView usdvUserAddress;

    @BindView(R.id.udsv_user_phone)
    UserDetailSectionView usdvUserPhone;

    @BindView(R.id.udsv_user_cellphone)
    UserDetailSectionView usdvUserCellPhone;

    @BindView(R.id.udsv_user_date_of_birth)
    UserDetailSectionView usdvUserDateOfBirth;

    @BindView(R.id.udsv_user_nationality)
    UserDetailSectionView usdvUserNationality;

    @BindView(R.id.udsv_user_registered_on)
    UserDetailSectionView usdvUserRegisteredOn;

    @BindView(R.id.udsv_user_id)
    UserDetailSectionView usdvUserId;

    @BindView(R.id.udsv_user_login)
    UserDetailSectionView usdvUserLogin;

    private UserDetailsMvp.Presenter userDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        ((UsersApplication) getApplication()).getComponent().inject(this);

        ButterKnife.bind(this);

        userDetailsPresenter.attachView(this);
        userDetailsPresenter.onCreate();
    }

    @Override
    protected void onDestroy() {
        userDetailsPresenter.detachView();

        super.onDestroy();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Inject
    @Override
    public void setPresenter(UserDetailsMvp.Presenter presenter) {
        this.userDetailsPresenter = presenter;
    }

    @Override
    public User getUserFromIntent() {
        return Parcels.unwrap(getIntent().getParcelableExtra(USER_EXTRA));
    }

    @Override
    public void setUserProfilePicture(String pictureUrl) {
        Picasso.with(this).
                load(pictureUrl)
                .placeholder(R.drawable.ic_person_color_primary_24dp)
                .into(ivUserProfilePicture);
    }

    @Override
    public void setUserTitle(String title) {
        tvUserTitle.setText(title);
    }

    @Override
    public void setUserFirstName(String firstName) {
        tvUserFirstName.setText(firstName);
    }

    @Override
    public void setUserLastName(String lastName) {
        tvUserLastName.setText(lastName);
    }

    @Override
    public void setUserGender(String gender) {
        usdvUserGender.setText(gender);
    }

    @Override
    public void setUserEmail(String email) {
        usdvUserEmail.setText(email);
    }

    @Override
    public void setUserAddress(String address) {
        usdvUserAddress.setText(address);
    }

    @Override
    public void setUserPhone(String phone) {
        usdvUserPhone.setText(phone);
    }

    @Override
    public void setUserCellphone(String cellphone) {
        usdvUserCellPhone.setText(cellphone);
    }

    @Override
    public void setUserDateOfBirth(Date dateOfBirth) {
        SimpleDateFormat sdf = new SimpleDateFormat(getString(R.string.day_month_year_date_format), Locale.getDefault());
        usdvUserDateOfBirth.setText(sdf.format(dateOfBirth));
    }

    @Override
    public void setUserNationality(String nationality) {
        usdvUserNationality.setText(nationality);
    }

    @Override
    public void setUserRegisteredOn(Date registeredOn) {
        SimpleDateFormat sdf = new SimpleDateFormat(getString(R.string.day_month_year_date_format), Locale.getDefault());
        usdvUserRegisteredOn.setText(sdf.format(registeredOn));
    }

    @Override
    public void setUserId(String id) {
        usdvUserId.setText(id);
    }

    @Override
    public void setUserLogin(String login) {
        usdvUserLogin.setText(login);
    }
}
