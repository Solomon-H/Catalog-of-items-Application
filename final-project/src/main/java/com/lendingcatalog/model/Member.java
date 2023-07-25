package com.lendingcatalog.model;

public class Member {
    // This defines the attribute of the class.
    private String firstName;
    private String lastName;

    // member constructor that takes parameters
    public Member(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // getter method
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    // The toString method is used to convert to string
    public String toString() {
        return getFirstName() + " " + getLastName();
    }
}
