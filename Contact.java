package com.bridgelabz.addressbookbuilder;

public class Contact {
	private long id;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phoneNo;

	public Contact(long id, String firstName, String lastName, String address, String city, String state, String zip,String phoneNo) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNo = phoneNo;
	}
	 
	//GETTER
	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public String getAddress() {
		return address;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}
	public String getPhoneNo() {
		return phoneNo;
	}

	//SETTER
	public void setId(long id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		String addressres = "Name: " + firstName + " " + lastName + "\nPhone: " + phoneNo + "\nAddress: " + address	+ ", " + city + ", " + state + 
				"\nZIP: " + zip;
		return addressres;
	}
}
