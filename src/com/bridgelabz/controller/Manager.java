package com.bridgelabz.controller;
import com.bridgelabz.serviceimplementation.DatabaceAccessObject;
import com.bridgelabz.serviceimplementation.UserServiceImplementation;
import com.bridgelabz.utility.Utility;
public class Manager 
{
	static DatabaceAccessObject databaceAccessObject=new DatabaceAccessObject();
	public static void main(String[] args) 
	{
		UserServiceImplementation userServiceImplementation=new UserServiceImplementation();
		System.out.println("What do you want to do?");
		System.out.println("1.Register\t 2.Login");
		int option=Utility.retInt();
		switch (option)
		{
		case 1:
			userServiceImplementation.register();
			break;

		case 2:
			userServiceImplementation.login();
			break;
		}
	}

}
