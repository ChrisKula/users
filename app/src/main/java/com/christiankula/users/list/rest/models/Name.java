package com.christiankula.users.list.rest.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.parceler.Parcel;

import io.realm.RealmModel;
import io.realm.annotations.RealmClass;

@Parcel
@RealmClass
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Name implements RealmModel{

    @JsonProperty("title")
    String title;

    @JsonProperty("first")
    String first;

    @JsonProperty("last")
    String last;

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("first")
    public String getFirst() {
        return first;
    }

    @JsonProperty("first")
    public void setFirst(String first) {
        this.first = first;
    }

    @JsonProperty("last")
    public String getLast() {
        return last;
    }

    @JsonProperty("last")
    public void setLast(String last) {
        this.last = last;
    }
}