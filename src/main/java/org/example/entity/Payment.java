package org.example.entity;

import com.sun.tools.javac.api.ClientCodeWrapper;

import javax.persistence.*;

@Entity
@Table(name="payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @Column(name = "id_client")
    private Customer customer;

    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "confidential_code")
    private String confidentialCode;
    private String bank;


    public Payment() {
    }

    public Payment(Long id, String cardNumber, String confidentialCode, String bank, Customer customer) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.confidentialCode = confidentialCode;
        this.bank = bank;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getConfidentialCode() {
        return confidentialCode;
    }

    public void setConfidentialCode(String confidentialCode) {
        this.confidentialCode = confidentialCode;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setNotNullData(Payment newPaymentData) {

        if(newPaymentData.getCustomer() != null) {
            this.setCustomer(newPaymentData.getCustomer());
        }

        if(newPaymentData.getCardNumber() != null) {
            this.setCardNumber(newPaymentData.getCardNumber());
        }

        if(newPaymentData.getConfidentialCode() != null) {
            this.setConfidentialCode(newPaymentData.getConfidentialCode());
        }

        if(newPaymentData.getBank() != null) {
            this.setBank(newPaymentData.getBank());
        }
    }

    @Override
    public String toString() {
        return "Payment{" + "id=" + id + ", cardNumber='" + cardNumber + '\'' +
                ", confidentialCode='" + confidentialCode + '\'' + ", bank='" + bank + '\'' +
                ", customer=" + customer + '}';
    }
}