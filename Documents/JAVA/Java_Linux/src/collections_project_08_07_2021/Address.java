package collections_project_08_07_2021;

import java.util.*;

public class Address {
	
	private List<Structure> ls;

	public Address() {
		this.ls = new ArrayList<Structure>();
	}

	public List<Structure> getLs() {
		return ls;
	}

	public void setLs(List<Structure> ls) {
		this.ls = ls;
	}
	
	
}


class Structure{      //structure of address
	
	private String city;
	private int zipcode;
	
	public Structure(String city, int zipcode) {
		super();
		this.city = city;
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	
	
}