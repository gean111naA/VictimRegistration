package com.example.VictimRegistration.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Victim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Phone Number is mandatory")
    @Pattern(regexp = "\\d{10}", message = "Phone Number must be 10 digits")
    private String phoneNumber;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;

    @NotBlank(message = "Address is mandatory")
    private String address;


    public Victim() {
    }

    public Victim(String email, String phoneNumber, String name, String address) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.address = address;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
