package com.klu;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class App {
 public static void main(String[] args) {
 // CREATE
 Session session = HibernateUtil.getSessionFactory().openSession();
 Transaction tx = session.beginTransaction();
 Product s1 = new Product(101, "Ram", "CSE");
 session.save(s1);
 tx.commit();
 session.close();
 System.out.println("Student Inserted");
 // READ
 session = HibernateUtil.getSessionFactory().openSession();
 Product s = session.get(Product.class, 101);
 System.out.println(s.getName() + " " + s.getDept());
 session.close();
 // UPDATE
 session = HibernateUtil.getSessionFactory().openSession();
 tx = session.beginTransaction();
 s.setDept("AI & DS");
 session.update(s);
 tx.commit();
 session.close();
 System.out.println("Student Updated");
 // DELETE
 session = HibernateUtil.getSessionFactory().openSession();
 tx = session.beginTransaction();
 session.delete(s);
 tx.commit();
 session.close();
 System.out.println("Student Deleted");
 }}