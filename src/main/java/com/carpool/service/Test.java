package com.carpool.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.carpool.dao.Carpooler;

public class Test {
   private static SessionFactory factory; 

public static void main(String[] args) {
      try{
         factory = new AnnotationConfiguration().
                   configure().
                   //addPackage("com.xyz") //add package if used.
                   addAnnotatedClass(Carpooler.class).buildSessionFactory();
      }catch (Throwable ex) { 
         System.err.println("Failed to create sessionFactory object." + ex);
         throw new ExceptionInInitializerError(ex); 
      }
      Test ME = new Test();

      /* Add few employee records in database */
      Integer empID1 = ME.addEmployee("Zara1", "Ali11", 5, "1234567890","MH14 AB 1234", "Aundh", "Blue-Ridge");
      Integer empID2 = ME.addEmployee("Zara2", "Ali22", 5, "1234567890","MH14 AB 1234", "Aundh", "Blue-Ridge");
      Integer empID3 = ME.addEmployee("Zara3", "Ali33", 5, "1234567890","MH14 AB 1234", "Aundh", "Blue-Ridge");
      Integer empID4 = ME.addEmployee("Zara4", "Ali44", 5, "1234567890","MH14 AB 1234", "Aundh", "Blue-Ridge");
      Integer empID5 = ME.addEmployee("Zara5", "Ali55", 5, "1234567890","MH14 AB 1234", "Aundh", "Blue-Ridge");
      System.out.println(empID1+","+empID2+","+empID3+","+empID4+","+empID5);
      /* List down all the employees */
      ME.listEmployees();

      /* Update employee's records */
      ME.updateEmployee(empID1, 5000);

      /* Delete an employee from the database */
      ME.deleteEmployee(empID2);

      /* List down new list of the employees */
      ME.listEmployees();
   }
   /* Method to CREATE an employee in the database */
   public Integer addEmployee(String fname, String lname, Integer noOfSeatsAvailable, String contactNumber, String vehicleNumber, String destination, String source){
      Session session = factory.openSession();
      Transaction tx = null;
      Integer employeeID = null;
      try{
         tx = session.beginTransaction();
         Carpooler employee = new Carpooler();
         employee.setFirstName(fname);;
         employee.setLastName(lname);
         employee.setNoOfSeatsAvailable(noOfSeatsAvailable);
         employee.setContactNumber(contactNumber);
         employee.setVehicleNumber(vehicleNumber);
         employee.setDestination(destination);
         employee.setSource(source);
         employeeID = (Integer) session.save(employee); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
      return employeeID;
   }
   /* Method to  READ all the employees */
   public void listEmployees( ){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         List employees = session.createQuery("FROM carpool").list(); 
         for (Iterator iterator = 
                           employees.iterator(); iterator.hasNext();){
        	 Carpooler employee = (Carpooler) iterator.next(); 
            System.out.print("First Name: " + employee.getFirstName()); 
            System.out.print("  Last Name: " + employee.getLastName()); 
        
         }
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
   /* Method to UPDATE salary for an employee */
   public void updateEmployee(Integer EmployeeID, int salary ){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Carpooler employee = 
                    (Carpooler)session.get(Carpooler.class, EmployeeID); 
         
		 session.update(employee); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
   /* Method to DELETE an employee from the records */
   public void deleteEmployee(Integer EmployeeID){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Carpooler employee = 
                   (Carpooler)session.get(Carpooler.class, EmployeeID); 
         session.delete(employee); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
}