package org.example.entity;

import org.example.utils.Gender;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_name")
    private String companyName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String phone;
    private String email;
    private String address;
    @Column(name = "zip_code")
    private String zipCode;
    private String city;
    private String country;
    private Integer state;

    // Valeurs attendues (grace à l'enum "gender") : 0:male, 1:female, 2:other
    private Gender gender;

    // On considère ici qu'un client ne peut avoir qu'une carte bleue
    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    // On considère ici que plusieurs clients peuvent avoir la même adresse de livraison
    // Many/Plusieurs clients To/Pour One/Une même adresse de livraison
    // (le premier mot correspond à la classe dans laquelle on met l'annotation)
    // Mais ici on considère qu'un client ne peut avoir qu'une seule adresse de livraison (pas de ManyToMany)
    @ManyToOne
    @JoinColumn(name = "delivery_address_id")
    private Address deliveryAddress;

    // On considère ici qu'un produit peut être acheté par plusieurs clients et qu'un client peut acheter
    // plusieurs fois le même produit
    @ManyToMany
    private List<Product> products = new ArrayList<>();


    public Customer() {
    }

    public Customer(String firstName) {
        this.firstName = firstName;
    }


    public Customer(Long id, String companyName, String firstName, String lastName, String phone,
                    String email, String address, String zipCode, String city, String country,
                    Integer state, Payment payment, Address deliveryAddress, List<Product> products, Gender gender) {
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
        this.payment = payment;
        this.deliveryAddress = deliveryAddress;
        this.products = products;
        this.gender = gender;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }


    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void setNotNullData(Customer newCustomerData) {

        if (newCustomerData.getCompanyName() != null) {
            this.setCompanyName(newCustomerData.getCompanyName());
        }

        if (newCustomerData.getFirstName() != null) {
            this.setFirstName(newCustomerData.getFirstName());
        }

        if (newCustomerData.getLastName() != null) {
            this.setLastName(newCustomerData.getLastName());
        }

        if (newCustomerData.getFirstName() != null) {
            this.setFirstName(newCustomerData.getFirstName());
        }

        if (newCustomerData.getPhone() != null) {
            this.setPhone(newCustomerData.getPhone());
        }

        if (newCustomerData.getEmail() != null) {
            this.setEmail(newCustomerData.getEmail());
        }

        if (newCustomerData.getAddress() != null) {
            this.setAddress(newCustomerData.getAddress());
        }

        if (newCustomerData.getZipCode() != null) {
            this.setZipCode(newCustomerData.getZipCode());
        }

        if (newCustomerData.getCity() != null) {
            this.setCity(newCustomerData.getCity());
        }

        if (newCustomerData.getCountry() != null) {
            this.setCountry(newCustomerData.getCountry());
        }

        if (newCustomerData.getState() != null) {
            this.setState(newCustomerData.getState());
        }
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", companyName='" + companyName + '\'' + ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' + ", phone='" + phone + '\'' + ", email='" + email + '\'' +
                ", address='" + address + '\'' + ", zipCode='" + zipCode + '\'' + ", city='" + city + '\'' +
                ", country='" + country + '\'' + ", state=" + state + ", payment=" + payment +
                ", deliveryAddress=" + deliveryAddress + ", products=" + products + ", gender=" + gender + '}';
    }
}