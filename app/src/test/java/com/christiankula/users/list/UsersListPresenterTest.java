package com.christiankula.users.list;

import com.christiankula.users.list.rest.models.Name;
import com.christiankula.users.list.rest.models.User;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class UsersListPresenterTest {

    @Mock
    private UsersListMvp.Model model;

    @Mock
    private UsersListMvp.View view;

    private UsersListMvp.Presenter presenter;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        presenter = new UsersListPresenter(model);
        presenter.attachView(view);

        User user = new User();
        Name name = new Name();

        name.setFirst("John");
        name.setLast("Doe");
        name.setTitle("Mr");

        user.setName(name);

        user.setEmail("john.doa@example.com");

        final List<User> users = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            users.add(user);
        }

        Mockito.when(model.getCurrentDisplayedUsers()).thenReturn(users);

        Mockito.when(model.getUsersFromCache()).thenReturn(users);
    }

    @Test
    public void OnResume_With_NoDisplayedUser_Should_Get_Users() {
        Mockito.when(model.getCurrentDisplayedUsers()).thenReturn(new ArrayList<User>());

        presenter.onResume();

        Mockito.verify(model, Mockito.times(1)).getCurrentDisplayedUsers();

        Mockito.verify(view, Mockito.times(1)).setRefreshing(Mockito.eq(true));

        Mockito.verify(model, Mockito.times(1)).getUsers((UsersListPresenter) presenter);
    }

    @Test
    public void OnResume_With_DisplayedUsers_Should_Not_Get_Users() {
        presenter.onResume();

        Mockito.verify(model, Mockito.times(1)).getCurrentDisplayedUsers();

        Mockito.verify(view, Mockito.times(0)).setRefreshing(Mockito.eq(true));

        Mockito.verify(model, Mockito.times(0)).getUsers((UsersListPresenter) presenter);
    }


    @Test
    public void OnRefresh_Should_Get_Users() {
        presenter.onRefresh();

        Mockito.verify(model, Mockito.times(1)).getUsers((UsersListPresenter) presenter);
    }

    @Test
    public void OnSortByLastNameMenuItemClick_With_Ascending_Sorting_Should_Sort_Descending() {
        Mockito.when(model.getCurrentUsersSortOrder()).thenReturn(UsersListModel.SORT_ASCENDING);

        presenter.onSortByLastNameMenuItemClick();

        Mockito.verify(view, Mockito.times(1)).showUsersList(Mockito.<User>anyList());

        Mockito.verify(model, Mockito.times(1)).sortUsersList(Mockito.eq(UsersListModel.SORT_DESCENDING));
    }

    @Test
    public void OnSortByLastNameMenuItemClick_With_Unsorted_Sorting_Should_Sort_Ascending() {
        Mockito.when(model.getCurrentUsersSortOrder()).thenReturn(UsersListModel.SORT_UNSORTED);

        presenter.onSortByLastNameMenuItemClick();

        Mockito.verify(view, Mockito.times(1)).showUsersList(Mockito.<User>anyList());

        Mockito.verify(model, Mockito.times(1)).sortUsersList(Mockito.eq(UsersListModel.SORT_ASCENDING));
    }

    @Test
    public void OnSortByLastNameMenuItemClick_With_Descending_Sorting_Should_Sort_Ascending() {
        Mockito.when(model.getCurrentUsersSortOrder()).thenReturn(UsersListModel.SORT_DESCENDING);

        presenter.onSortByLastNameMenuItemClick();

        Mockito.verify(view, Mockito.times(1)).showUsersList(Mockito.<User>anyList());

        Mockito.verify(model, Mockito.times(1)).sortUsersList(Mockito.eq(UsersListModel.SORT_ASCENDING));
    }
}
