package com.infosys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.infosys.models.Airline;
import com.infosys.util.ConnectionFactory;

public class AirlineDAO implements DAO<Airline>{

	
	private static Logger log = Logger.getLogger(CustomerDAO.class);
	
	
	@Override
	public List<Airline> getAll() {
		
		
		List<Airline> airline = new ArrayList<Airline>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM Airlines");
			airline = this.mapResultSet(rs);
			
			
		} catch (SQLException e) {
			log.error(e.getMessage());
			
		}
		return airline;
	}

	@Override
	public Airline getById(int airline_id) {

		Airline air = new Airline();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Airlines WHERE airline_id = ?");
			pstmt.setInt(1, airline_id);
			
			ResultSet rs = pstmt.executeQuery();
			air = this.mapResultSet(rs).get(0);
			
		} catch (SQLException e ){
			log.error(e.getMessage());
			
		}
		return air;
	}

	@Override
	public Airline add(Airline obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Airline update(Airline updatedObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	
	private List<Airline> mapResultSet(ResultSet rs) throws SQLException {
		
		List<Airline> airlines = new ArrayList<>();
		
		log.info("inside the mapResultsSet()");
		
		while(rs.next()) {
			Airline air = new Airline();
			air.setAirline_id(rs.getInt("AIRLINE_ID"));
			air.setAirline_name(rs.getString("AIRLINE_NAME"));
			
			airlines.add(air);
			log.info(air);
		}
		
		log.info(airlines);
		
		return airlines;
	}
	
	
	
}
