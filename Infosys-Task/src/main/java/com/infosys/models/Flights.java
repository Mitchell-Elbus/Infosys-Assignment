package com.infosys.models;

public class Flights {

	private int flight_id;
	private String dep_location;
	private String dep_time;
	private String arr_location;
	private String arr_time;
	private int fl_airline_id;
	
	public Flights () {
		super();
	}

	public Flights(int flight_id, String dep_location, String dep_time, String arr_location, String arr_time,
			int fl_airline_id) {
		super();
		this.flight_id = flight_id;
		this.dep_location = dep_location;
		this.dep_time = dep_time;
		this.arr_location = arr_location;
		this.arr_time = arr_time;
		this.fl_airline_id = fl_airline_id;
	}

	public int getFlight_id() {
		return flight_id;
	}

	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}

	public String getDep_location() {
		return dep_location;
	}

	public void setDep_location(String dep_location) {
		this.dep_location = dep_location;
	}

	public String getDep_time() {
		return dep_time;
	}

	public void setDep_time(String dep_time) {
		this.dep_time = dep_time;
	}

	public String getArr_location() {
		return arr_location;
	}

	public void setArr_location(String arr_location) {
		this.arr_location = arr_location;
	}

	public String getArr_time() {
		return arr_time;
	}

	public void setArr_time(String arr_time) {
		this.arr_time = arr_time;
	}

	public int getFl_airline_id() {
		return fl_airline_id;
	}

	public void setFl_airline_id(int fl_airline_id) {
		this.fl_airline_id = fl_airline_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arr_location == null) ? 0 : arr_location.hashCode());
		result = prime * result + ((arr_time == null) ? 0 : arr_time.hashCode());
		result = prime * result + ((dep_location == null) ? 0 : dep_location.hashCode());
		result = prime * result + ((dep_time == null) ? 0 : dep_time.hashCode());
		result = prime * result + fl_airline_id;
		result = prime * result + flight_id;
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
		Flights other = (Flights) obj;
		if (arr_location == null) {
			if (other.arr_location != null)
				return false;
		} else if (!arr_location.equals(other.arr_location))
			return false;
		if (arr_time == null) {
			if (other.arr_time != null)
				return false;
		} else if (!arr_time.equals(other.arr_time))
			return false;
		if (dep_location == null) {
			if (other.dep_location != null)
				return false;
		} else if (!dep_location.equals(other.dep_location))
			return false;
		if (dep_time == null) {
			if (other.dep_time != null)
				return false;
		} else if (!dep_time.equals(other.dep_time))
			return false;
		if (fl_airline_id != other.fl_airline_id)
			return false;
		if (flight_id != other.flight_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Flights [flight_id=" + flight_id + ", dep_location=" + dep_location + ", dep_time=" + dep_time
				+ ", arr_location=" + arr_location + ", arr_time=" + arr_time + ", fl_airline_id=" + fl_airline_id
				+ "]";
	}
	
	
	
	
}
