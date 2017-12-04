package com.christiankula.users.list.rest.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.parceler.Parcel;

import io.realm.RealmModel;
import io.realm.annotations.RealmClass;

@Parcel
@RealmClass
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Login implements RealmModel {

    @JsonProperty("username")
    String username;

    @JsonProperty("password")
    String password;

    @JsonProperty("salt")
    String salt;

    @JsonProperty("md5")
    String md5;

    @JsonProperty("sha1")
    String sha1;

    @JsonProperty("sha256")
    String sha256;

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty("salt")
    public String getSalt() {
        return salt;
    }

    @JsonProperty("salt")
    public void setSalt(String salt) {
        this.salt = salt;
    }

    @JsonProperty("md5")
    public String getMd5() {
        return md5;
    }

    @JsonProperty("md5")
    public void setMd5(String md5) {
        this.md5 = md5;
    }

    @JsonProperty("sha1")
    public String getSha1() {
        return sha1;
    }

    @JsonProperty("sha1")
    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

    @JsonProperty("sha256")
    public String getSha256() {
        return sha256;
    }

    @JsonProperty("sha256")
    public void setSha256(String sha256) {
        this.sha256 = sha256;
    }
}
