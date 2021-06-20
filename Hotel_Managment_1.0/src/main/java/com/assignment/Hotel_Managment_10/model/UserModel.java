package com.assignment.Hotel_Managment_10.model;

import javax.persistence.*;

@Entity
@Table(name="user_details")
public class UserModel {
    private static  final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    public UserModel(String firstName, String lastName, String locatedAt, String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.locatedAt = locatedAt;
        this.emailId = emailId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLocatedAt(String locatedAt) {
        this.locatedAt = locatedAt;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    private String firstName;

    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private String locatedAt;

    private String emailId;

    public String getLocatedAt() {
        return locatedAt;
    }

    public String getEmailId() {
        return emailId;
    }


    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", locatedAt='" + locatedAt + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
