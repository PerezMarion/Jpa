package org.example;

import org.example.dao.CustomerDAO;
import org.example.entity.Customer;
import org.example.utils.Gender;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class CustomerTest
{
    @Test
    public void createCustomer()
    {
        Customer customer = new Customer();
        customer.setFirstName("Alain");
        customer.setLastName("Delon");
        CustomerDAO.createCustomer(customer);

        assertTrue( true );
    }

    @Test
    public void findCustomerById(){
        Customer customer = new Customer();
        customer.setFirstName("Alain");
        customer.setLastName("Delon");
        CustomerDAO.createCustomer(customer);

        Customer customer1 = CustomerDAO.findCustomerById(customer.getId());
        assertEquals("Alain", customer1.getFirstName());
    }

    @Test
    public void dontFindById() {
        Customer customer = CustomerDAO.findCustomerById(5L);
        assertNull(customer);
    }

    @Test
    public void findAllCustomers() {

        Customer marie = new Customer("Marie");
        CustomerDAO.createCustomer(marie);
        Customer michel = new Customer("Michel");
        CustomerDAO.createCustomer(michel);
        Customer alex = new Customer("Alex");
        CustomerDAO.createCustomer(alex);

        List<Customer> customers = CustomerDAO.findAllCustomers();
        assertEquals(3, customers.size());
    }

    @Test
    public void deleteCustomer(){
        Customer customer = new Customer("Marie");
        CustomerDAO.createCustomer(customer);

        List<Customer> customers = CustomerDAO.findAllCustomers();
        assertEquals(1, customers.size());

        CustomerDAO.deleteCustomer(customer);

        customers = CustomerDAO.findAllCustomers();
        assertEquals(0, customers.size());
    }

    @Test
    public void deleteCustomerById() {
        Customer marie = new Customer("Marie");
        CustomerDAO.createCustomer(marie);
        Customer michel = new Customer("Michel");
        CustomerDAO.createCustomer(michel);
        Customer alex = new Customer("Alex");
        CustomerDAO.createCustomer(alex);

        CustomerDAO.deleteCustomerById(michel.getId());

        assertNull(CustomerDAO.findCustomerById(michel.getId()));
        assertNotNull(CustomerDAO.findCustomerById(marie.getId()));
        assertNotNull(CustomerDAO.findCustomerById(alex.getId()));
    }

    @Test
    public void deleteCustomerByIdV2() {
        Customer marie = new Customer("Marie");
        CustomerDAO.createCustomer(marie);
        Customer michel = new Customer("Michel");
        CustomerDAO.createCustomer(michel);
        Long michelId = michel.getId();
        Customer alex = new Customer("Alex");
        CustomerDAO.createCustomer(alex);

        CustomerDAO.deleteCustomerByIdV2(michel.getId());

        assertNull(CustomerDAO.findCustomerById(michelId));
        assertNotNull(CustomerDAO.findCustomerById(marie.getId()));
        assertNotNull(CustomerDAO.findCustomerById(alex.getId()));

        for(Customer c : CustomerDAO.findAllCustomers()){
            System.out.println(c);
        }

        System.out.println(michelId);
        Customer c = CustomerDAO.findCustomerById(michelId);
        System.out.println(c);
    }

    @Test
    public void updateCustomer() {
        Customer customer = new Customer();
        customer.setCompanyName("Sopra Steria");
        customer.setFirstName("Marion");
        customer.setLastName("Perez");
        customer.setPhone("0786842676");
        customer.setEmail("marion.oceane.perez@gmail.com");
        customer.setAddress("123 rue de la mairie");
        customer.setZipCode("31700");
        customer.setCity("Blagnac");
        customer.setCountry("France");
        customer.setState(1);
        CustomerDAO.createCustomer(customer);

        Customer newCustomerData = new Customer();
        newCustomerData.setFirstName("Bastien");
        newCustomerData.setLastName("Mallet");
        CustomerDAO.updateCustomer(customer.getId(), newCustomerData);

        Customer updatedCustomer = CustomerDAO.findCustomerById(customer.getId());
        assertEquals("Bastien", updatedCustomer.getFirstName());
        assertEquals("Mallet", updatedCustomer.getLastName());
    }

    @Test
    public void selectWhere() {
        Customer customer1 = new Customer();
        customer1.setFirstName("Alain");
        customer1.setLastName("Delon");
        CustomerDAO.createCustomer(customer1);

        Customer customer2 = new Customer();
        customer2.setFirstName("Alain");
        customer2.setLastName("Prost");
        CustomerDAO.createCustomer(customer2);

        Customer customer3 = new Customer();
        customer3.setFirstName("Marie");
        customer3.setLastName("Dupont");
        CustomerDAO.createCustomer(customer3);

        List<Customer> alains = CustomerDAO.findCustomerByFirstName("Alain");

        for(Customer c : alains) {
            System.out.println(c);
        }
        assertEquals(2, alains.size());

        for(Customer c : alains) {
            if (!c.getFirstName().equals("Alain")) {
                assertTrue(false);
            }
        }
    }

    @Test
    public void createCustomerWithGender()
    {
        Customer customer = new Customer();
        customer.setFirstName("Alain");
        customer.setLastName("Delon");
        customer.setGender(Gender.MALE);

        CustomerDAO.createCustomer(customer);

        assertTrue( true );
    }
}