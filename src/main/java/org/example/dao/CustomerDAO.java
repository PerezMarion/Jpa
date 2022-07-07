package org.example.dao;

import org.example.entity.Customer;
import org.example.jpa.EntityManagerSingleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class CustomerDAO {
    public static void createCustomer(Customer customerToCreate) {

        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(customerToCreate);
        tx.commit();
    }

    public static Customer findCustomerById(Long id) {

        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        Customer customer = entityManager.find(Customer.class, id);
        return customer;
    }

    public static List<Customer> findAllCustomers() {

        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        Query findAllQuery = entityManager.createQuery
                ("select c from Customer c");
        return findAllQuery.getResultList();
    }

    public static void deleteCustomer(Customer customer) {

        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(customer);
        tx.commit();
    }

    public static void deleteCustomerById(Long id) {

        Customer customerToDelete = findCustomerById(id);
        deleteCustomer(customerToDelete);
    }

    public static void updateCustomer(Long id, Customer newCustomerData) {

        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        Customer customerToUpdate = entityManager.find(Customer.class, id);
        customerToUpdate.setNotNullData(newCustomerData);

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(customerToUpdate);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
    }

    public static List<Customer> findCustomerByFirstName(String firstName) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Query queryToFindCustomerByFirstName = entityManager.createQuery("select c from Customer c where c.firstName = :firstName");
        queryToFindCustomerByFirstName.setParameter("firstName", firstName);
        return queryToFindCustomerByFirstName.getResultList();
    }
}