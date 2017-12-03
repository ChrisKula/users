package com.christiankula.users.list.rest.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.realm.RealmModel;
import io.realm.annotations.RealmClass;

@RealmClass
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfilePicture implements RealmModel{

    @JsonProperty("large")
    private String large;

    @JsonProperty("medium")
    private String medium;

    @JsonProperty("thumbnail")
    private String thumbnail;

    @JsonProperty("large")
    public String getLarge() {
        return large;
    }

    @JsonProperty("large")
    public void setLarge(String large) {
        this.large = large;
    }

    @JsonProperty("medium")
    public String getMedium() {
        return medium;
    }

    @JsonProperty("medium")
    public void setMedium(String medium) {
        this.medium = medium;
    }

    @JsonProperty("thumbnail")
    public String getThumbnail() {
        return thumbnail;
    }

    @JsonProperty("thumbnail")
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}