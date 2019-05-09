package com.infosys.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


import com.infosys.models.Reservation;
import com.infosys.util.ConnectionFactory;

public class ReservationDAO implements DAO<Reservation> {

	
	Logger log = Logger.getLogger(ReservationDAO.class);
	
	
	
	@Override
	public List<Reservation> getAll() {
		
		
		List<Reservation> reimbursments = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			 // TODO JOIN ers_user_roles USING (role_id)   ///// Possible callable statement here to return result set including users
			ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM ers_reimbursment WHERE reimb_status_id = 1"); 
			
			reimbursments = this.mapResultSet(rs);
			

		} catch (SQLException e) {
			log.error(e.getMessage());
		}

		return reimbursments;
	}

	@Override
	public Reservation getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation add(Reservation obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation update(Reservation updatedObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	
	private List<Reservation> mapResultSet(ResultSet rs) throws SQLException {
		
		List<Reservation> reservations = new ArrayList<>();
		
		log.info("inside the mapResultsSet()");
		
		while(rs.next()) {
			Reservation res = new Reservation();
			res.setRes_id(rs.getInt("RES_ID"));
			res.setRes_flight_id(rs.getInt("RES_FLIGHT_ID"));
			res.setRes_cust_id(rs.getInt("RES_CUST_ID"));
			
			
			reservations.add(res);
			log.info(res);
		}
		
		log.info(reservations);
		
		return reservations;
	}
	
	
}


