package com.code;

import java.time.LocalDate;

public class Customer implements Comparable<Customer> {
	private int customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private double registrationAmount;
	private LocalDate registrationDate;
	private LocalDate dob;
	private ServicePlan plan;
	private LocalDate lastSubscriptionPaidDate;
	private static int customerIdCounter;
	
	public Customer(String firstName,String lastName,String email,String password,double registrationAmount,LocalDate registrationDate,LocalDate dob,ServicePlan plan,LocalDate lastSubscribtionPaidDate) {	
		this.customerId=customerIdCounter;
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.password=password;
		this.registrationAmount=registrationAmount;
		this.registrationDate=registrationDate;
		this.dob=dob;
		this.plan=plan;
		this.lastSubscriptionPaidDate=lastSubscribtionPaidDate;
		customerIdCounter++;
	}
	
	public LocalDate getDob() {
		return dob;
	}

	public Customer(String email) {
		super();
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastName() {
		return lastName;
	}

	static {
		customerIdCounter=1000;
	}
	
	
	
	@Override
	public String toString() {
		return "\nCustomerId=" + customerId + "\nFirstName=" + firstName + "\nLastName=" + lastName+"\nDate of Birth=" + dob + "\nEmail="
				+ email + "\nPassword=" + password + "\nRegistrationAmount=" + registrationAmount +"\nRegistration Date="+ registrationDate
				+ "\nService Plan=" + plan+"\nLastSubscriptionPaidDate="+lastSubscriptionPaidDate ;
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof Customer) {
//			System.out.println("In customer equals");
			return this.email.equals(((Customer)o).email);
		}
		return false;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public ServicePlan getPlan() {
		return plan;
	}

	public LocalDate getLastSubscriptionPaidDate() {
		return lastSubscriptionPaidDate;
	}

	public void setLastSubscriptionPaidDate(LocalDate lastSubscriptionPaidDate) {
		this.lastSubscriptionPaidDate = lastSubscriptionPaidDate;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	@Override
	public int compareTo(Customer anotherCustomer) {
		return this.email.compareTo(anotherCustomer.email);
	}
	
	
}
