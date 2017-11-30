package com.christiankula.users.rest;


import com.christiankula.users.rest.models.UsersResult;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UsersService {

    @GET("api/1.0/?seed=lydia&results=10&page=1")
    Call<UsersResult> getUsers();

}
