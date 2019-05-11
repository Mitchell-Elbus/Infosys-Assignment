package com.infosys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.infosys.models.Flights;
import com.infosys.util.ConnectionFactory;

public class FlightsDAO implements DAO<Flights>{

	
	Logger log = Logger.getLogger(FlightsDAO.class);
	
	
	@Override
	public List<Flights> getAll() {
		
		List<Flights> flights = new ArrayList<>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM Flights"); 
			flights = this.mapResultSet(rs);
			
			
			
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		
		return flights;
		
		
		
	}

	@Override
	public Flights getById(int flight_id) {
		
		Flights flight = new Flights();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Flights WHERE flight_id = ?");
			pstmt.setInt(1, flight_id);

			ResultSet rs = pstmt.executeQuery();
			flight = this.mapResultSet(rs).get(0);

		} catch (SQLException e) {
			log.error(e.getMessage());
		}

		return flight;
	}

	
	
	@Override
	public Flights add(Flights obj) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	@Override
	public Flights update(Flights updatedObj) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	private List<Flights> mapResultSet(ResultSet rs) throws SQLException {
		
		List<Flights> flights = new ArrayList<>();
		
		log.info("inside the mapResultsSet()");
		
		while(rs.next()) {
			Flights flight = new Flights();
			flight.setFlight_id(rs.getInt("FLIGHT_ID"));
			flight.setDep_location(rs.getString("DEPARTURE_LOC"));
			flight.setDep_time(rs.getString("DEPARTURE_TIME"));
			flight.setArr_location(rs.getString("ARRIVAL_LOC"));
			flight.setArr_time(rs.getString("ARRIVAL_TIME"));
			flight.setFl_airline_id(rs.getInt("FLIGHT_AIRLINE_ID"));
			
			flights.add(flight);
			log.info(flight);
		}
		
		log.info(flights);
		
		return flights;
	}
	
	

}
