package com.infosys.models;

public class Airline {

	private int airline_id;
	private String airline_name;
	
	
	public Airline() {
		super();
	}


	public Airline(int airline_id, String airline_name) {
		super();
		this.airline_id = airline_id;
		this.airline_name = airline_name;
	}


	public int getAirline_id() {
		return airline_id;
	}


	public void setAirline_id(int airline_id) {
		this.airline_id = airline_id;
	}


	public String getAirline_name() {
		return airline_name;
	}


	public void setAirline_name(String airline_name) {
		this.airline_name = airline_name;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + airline_id;
		result = prime * result + ((airline_name == null) ? 0 : airline_name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airline other = (Airline) obj;
		if (airline_id != other.airline_id)
			return false;
		if (airline_name == null) {
			if (other.airline_name != null)
				return false;
		} else if (!airline_name.equals(other.airline_name))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Airline [airline_id=" + airline_id + ", airline_name=" + airline_name + "]";
	}
	
	
	
	
}
