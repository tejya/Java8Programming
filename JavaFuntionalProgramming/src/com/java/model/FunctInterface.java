package com.java.model;

public interface FunctInterface {
void test();
void test1();

default void display() {
	System.out.println("Hello");
}
}
