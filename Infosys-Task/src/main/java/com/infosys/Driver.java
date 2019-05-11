package com.infosys;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.infosys.dao.CustomerDAO;
import com.infosys.dao.ReservationDAO;
import com.infosys.models.Customer;

public class Driver {
	private static Logger log = Logger.getLogger(CustomerDAO.class);
	public static void main(String[] args) {
		
		
	
		///// Get All Reservations ///////
//	
//		ReservationDAO resDao = new ReservationDAO();
//	
//		List<Reservation> res = resDao.getAll();
//	
//		res.forEach(System.out::println);
		
		
		///// Get All Customers /////
		
		CustomerDAO custDao = new CustomerDAO();
		
		List<Customer> custs = custDao.getAll();
		
		custs.forEach(System.out::println);
		
		
		///// Get All Flights /////
//		
//		FlightsDAO flightDao = new FlightsDAO();
//		
//		List<Flights> flights = flightDao.getAll();
//		
//		flights.forEach(System.out::println);
		
		
		//// Get By ID /////
		
		ReservationDAO resDao = new ReservationDAO();
		CustomerDAO custDao2 = new CustomerDAO();
		int resId = 0;
		int custId = 0;
		Scanner scan = new Scanner(new InputStreamReader(System.in));
		System.out.println("Please enter id: ");
		resId = scan.nextInt();
		System.out.println(resDao.getById(resId));
		

	
	}
	
}