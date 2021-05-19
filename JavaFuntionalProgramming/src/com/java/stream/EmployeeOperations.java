package com.java.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.java.model.Emp;

public class EmployeeOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Emp> emplList = new ArrayList<>();
		emplList.add(new Emp(123, "Vihaan", 29, "Male", "IT", 2019, 20000));
		emplList.add(new Emp(123, "Raunak", 22, "Male", "Mech", 2020, 45000));
		emplList.add(new Emp(456, "Ishu", 25, "Female", "Electronics", 2001, 56000));
		emplList.add(new Emp(78, "Teju", 38, "Male", "Account", 2019, 18000));
		emplList.add(new Emp(89, "Sonu", 36, "Male", "Account", 2017, 46700));

		/* Find all names of department */
		System.out.println("*** Find all names of department ***** ");
		emplList.stream().map(e -> e.getDepartment()).forEach(t -> System.out.println(t));

		/** Find how many female and male are in the organization */
		System.out.println("*** Find how many female and male are in the organization ***** ");

		Map<String, Long> map = emplList.stream()
				.collect(Collectors.groupingBy(g -> g.getGender(), Collectors.counting()));
		System.out.println(map);

		/** Find average of female and male are in the organization */
		System.out.println("*** Find avegarge of female and male are in the organization ***** ");

		Map<String, Double> mapAge = emplList.stream()
				.collect(Collectors.groupingBy(g -> g.getGender(), Collectors.averagingInt(t -> t.getAge())));
		System.out.println(mapAge);

		/* get the highest paid employee in organization */
		Emp eList = emplList.stream().max(Comparator.comparing(g -> g.getSalary())).get();
		System.out.println(eList);

		/* get all the employess name who have joined before 2020 */
		System.out.println("*** Get all the employess name who have joined before 2020***** ");
		List<String> yearOfpassList = emplList.stream().filter(t1 -> (t1.getYearOfJoining() > 2019))
				.map(empname -> empname.getName()).collect(Collectors.toList());
		System.out.println(yearOfpassList);

		/* Count the number of employees in eash department */

		Map<String, Long> noOfEmpDept = emplList.stream()
				.collect(Collectors.groupingBy(d -> d.getDepartment(), Collectors.counting()));
		System.out.println("***No of employee in eash Dept *******" + noOfEmpDept);
		System.out.println("****** What is average salary  of eash department **********");
		Map<String, Double> avgSalOfDept = emplList.stream()
				.collect(Collectors.groupingBy(d -> d.getDepartment(), Collectors.averagingDouble(s -> s.getSalary())));
		System.out.println(avgSalOfDept);

		System.out.println("*** Get the youngest male employee from ... department ***** ");
		Emp yougList = emplList.stream()
				.filter(a -> a.getGender().equals("Male") && a.getDepartment().equals("Account"))
				.min(Comparator.comparing(r -> r.getAge())).get();
		System.out.println(yougList);
		System.out.println("*** what is the average salary of male and female employee ***** ");
		
	}

}
