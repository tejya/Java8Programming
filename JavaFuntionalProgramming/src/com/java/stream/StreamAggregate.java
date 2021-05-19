package com.java.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Arrays;
import java.util.stream.*;
import com.java.model.Employee;

public class StreamAggregate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();

		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		Integer min = list.stream().min(Integer::compare).get();
		System.out.println("Minimum number::" + min);
		int sum = list.stream().mapToInt(i -> i).sum();
		System.out.println(sum);
		/*
		 * write a program to calculate the square of given numver and filter the
		 * numbers greater than 30 and avregare of the given number
		 */

		list.stream().mapToInt(s -> s * s).filter(n -> n > 40).forEach(s -> System.out.println());
		/* Find larget age employee from list */
		List<Employee> emp = new ArrayList<>();
		emp.add(new Employee(23, "Manu", "IT", 25000, 24));
		emp.add(new Employee(25, "Tenu", "Bio", 35000, 40));
		emp.add(new Employee(39, "Onkar", "IT", 70000, 32));
		emp.add(new Employee(39, "Vihaan", "IT", 70000, 33));
		Employee e1 = emp.stream().max(Comparator.comparing(e -> e.getAge())).get();
		System.out.println(e1);
		Long sum1 = emp.stream().map(y -> y).count();
		System.out.println(sum1);
		Employee e3 = emp.stream().max(Comparator.comparing(sal -> sal.getSalary())).get();
		System.out.println("maximum salary employee::" + e3);

		List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3));

		List<Integer> finalList = list1.stream().filter(item -> list2.contains(item)).collect(Collectors.toList());
		System.out.println(finalList);

	}

}
