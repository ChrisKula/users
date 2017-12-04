package com.christiankula.users.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.christiankula.users.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserDetailsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        ButterKnife.bind(this);

    }



    }
}
