package com.infosys.models;

public class Reservation {

	private int res_id;
	private int res_flight_id;
	private int res_cust_id;
	
	public Reservation() {
		super();
	}

	public Reservation(int res_id, int res_flight_id, int res_cust_id) {
		super();
		this.res_id = res_id;
		this.res_flight_id = res_flight_id;
		this.res_cust_id = res_cust_id;
	}

	public int getRes_id() {
		return res_id;
	}

	public void setRes_id(int res_id) {
		this.res_id = res_id;
	}

	public int getRes_flight_id() {
		return res_flight_id;
	}

	public void setRes_flight_id(int res_flight_id) {
		this.res_flight_id = res_flight_id;
	}

	public int getRes_cust_id() {
		return res_cust_id;
	}

	public void setRes_cust_id(int res_cust_id) {
		this.res_cust_id = res_cust_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + res_cust_id;
		result = prime * result + res_flight_id;
		result = prime * result + res_id;
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
		Reservation other = (Reservation) obj;
		if (res_cust_id != other.res_cust_id)
			return false;
		if (res_flight_id != other.res_flight_id)
			return false;
		if (res_id != other.res_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reservation [res_id=" + res_id + ", res_flight_id=" + res_flight_id + ", res_cust_id=" + res_cust_id
				+ "]";
	}
	
	
	
	
	
}
