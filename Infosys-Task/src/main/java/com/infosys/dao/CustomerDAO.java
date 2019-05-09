package com.infosys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.infosys.models.Customer;
import com.infosys.util.ConnectionFactory;

public class CustomerDAO implements DAO<Customer>{


	private static Logger log = Logger.getLogger(CustomerDAO.class);
	
	
	@Override
	public List<Customer> getAll() {
		
		List<Customer> cust = new ArrayList<Customer>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM Customer");
			cust = this.mapResultSet(rs);
			
			// Hide all user passwords for security purposes
			cust.forEach(customer -> customer.setCust_password("*********"));
			
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		
		return cust;
		
		
	}

	
	@Override
	public Customer getById(int id) {
		Customer cust = new Customer();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Customer WHERE CUST_ID = ?");
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			List<Customer> users = this.mapResultSet(rs);
			
			if(!users.isEmpty()) {
				cust = users.get(0);
				cust.setCust_password("*********");
			}
			
		} catch (SQLException e ){
			log.error(e.getMessage());
			
		}
		return cust;
	}

	
	@Override
	public Customer add(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Customer update(Customer updatedObj) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	private List<Customer> mapResultSet(ResultSet rs) throws SQLException {
		
		List<Customer> custs = new ArrayList<>();
		
		log.info("inside the mapResultsSet()");
		
		while(rs.next()) {
			Customer cust = new Customer();
			cust.setCust_id(rs.getInt("CUST_ID"));
			cust.setCust_fname(rs.getString("CUST_FIRST_NAME"));
			cust.setCust_lname(rs.getString("CUST_LAST_NAME"));
			cust.setCust_email(rs.getString("CUST_EMAIL"));
			cust.setCust_password(rs.getString("CUST_PASSWORD"));

			
			custs.add(cust);
			log.info(cust);
		}
		
		log.info(custs);
		
		return custs;
	}
	
	
	
	
}
