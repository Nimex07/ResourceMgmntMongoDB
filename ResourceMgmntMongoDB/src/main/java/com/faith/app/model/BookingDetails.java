package com.faith.app.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

//create table name
@Document
public class BookingDetails {
	// instance variables

	@Id // setting primary key
	private Long bookingId;

	// setting relations
	@DBRef
	private ResourceDetails resourceDetails;

	private String custName;
	private String custAddress;
	private String phoneNumber;
	private String email;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate endDate;

	private String purpose;
	private Character bookingStatus;
	private Character pending = 'Y';

	public BookingDetails() {
		super();

	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Character getPending() {
		return pending;
	}

	public void setPending(Character pending) {
		this.pending = pending;
	}

	public ResourceDetails getResourceDetails() {
		return resourceDetails;
	}

	public void setResourceDetails(ResourceDetails resourceDetails) {
		this.resourceDetails = resourceDetails;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Character getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(Character bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

}
