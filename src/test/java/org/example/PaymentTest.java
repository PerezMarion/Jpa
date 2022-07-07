package org.example;

import org.example.dao.CustomerDAO;
import org.example.dao.PaymentDAO;
import org.example.entity.Customer;
import org.example.entity.Payment;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class PaymentTest {

    @Test
    public void createPayment()
    {
        Payment payment = new Payment();
        payment.setCardNumber("XXXXXXXXXXXXXX-0");
        payment.setConfidentialCode("1234");
        payment.setBank("CIC");
        PaymentDAO.createPayment(payment);

        assertTrue( true );
    }

    @Test
    public void findPaymentById(){
        Payment payment = new Payment();
        payment.setCardNumber("XXXXXXXXXXXXXX-0");
        payment.setConfidentialCode("1234");
        payment.setBank("CIC");
        PaymentDAO.createPayment(payment);

        Payment payment1 = PaymentDAO.findPaymentById(payment.getId());
        assertEquals("1234", payment1.getConfidentialCode());
    }

    @Test
    public void dontFindById() {
        Payment payment = PaymentDAO.findPaymentById(5L);
        assertNull(payment);
    }

    @Test
    public void findAllPayments() {

        Payment payment1 = new Payment();
        payment1.setCardNumber("XXXXXXXXXXXXXX-0");
        payment1.setConfidentialCode("1234");
        payment1.setBank("CIC");
        PaymentDAO.createPayment(payment1);

        Payment payment2 = new Payment();
        payment2.setCardNumber("XXXXXXXXXXXXXX-1");
        payment2.setConfidentialCode("2345");
        payment2.setBank("CA");
        PaymentDAO.createPayment(payment2);

        Payment payment3 = new Payment();
        payment3.setCardNumber("XXXXXXXXXXXXXX-2");
        payment3.setConfidentialCode("3456");
        payment3.setBank("CE");
        PaymentDAO.createPayment(payment3);

        List<Payment> payments = PaymentDAO.findAllPayments();
        assertEquals(3, payments.size());
    }

    @Test
    public void deletePayment(){
        Payment payment = new Payment();
        payment.setCardNumber("XXXXXXXXXXXXXX-0");
        payment.setConfidentialCode("1234");
        payment.setBank("CIC");
        PaymentDAO.createPayment(payment);

        List<Payment> payments = PaymentDAO.findAllPayments();
        assertEquals(1, payments.size());

        PaymentDAO.deletePayment(payment);

        payments = PaymentDAO.findAllPayments();
        assertEquals(0, payments.size());
    }

    @Test
    public void deleteCustomerById() {
        Payment payment1 = new Payment();
        payment1.setCardNumber("XXXXXXXXXXXXXX-0");
        payment1.setConfidentialCode("1234");
        payment1.setBank("CIC");
        PaymentDAO.createPayment(payment1);

        Payment payment2 = new Payment();
        payment2.setCardNumber("XXXXXXXXXXXXXX-1");
        payment2.setConfidentialCode("2345");
        payment2.setBank("CA");
        PaymentDAO.createPayment(payment2);

        Payment payment3 = new Payment();
        payment3.setCardNumber("XXXXXXXXXXXXXX-2");
        payment3.setConfidentialCode("3456");
        payment3.setBank("CE");
        PaymentDAO.createPayment(payment3);

        PaymentDAO.deletePaymentById(payment2.getId());

        assertNull(PaymentDAO.findPaymentById(payment2.getId()));
        assertNotNull(PaymentDAO.findPaymentById(payment1.getId()));
        assertNotNull(PaymentDAO.findPaymentById(payment3.getId()));
    }

    @Test
    public void updatePayment() {
        Payment payment = new Payment();
        payment.setCardNumber("XXXXXXXXXXXXXX-0");
        payment.setConfidentialCode("1234");
        payment.setBank("CIC");
        PaymentDAO.createPayment(payment);

        Payment newPaymentData =new Payment();
        newPaymentData.setConfidentialCode("9999");
        PaymentDAO.updatePayment(payment.getId(),newPaymentData);

        Payment updatesPayment = PaymentDAO.findPaymentById(payment.getId());
        assertEquals("9999", updatesPayment.getConfidentialCode());
    }
}