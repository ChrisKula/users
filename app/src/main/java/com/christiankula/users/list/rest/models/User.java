package com.christiankula.users.list.rest.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("name")
    private Name name;

    @JsonProperty("location")
    private Address address;

    @JsonProperty("email")
    private String email;

    @JsonProperty("login")
    private Login login;

    @JsonProperty("registered")
    private int registered;

    @JsonProperty("dob")
    private int dateOfBirth;

    @JsonProperty("phone")
    private String phoneNumber;

    @JsonProperty("cell")
    private String cellphoneNumber;

    @JsonProperty("id")
    private Id id;

    @JsonProperty("picture")
    private ProfilePicture profilePicture;

    @JsonProperty("nat")
    private String nationality;

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

    @JsonProperty("registered")
    public int getRegistered() {
        return registered;
    }

    @JsonProperty("registered")
    public void setRegistered(int registered) {
        this.registered = registered;
    }

    @JsonProperty("dob")
    public int getDateOfBirth() {
        return dateOfBirth;
    }

    @JsonProperty("dob")
    public void setDateOfBirth(int dateOfBirth) {
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