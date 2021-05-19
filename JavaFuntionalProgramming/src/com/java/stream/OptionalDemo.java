package com.java.stream;

import java.util.Arrays;
import java.util.Optional;

import com.java.model.Customer;

public class OptionalDemo {
	public static void main(String args[]) {
		Customer c=new Customer(1, "Ranunak", null, Arrays.asList("12345", "6788"));
		Optional<String> opList=Optional.ofNullable(c.getEmail());
		if(opList.isPresent()) {
		System.out.println(opList);
		}
		System.out.println(opList);
	}
}
