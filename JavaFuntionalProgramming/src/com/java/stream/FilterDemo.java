package com.java.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.java.model.Employee;

public class FilterDemo {

	public static void main(String args[]) {
	List<String> list=Arrays.asList("Teju","Sonu","Monu");
	
	list.stream().
	filter(name->name.equals("Teju"))
	.forEach(display->System.out.println(display));
	
	HashMap<String,String> map=new HashMap<>();
	map.put("1", "Mango");
	map.put("2", "Anar");
	map.put("5", "Tomato");
	
	map.entrySet().stream().forEach(t->System.out.println(t.getKey()+":"+t.getValue()));
	
	List<Employee> emp=new ArrayList<>();
	emp.add(new Employee(23, "Manu", "IT", 25000,24));
	emp.add(new Employee(25, "Tenu", "Bio", 35000,40));
	emp.add(new Employee(39, "Onkar", "IT", 70000,32));
	emp.add(new Employee(39, "Vihaan", "IT", 70000,33));
	List<Employee> empAgeList=emp.stream().filter(a->a.getAge()>30).collect(Collectors.toList());
	System.out.println(empAgeList);
	
	
}
}
