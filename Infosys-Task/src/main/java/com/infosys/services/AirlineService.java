package com.infosys.services;

import com.infosys.dao.AirlineDAO;
import com.infosys.models.Airline;

public class AirlineService {

	private AirlineDAO airDao = new AirlineDAO();
	
	
	public Airline getAirlineById(int id) {
		
		return airDao.getById(id);
		
	}
	
	
	
}
