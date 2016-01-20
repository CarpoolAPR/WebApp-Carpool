package com.carpool.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CARPOOLER")
public class Carpooler {

	@Id
	@GeneratedValue
	@Column
	private String carpoolId;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String contactNumber;
	@Column
	private String vehicleNumber;
	@Column
	private Integer noOfSeatsAvailable;
	@Column
	private String source;
	@Column
	private String destination;

	public String getCarpoolId() {
		return carpoolId;
	}

	public void setCarpoolId(String carpoolId) {
		this.carpoolId = carpoolId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Integer getNoOfSeatsAvailable() {
		return noOfSeatsAvailable;
	}

	public void setNoOfSeatsAvailable(Integer noOfSeatsAvailable) {
		this.noOfSeatsAvailable = noOfSeatsAvailable;
	}
}