package org.example;

import org.example.dao.AddressDAO;
import org.example.dao.CustomerDAO;
import org.example.dao.PaymentDAO;
import org.example.entity.Address;
import org.example.entity.Customer;
import org.example.entity.Payment;
import org.junit.Test;
import static org.junit.Assert.*;

public class RelationshipTest {
    @Test
    public void oneToOne() {

        Payment payment = new Payment();
        payment.setCardNumber("XXXXXXXXXXXXXX-0");
        payment.setConfidentialCode("1234");
        payment.setBank("CIC");
        PaymentDAO.createPayment(payment);

        Customer customer = new Customer();
        customer.setFirstName("Alain");
        customer.setLastName("Delon");
        customer.setPayment(payment);
        CustomerDAO.createCustomer(customer);

        Customer c = CustomerDAO.findCustomerById(customer.getId());
        System.out.println(c.getPayment().getCardNumber());
        assertNotNull( c.getPayment() );
    }

    @Test
    public void manyToOne()
    {
        Address adresse1 = new Address();
        adresse1.setStreet("Rue du vieuxport");
        adresse1.setCity("Marseille");
        adresse1.setCountry("France");
        adresse1.setZipCode("13000");
        AddressDAO.create(adresse1);

        Customer alain = new Customer();
        alain.setFirstName("Alain");
        alain.setLastName("Delon");
        alain.setDeliveryAddress(adresse1);
        CustomerDAO.createCustomer(alain);

        Customer brigitte = new Customer();
        brigitte.setFirstName("Brigitte");
        brigitte.setLastName("Delon");
        brigitte.setDeliveryAddress(adresse1);
        CustomerDAO.createCustomer(brigitte);

    }
}