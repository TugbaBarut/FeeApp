package com.LastManagement.feeApp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class StudentModel {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int student_rollno;
private String student_sex;
private String student_course;
private int student_fee;
private int student_paid;
private int student_due;
private String student_address;
private String student_contact;

private  String student_name;
private  String student_email;

public int getStudent_rollno() {
	return student_rollno;
}
public void setStudent_rollno(int student_rollno) {
	this.student_rollno = student_rollno;
}
public String getStudent_sex() {
	return student_sex;
}
public void setStudent_sex(String student_sex) {
	this.student_sex = student_sex;
}
public String getStudent_course() {
	return student_course;
}
public void setStudent_course(String student_course) {
	this.student_course = student_course;
}
public int getStudent_fee() {
	return student_fee;
}
public void setStudent_fee(int student_fee) {
	this.student_fee = student_fee;
}
public int getStudent_paid() {
	return student_paid;
}
public void setStudent_paid(int student_paid) {
	this.student_paid = student_paid;
}
public int getStudent_due() {
	return student_due;
}
public void setStudent_due(int student_due) {
	this.student_due = student_due;
}
public String getStudent_address() {
	return student_address;
}
public void setStudent_address(String student_address) {
	this.student_address = student_address;
}
public String getStudent_contact() {
	return student_contact;
}
public void setStudent_contact(String student_contact) {
	this.student_contact = student_contact;
}
public String getStudent_name() {
	return student_name;
}
public void setStudent_name(String student_name) {
	this.student_name = student_name;
}
public String getStudent_email() {
	return student_email;
}
public void setStudent_email(String student_email) {
	this.student_email = student_email;
}


}
