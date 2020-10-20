package com.bridgelabz.addressbookbuilder;

import java.util.List;

public class AddressBook {
	private String Bid;
	private List<Contact> contacts;

	public AddressBook(String Bid, List<Contact> contacts) {
		this.Bid = Bid;
		this.contacts = contacts;
	}
    //getter
	public String getBid() {
		return Bid;
	}


	public List<Contact> getContacts() {
		return contacts;
	}

	//setter
	public void setBid(String Bid) {
		this.Bid = Bid;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
}
