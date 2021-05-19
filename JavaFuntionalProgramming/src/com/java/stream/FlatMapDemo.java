package com.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.java.model.Customer;

public class FlatMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Customer> custList = Arrays.asList(
				new Customer(1, "Ranunak", "rgore@gmail.com", Arrays.asList("12345", "6788")),
				new Customer(1, "Vihaan", "vihanban@gmail.com", Arrays.asList("987", "854553")),
				new Customer(1, "Ishu", "ishugore@gmail.com", Arrays.asList("4199399", "67646788")),
				new Customer(1, "Teju", "tgore@gmail.com", Arrays.asList("6555252", "875437733")));

		custList.stream().map(c -> c.getEmail()).forEach(s -> System.out.println(s));
		System.out.println("Before flat Map:");
		List<List<String>> phoneList1 = custList.stream().map(c -> c.getPhoneNumbers()).collect(Collectors.toList());
		System.out.println(phoneList1);
		System.out.println("***** Flat map o/p********");
		List<String> phoneList = custList.stream().flatMap(c -> c.getPhoneNumbers().stream())
				.collect(Collectors.toList());
		System.out.println(phoneList);

		
	}

}
