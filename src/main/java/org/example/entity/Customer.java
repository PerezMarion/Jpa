package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="company_name")
    private String companyName;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    private String phone;
    private String email;
    private String address;
    @Column(name="zip_code")
    private String zipCode;
    private String city;
    private String country;
    private int state;

    public Customer() {
    }

    public Customer(String firstName) {
        this.firstName = firstName;
    }

    public Customer(Long id, String companyName, String firstName, String lastName, String phone,
                    String email, String address, String zipCode, String city, String country, int state) {
        this.id = id;
        this.companyName = companyName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}