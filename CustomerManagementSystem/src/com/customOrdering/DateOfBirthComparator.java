package com.customOrdering;

import java.util.Comparator;

import com.code.Customer;

public class DateOfBirthComparator implements Comparator<Customer>{

	@Override
	public int compare(Customer c1, Customer c2) {
		if(c1.getDob().isBefore(c2.getDob())) {
			return -1;
		}
		if(c1.getDob().isEqual(c2.getDob())) {
			return 0;
		}
		return 1;
	}
}
