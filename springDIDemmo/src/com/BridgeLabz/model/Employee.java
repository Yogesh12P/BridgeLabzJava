package com.BridgeLabz.model;

public class Employee
{

	int id;
	String name;
	
	public Employee()
	{
		System.out.println("Default constructor called");
	}
	
	public Employee(String name)
	{
		this.name = name;
		System.out.println("Default constructor called of string type");
	}
	
	public Employee(int id)
	{
		this.id = id;
		System.out.println("Default constructor called of int type");
	}
	
	public Employee(String name, int id)
	{
		this.name = name;
		this.id = id;
		System.out.println("Default constructor called of string and int type");
	}
}
