package com.java.stream;

import java.util.Comparator;

import com.java.model.Employee;

public class EmployeeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee emp1, Employee emp2) {
		return (int) (emp1.getSalary()-emp2.getSalary());
	}
	

}
