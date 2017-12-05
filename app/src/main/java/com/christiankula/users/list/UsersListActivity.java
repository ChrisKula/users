package com.christiankula.users.list;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.christiankula.users.R;
import com.christiankula.users.UsersApplication;
import com.christiankula.users.list.rest.models.User;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UsersListActivity extends AppCompatActivity implements UsersListMvp.View {

    @BindView(R.id.srl_root_view)
    SwipeRefreshLayout srlRootView;

    @BindView(R.id.rv_users)
    RecyclerView rvUsers;

    @BindView(R.id.tv_no_users_found)
    TextView tvNoUsersFound;

    private UsersListMvp.Presenter usersListPresenter;

    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);

        ((UsersApplication) getApplication()).getComponent().inject(this);

        ButterKnife.bind(this);

        initSwipeRefreshLayout();
        initRecyclerView();

        usersListPresenter.attachView(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        usersListPresenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        usersListPresenter.detachView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.user_list_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_sort_by_last_name:
                usersListPresenter.onSortByLastNameMenuItemClick();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Inject
    @Override
    public void setPresenter(UsersListMvp.Presenter presenter) {
        this.usersListPresenter = presenter;
    }

    @Override
    public void showUsersList(List<User> users) {
        tvNoUsersFound.setVisibility(View.GONE);

        userAdapter.setData(users);
        rvUsers.setVisibility(View.VISIBLE);
    }

    @Override
    public void showNoUsersFoundMessage() {
        rvUsers.setVisibility(View.GONE);

        tvNoUsersFound.setVisibility(View.VISIBLE);
    }

    @Override
    public void showInOfflineMode() {
        Snackbar.make(findViewById(android.R.id.content), R.string.snackbar_alert_offline_mode, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void setRefreshing(boolean enable) {
        srlRootView.setRefreshing(enable);
    }

    private void initSwipeRefreshLayout() {
        srlRootView.setColorSchemeColors(ContextCompat.getColor(this, R.color.colorPrimary),
                ContextCompat.getColor(this, R.color.colorAccent));

        srlRootView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                usersListPresenter.onRefresh();
            }
        });
    }

    private void initRecyclerView() {
        userAdapter = new UserAdapter(new ArrayList<User>());

        rvUsers.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvUsers.setAdapter(userAdapter);
    }
}
