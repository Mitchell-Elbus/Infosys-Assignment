package com.infosys.models;

public class Customer {

	private int cust_id;
	private String cust_fname;
	private String cust_lname;
	private String cust_email;
	private String cust_password;
	
	public Customer() {
		super();
	}

	
	
	
	public Customer(int cust_id, String cust_fname, String cust_lname, String cust_email, String cust_password) {
		super();
		this.cust_id = cust_id;
		this.cust_fname = cust_fname;
		this.cust_lname = cust_lname;
		this.cust_email = cust_email;
		this.cust_password = cust_password;
	}




	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_fname() {
		return cust_fname;
	}

	public void setCust_fname(String cust_fname) {
		this.cust_fname = cust_fname;
	}

	public String getCust_lname() {
		return cust_lname;
	}

	public void setCust_lname(String cust_lname) {
		this.cust_lname = cust_lname;
	}

	public String getCust_email() {
		return cust_email;
	}

	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}

	public String getCust_password() {
		return cust_password;
	}

	public void setCust_password(String cust_password) {
		this.cust_password = cust_password;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cust_email == null) ? 0 : cust_email.hashCode());
		result = prime * result + ((cust_fname == null) ? 0 : cust_fname.hashCode());
		result = prime * result + cust_id;
		result = prime * result + ((cust_lname == null) ? 0 : cust_lname.hashCode());
		result = prime * result + ((cust_password == null) ? 0 : cust_password.hashCode());
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
		Customer other = (Customer) obj;
		if (cust_email == null) {
			if (other.cust_email != null)
				return false;
		} else if (!cust_email.equals(other.cust_email))
			return false;
		if (cust_fname == null) {
			if (other.cust_fname != null)
				return false;
		} else if (!cust_fname.equals(other.cust_fname))
			return false;
		if (cust_id != other.cust_id)
			return false;
		if (cust_lname == null) {
			if (other.cust_lname != null)
				return false;
		} else if (!cust_lname.equals(other.cust_lname))
			return false;
		if (cust_password == null) {
			if (other.cust_password != null)
				return false;
		} else if (!cust_password.equals(other.cust_password))
			return false;
		return true;
	}




	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", cust_fname=" + cust_fname + ", cust_lname=" + cust_lname
				+ ", cust_email=" + cust_email + ", cust_password=" + cust_password + "]";
	}
	
	
	
}
