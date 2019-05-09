package com.infosys.services;

//import org.apache.log4j.Logger;

import com.infosys.dao.ReservationDAO;
import com.infosys.models.Reservation;

public class ReservationService {

	//private static Logger log = Logger.getLogger(CustomerService.class);
	
	
	private ReservationDAO resDao = new ReservationDAO();
	
	public Reservation getReservationById(int id) {
		
		return resDao.getById(id);
		
	}
	
	
}
