package com.christiankula.users.list.rest.models;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsersResult {

    @JsonProperty("results")
    private List<User> users;

    @JsonProperty("info")
    private ResultInfo resultInfo;

    @JsonProperty("results")
    public List<User> getUsers() {
        return users;
    }

    @JsonProperty("results")
    public void setUsers(List<User> users) {
        this.users = users;
    }

    @JsonProperty("info")
    public ResultInfo getResultInfo() {
        return resultInfo;
    }

    @JsonProperty("info")
    public void setResultInfo(ResultInfo resultInfo) {
        this.resultInfo = resultInfo;
    }
}
