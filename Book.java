package com.bridgelabz.addressbookbuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Book implements AddressBookInterface {

	private List<AddressBook> addressBook;

	public Book() {
		addressBook = new ArrayList<AddressBook>();
		addressBook.add(new AddressBook("123", new ArrayList<Contact>()));
	}

	public static void main(String[] args) {

		Book book = new Book();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the AddressBook ID : ");
		String Bid = sc.next();

		if (!ExistingAddressBook(book, Bid)) {
			System.out.println(" doesn't exist!");
			System.exit(0);
		}
		
		String choiceyn;
		do {
			System.out.println("Enter an option : \n 1)Create \n 2)Update \n 3)Delete \n 4)Sort-By Name \n 5)Sort-By ZipCode \n 6)Display \n 7)Exit  ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				book.create(Bid);
				break;
			case 2:
				book.update(Bid);
				break;
			case 3:
				book.delete(Bid);
				break;
			case 4:
				book.sortByName(Bid);
				break;
			case 5:
				book.sortZip(Bid);
				break;
			case 6:
				book.display(Bid);
				break;
			default:
				System.out.println("Invalid !");
				break;
			}
			System.out.println("Continue?(Y/N)");
			choiceyn = sc.next();
		} while (choiceyn.equals("Y")||choiceyn.equals("y"));

		sc.close();

	}

	
	private static boolean ExistingAddressBook(Book book, String Bid) {
		for (AddressBook b : book.addressBook) {
			if (b.getBid().equals(Bid)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void create(String Bid) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID : ");
		long id = sc.nextLong();
		System.out.println("Enter First name : ");
		String fname = sc.next();
		System.out.println("Enter Last name : ");
		String lname = sc.next();
		System.out.println("Enter Address : ");
		String address = sc.next();
		System.out.println("Enter City : ");
		String city = sc.next();
		System.out.println("Enter State : ");
		String state = sc.next();
		System.out.println("Enter zip : ");
		String zip = sc.next();
		System.out.println("Enter Phone Number : ");
		String phoneNo = sc.next();
		for (AddressBook b : addressBook) {
			if (b.getBid().equals(Bid)) {
				b.getContacts().add(new Contact(id, fname, lname, address, city, state, zip, phoneNo));
				break;
			}
		}
		System.out.println("Contact added ");
	}

	@Override
	public void update(String Bid) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the person ID:");
		long id = sc.nextLong();
		for (AddressBook b : addressBook) {
			if (b.getBid().equals(Bid)) {
				for (Contact c : b.getContacts()) {
					if (c.getId() == id) {
						System.out.println(c);
						System.out.println("Enter First name:");
						String fname = sc.next();
						System.out.println("Enter Last name:");
						String lname = sc.next();
						System.out.println("Enter Address:");
						String address = sc.next();
						System.out.println("Enter City:");
						String city = sc.next();
						System.out.println("Enter State:");
						String state = sc.next();
						System.out.println("Enter Zip:");
						String zip = sc.next();
						System.out.println("Enter Phone Number : ");
						String phoneNo = sc.next();
						c.setFirstName(fname);
						c.setLastName(lname);
						c.setAddress(address);
						c.setCity(city);
						c.setState(state);
						c.setZip(zip);
						c.setPhoneNo(phoneNo);
						System.out.println("Updated");
						return;
					}
				}
				break;
			}
		}
		System.out.println("doesn't exist!");
	}

	@Override
	public void delete(String Bid) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id:");
		long id = sc.nextLong();
		for (AddressBook b : addressBook) {
		if (b.getBid().equals(Bid)) {
		  for (Contact c : b.getContacts()) {
				if (c.getId() == id) {
				   b.getContacts().remove(c);
						System.out.println("Deleted ");
						return;
					}
				}
				break;
			}
		  }
		    System.out.println("Doesn't exist!");
	    }

	@Override
	public void sortByName(String Bid) {
		for (AddressBook b : addressBook) {
			if (b.getBid().equals(Bid)) {
				Collections.sort(b.getContacts(), new Comparator<Contact>() {

					@Override
					public int compare(Contact o1, Contact o2) {
						return o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
					}});
				System.out.println("Book name sorted");
				break;
			}
		}
	}

	@Override
	public void sortZip(String Bid) {
		for (AddressBook b : addressBook) {
			if (b.getBid().equals(Bid)) {
				Collections.sort(b.getContacts(), new Comparator<Contact>() {

					@Override
					public int compare(Contact o1, Contact o2) {
					if (Long.parseLong(o1.getZip()) <= Long.parseLong(o2.getZip())) {
					return -1;
					}
					return 1;
					}});
				System.out.println("Zip sorted ");
				break;
			}
		}
	}

	@Override
	public void display(String Bid) {
		for (AddressBook b : addressBook) {
			if (b.getBid().equals(Bid)) {
				for (Contact c : b.getContacts()) {
				System.out.println(c);
				}
				break;
			}
		}
	}


}
