package com.java.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.java.model.Employee;

public class SortListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<>();
		list.add(100);
		list.add(200);
		list.add(4);
		list.add(9);
		Collections.sort(list);
		System.out.println(list);
		List<Integer> list1=list.stream().sorted().collect(Collectors.toList());
		System.out.println("Using collect:"+list1);
		list.stream().sorted().forEach(t->System.out.println(t));
		
		System.out.println("After using java to sort the employee by salary");
		List<Employee> emp=new ArrayList<>();
		emp.add(new Employee(23, "Tanu", "IT", 25000,34));
		emp.add(new Employee(25, "Renuka", "Bio", 35000,40));
		emp.add(new Employee(39, "Anita", "IT", 70000,32));
		emp.add(new Employee(39, "Tejnmm", "IT", 70000,33));

		Collections.sort(emp,(emp1,  emp2) ->(int) (emp1.getSalary()-emp2.getSalary()));
		System.out.println(emp);
		System.out.println("By Using java stream::");
		emp.stream().sorted((emp1,  emp2) ->(int) (emp1.getSalary()-emp2.getSalary())).forEach(e->System.out.println(e));// this is using old way 
		System.out.println("By Using java stream 8 ::");
		emp.stream().sorted(Comparator.comparing(e->e.getName())).forEach(t->System.out.println(t));//this is using java 8 method
		
		System.out.println("Using method references:::");
		//emp.stream().sorted(Comparator.comparing(Employee::getEmpid)).forEach(System.out::println);
		emp.stream().distinct().forEach(t->System.out.println("::"+t));
		
	}

}
