package com.tester;

import com.code.Customer;
import com.exception.*;
import static com.utils.CustomerUtils.findByEmail;
import static com.utils.CustomerUtils.populateList;
import static com.utils.CustomerUtils.changePassword;
import static com.utils.ValidationRules.validateAllException;
import com.customOrdering.DateOfBirthComparator;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
//import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.Period;

public class CustomerTester {

	public static void main(String[] args) {
		
		try(Scanner sc=new Scanner(System.in)){
		List<Customer> custList=populateList();
		
		boolean exit=false;
		while(!exit) {
			System.out.println("==============================");
			System.out.println("Options:-\n1.Sign up\n2.Sign in\n3.Change password\n4.Unsubscribe Customer\n5.Display all customers\n6.Sort as per email\n7.Sort as per DateOfBirth\n8.Sort as per DOB and name\n9.Pay Registration/Subscription amount\n10.Display customers who did not pay for last 3 months\n11.Remove customers who have subscription pending for 6 months \n0.exit");
			System.out.println("==============================");
			try {
				switch(sc.nextInt()) {
				case 1:
					System.out.println("Enter Customer details.\nFirstName,LastName,Email,Password,RegistrationAmount,DOB,Service Plan");
					custList.add(validateAllException(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(), sc.next(), sc.next(), sc.next(), sc.next(), custList));
					System.out.println("Customer added");
					break;
				case 2:
					System.out.println("Enter Email And Password");
					System.out.println(findByEmail(sc.next(), sc.next(), custList));
					break;
				case 3:
					System.out.println("Enter Email,old Password And new Password");
					changePassword(sc.next(), sc.next(), sc.next(), custList);
					break;
				case 4:
					System.out.println("Enter Email and Password to Unsubscribe");
					boolean removed=custList.remove(findByEmail(sc.next(), sc.next(), custList));
					if(removed) {
						System.out.println("Unsubscribed Successfully");
					}
					break;
				case 5:
					for(Customer c : custList) {
						System.out.println(c);
					}
					break;
				case 6:
					Collections.sort(custList);
					break;
				case 7:
					Collections.sort(custList,new DateOfBirthComparator());
					break;
				case 8:
					Collections.sort(custList,new Comparator<Customer>(){

						@Override
						public int compare(Customer c1, Customer c2) {
							int ret=c1.getDob().compareTo(c2.getDob());
							if(ret==0) {
								return c1.getLastName().compareTo(c2.getLastName());
							}
							return ret;
						}
					});
					break;
				case 9:
					System.out.println("Enter Email,password");
					Customer c=findByEmail(sc.next(),sc.next(),custList);
					long months=Period.between(c.getLastSubscriptionPaidDate(), LocalDate.now()).toTotalMonths();
					if(months>0) {
						System.out.println("Amount to Pay"+c.getPlan().getCharges()*months);
						System.out.println("Pay Amount(Yes/No):");
						String choice=sc.next();
						if(choice.equals("Yes")) {
							c.setLastSubscriptionPaidDate(LocalDate.now());
						}else {
							System.out.println("No change");
						}
					}
					System.out.println("Your payment is Upto-date");
					break;
				case 10:
					for(Customer customer : custList) {
						months=Period.between(customer.getLastSubscriptionPaidDate(),LocalDate.now()).toTotalMonths();
						if(months>=3) {
							System.out.println(customer.getFirstName()+ " " + customer.getLastName());
						}
					}
					break;
				case 11:
					Iterator<Customer> itr=custList.iterator();
					while(itr.hasNext()) {
						months=Period.between(itr.next().getLastSubscriptionPaidDate(), LocalDate.now()).toTotalMonths();
						if(months>=6) {
							itr.remove();
						}
					}
					break;
				case 0:
					exit =true;
					break;
				}
			}catch(InvalidEmailException e) {
				System.out.println(e);
			}catch(InvalidPasswordException e) {
				System.out.println(e);
			}catch(InvalidInputException e) {
				System.out.println(e);
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	}
}

}
