package com.klh;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {
    public static void main(String[] args) {

        // CREATE
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product p = new Product(101, "SSD 1TB", 5499.0, 10);
        session.save(p);

        tx.commit();
        session.close();
        System.out.println("Product Inserted");

        // READ
        session = HibernateUtil.getSessionFactory().openSession();
        Product fetched = session.get(Product.class, 101);
        System.out.println(
            fetched.getName() + " | " +
            fetched.getPrice() + " | Qty: " +
            fetched.getQuantity()
        );
        session.close();

        // UPDATE
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        fetched.setPrice(5199.0);
        fetched.setQuantity(15);
        session.update(fetched);

        tx.commit();
        session.close();
        System.out.println("Product Updated");

        // DELETE
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        session.delete(fetched);

        tx.commit();
        session.close();
        System.out.println("Product Deleted");
    }
}
