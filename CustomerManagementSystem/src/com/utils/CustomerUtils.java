package com.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.code.Customer;
import com.code.ServicePlan;

import static com.utils.ValidationRules.validateAllException;
import com.exception.InvalidEmailException;
import com.exception.InvalidPasswordException;

public class CustomerUtils {
	public static Customer findByEmail(String email,String password,List<Customer> list) throws InvalidEmailException,InvalidPasswordException
	{
		Customer customer=new Customer(email);
		int index=list.indexOf(customer);
		if(index!=-1) {
			if(password.equals((list.get(index)).getPassword())) {
				//System.out.println(list.get(index));
				return list.get(index);
			}else {
				throw new InvalidPasswordException("Invalid Password!.. Password does not match");
			}
		}else {
			throw new InvalidEmailException("Invalid Email!.. Email not Found");
		}	
	}
	
	public static void changePassword(String email,String oldPassword,String newPassword ,List<Customer> list) throws InvalidEmailException,InvalidPasswordException
	{
		Customer c=findByEmail(email, oldPassword, list);
		c.setPassword(newPassword);
		System.out.println("Password Changed successfully");
	}
	
	
	public static List<Customer> populateList() {
		List<Customer> list=new ArrayList<>();
		//String firstName,String lastName,String email,String password,double registrationAmount,LocalDate registrationDate,LocalDate dob,ServicePlan plan,LocalDate lastSubscribtionPaidDate) {
		list.add(new Customer("Pranav", "Gawale", "pranav.gawale@gmail.com", "pass123", 10000.00,LocalDate.parse("2022-05-13") ,LocalDate.parse("2001-02-12"), ServicePlan.PLATINUM, LocalDate.now()));
		list.add(new Customer("Soham", "Mehta", "soham.mehta@gmail.com", "pass1234", 10000.00,LocalDate.parse("2023-01-13") , LocalDate.parse("2003-02-02"), ServicePlan.PLATINUM,LocalDate.parse("2023-05-13")));
		list.add(new Customer("Prasad", "Shingatkar", "prasad.shingh@gmail.com", "1234", 2000.00,LocalDate.parse("2023-12-30") , LocalDate.parse("2002-12-10"), ServicePlan.GOLD,LocalDate.parse("2023-06-22")));
		list.add(new Customer("Krishna", "Mahajan", "krishna.mahajan@gmail.com", "pass", 1000.00,LocalDate.parse("2023-01-22") , LocalDate.parse("2000-02-23"), ServicePlan.SILVER,LocalDate.parse("2023-03-11")));
		list.add(new Customer("Mayur", "Zatale", "mayur.zatale@gmail.com", "password", 1000.00,LocalDate.parse("2023-11-29") , LocalDate.parse("2000-02-23"), ServicePlan.SILVER,LocalDate.parse("2023-02-09")));
		
		return list;
	}
}
