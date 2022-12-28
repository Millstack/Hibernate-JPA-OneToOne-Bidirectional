package com.jsp.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.account.Account;
import com.jsp.customer.Customer;

public class BankController {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("milind");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Account account = new Account();
		account.setAccount_no(22222222);
		account.setIfsc("KMMDD0001212");
		
		Customer customer = new Customer();
		customer.setName("Aniket");
		customer.setAccount(account);
		
		account.setCustomer(customer);
		
		
		entityTransaction.begin();
		entityManager.persist(account);
		entityManager.persist(customer);
		entityTransaction.commit();
		System.out.println("All good");
		
	}

}
