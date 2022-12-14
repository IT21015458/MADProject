package com.example.foodapp.classes;

public class Customer {
    private String uid;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String address;
    private String password;
    private final String role = "Customer";

    public Customer(){}

    public String getRole() { return role; }

    public String getUid() { return uid; }

    public void setUid(String uid) { this.uid = uid; }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
