package com.christiankula.users.list.rest.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.parceler.Parcel;

import io.realm.RealmModel;
import io.realm.annotations.RealmClass;

@Parcel
@RealmClass
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User implements RealmModel {

    @JsonProperty("gender")
    String gender;

    @JsonProperty("name")
    Name name;

    @JsonProperty("location")
    Address address;

    @JsonProperty("email")
    String email;

    @JsonProperty("login")
    Login login;

    @JsonProperty("registered")
    long registeredOn;

    @JsonProperty("dob")
    long dateOfBirth;

    @JsonProperty("phone")
    String phoneNumber;

    @JsonProperty("cell")
    String cellphoneNumber;

    @JsonProperty("id")
    Id id;

    @JsonProperty("picture")
    ProfilePicture profilePicture;

    @JsonProperty("nat")
    String nationality;

    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonProperty("name")
    public Name getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(Name name) {
        this.name = name;
    }

    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(Address address) {
        this.address = address;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("login")
    public Login getLogin() {
        return login;
    }

    @JsonProperty("login")
    public void setLogin(Login login) {
        this.login = login;
    }

    /**
     * Returns date of birth as epoch
     */
    @JsonProperty("registered")
    public long getRegisteredOn() {
        return registeredOn;
    }

    @JsonProperty("registered")
    public void setRegisteredOn(long registeredOn) {
        this.registeredOn = registeredOn;
    }

    /**
     * Returns date of birth as epoch
     */
    @JsonProperty("dob")
    public long getDateOfBirth() {
        return dateOfBirth;
    }

    @JsonProperty("dob")
    public void setDateOfBirth(long dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @JsonProperty("phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @JsonProperty("phoneNumber")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JsonProperty("cellphoneNumber")
    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    @JsonProperty("cellphoneNumber")
    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }

    @JsonProperty("id")
    public Id getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Id id) {
        this.id = id;
    }

    @JsonProperty("profilePicture")
    public ProfilePicture getProfilePicture() {
        return profilePicture;
    }

    @JsonProperty("profilePicture")
    public void setProfilePicture(ProfilePicture profilePicture) {
        this.profilePicture = profilePicture;
    }

    @JsonProperty("nationality")
    public String getNationality() {
        return nationality;
    }

    @JsonProperty("nationality")
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}