package br.com.fbscript.bookstore.hibernate;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestetHibernate {
	public static void main(String[] args){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("bookstore");
		factory.close();
	}
}
