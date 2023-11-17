package com.utils;

import java.time.LocalDate;
import java.util.List;

import com.code.Customer;
import com.code.ServicePlan;
import com.exception.*;


public class ValidationRules {
	
	public static ServicePlan parseAndValidationPlan(String pln) throws IllegalArgumentException
	{	
		return ServicePlan.valueOf(pln.toUpperCase());
	}
	
	//add a method to validate registration amount with the plan
	public static void validatePlanAmount(ServicePlan plan,double regAmount) throws InvalidInputException{
		if(plan.getCharges()!=regAmount) {
			throw new InvalidInputException("Registration amount doesn't match the Plan.");
		}
	}
	
	
	public static void checkDuplicateEmail(String email,List<Customer> custList) throws InvalidEmailException
	{
		Customer newCustomer=new Customer(email);
		if(custList.contains(newCustomer)) {
			throw new InvalidEmailException("This email already exists.");
		}
	}
	
	//add a method to call validation rules
	public static Customer validateAllException(String firstName,String lastName,String email,
			String password,double registrationAmount,String regDate,String dob,String plan,String lastSubPaid,List<Customer> list) throws InvalidInputException,IllegalArgumentException,InvalidEmailException{
		ServicePlan serPlan=parseAndValidationPlan(plan);
		validatePlanAmount(serPlan,registrationAmount);
		checkDuplicateEmail(email,list);
		LocalDate rDate=LocalDate.parse(regDate);
		LocalDate dDate=LocalDate.parse(dob);
		LocalDate pDate=LocalDate.parse(lastSubPaid);
		return new Customer(firstName,lastName,email,password,registrationAmount,rDate,dDate,serPlan,pDate);
	}
}
