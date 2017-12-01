package com.christiankula.users.list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.christiankula.users.R;
import com.christiankula.users.UsersApplication;
import com.christiankula.users.rest.UsersService;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UsersListActivity extends AppCompatActivity {


    @Inject
    UsersService usersService;

    @BindView(R.id.rv_users)
    RecyclerView rvUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);

        ((UsersApplication) getApplication()).getComponent().inject(this);

        ButterKnife.bind(this);
    }
}
