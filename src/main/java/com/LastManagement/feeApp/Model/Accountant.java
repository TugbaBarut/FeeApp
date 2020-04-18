package com.LastManagement.feeApp.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Accountants")

public class Accountant {


	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
  private int id;

	@Column(name="name")
  private  String name;
  
	@Column(name="email")
  private String email;
   
	@Column(name="password")
  private String password;
   
	@Column(name="address")
  private String address;
  
	@Column(name="contact")
   private String contact;

	public Accountant() {
		super();
	}

	public Accountant(int id, String name, String email, String password, String address, String contact) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.contact = contact;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
   
   
   
}
