package com.carpool.service;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.carpool.dao.Carpooler;

public class Test {
	private static EntityManager em;

	public static void main(String[] args) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApp-Carpool");
			em = emf.createEntityManager();
			Test ME = new Test();

			/* Add few employee records in database */
			Integer empID1 = ME.addEmployee("Zara1", "Ali11", 5, "1234567890", "MH14 AB 1234", "Aundh", "Blue-Ridge");
			Integer empID2 = ME.addEmployee("Zara2", "Ali22", 5, "1234567890", "MH14 AB 1234", "Aundh", "Blue-Ridge");
			Integer empID3 = ME.addEmployee("Zara3", "Ali33", 5, "1234567890", "MH14 AB 1234", "Aundh", "Blue-Ridge");
			Integer empID4 = ME.addEmployee("Zara4", "Ali44", 5, "1234567890", "MH14 AB 1234", "Aundh", "Blue-Ridge");
			Integer empID5 = ME.addEmployee("Zara5", "Ali55", 5, "1234567890", "MH14 AB 1234", "Aundh", "Blue-Ridge");
			System.out.println(empID1 + "," + empID2 + "," + empID3 + "," + empID4 + "," + empID5);
			 //List down all the employees 
			 ME.listEmployees();

			/* Update employee's records */
			// ME.updateEmployee(empID1, 5000);

			/* Delete an employee from the database */
			// ME.deleteEmployee(empID2);

			/* List down new list of the employees */
			// ME.listEmployees();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* Method to CREATE an employee in the database */
	public Integer addEmployee(String fname, String lname, Integer noOfSeatsAvailable, String contactNumber,
			String vehicleNumber, String destination, String source) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Carpooler employee = new Carpooler();
		employee.setFirstName(fname);
		employee.setLastName(lname);
		employee.setNoOfSeatsAvailable(noOfSeatsAvailable);
		employee.setContactNumber(contactNumber);
		employee.setVehicleNumber(vehicleNumber);
		employee.setDestination(destination);
		employee.setSource(source);
		em.persist(employee);
		tx.commit();
		return (employee.getCarpoolId());
	}

	/* Method to READ all the employees */
	public void listEmployees() {
		List employees = em.createQuery("Select c FROM Carpooler c").getResultList();
		for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
			Carpooler employee = (Carpooler) iterator.next();
			System.out.print("First Name: " + employee.getFirstName());
			System.out.print("  Last Name: " + employee.getLastName());
			System.out.println();
		}
	}

	/*
	 * Method to UPDATE salary for an employee public void
	 * updateEmployee(Integer EmployeeID, int salary) { Session session =
	 * factory.openSession(); Transaction tx = null; try { tx =
	 * session.beginTransaction(); Carpooler employee = (Carpooler)
	 * session.get(Carpooler.class, EmployeeID);
	 * 
	 * session.update(employee); tx.commit(); } catch (HibernateException e) {
	 * if (tx != null) tx.rollback(); e.printStackTrace(); } finally {
	 * session.close(); } }
	 * 
	 * Method to DELETE an employee from the records public void
	 * deleteEmployee(Integer EmployeeID) { Session session =
	 * factory.openSession(); Transaction tx = null; try { tx =
	 * session.beginTransaction(); Carpooler employee = (Carpooler)
	 * session.get(Carpooler.class, EmployeeID); session.delete(employee);
	 * tx.commit(); } catch (HibernateException e) { if (tx != null)
	 * tx.rollback(); e.printStackTrace(); } finally { session.close(); } }
	 */
}