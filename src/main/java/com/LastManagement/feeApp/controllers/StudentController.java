package com.LastManagement.feeApp.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LastManagement.feeApp.DAO.Student_DAO;

import com.LastManagement.feeApp.Model.StudentModel;



@RestController

@RequestMapping(value="/student")
public class StudentController {
@Autowired
private Student_DAO student_DAO;
  
	@GetMapping(value = "viewStudent/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentModel> viewStudent(@PathVariable("id") int id) {
		System.out.println("Fetching Accountant with id " + id);
	StudentModel student = student_DAO.viewStudent(id);
		if (student == null) {
			return new ResponseEntity<StudentModel>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<StudentModel>(student, HttpStatus.OK);
	}
	
	@PutMapping(value = "/updateStudent", headers = "Accept=application/json")
	public ResponseEntity<String> updateStudent(@RequestBody StudentModel currentStudent) {
		System.out.println("sd");
		StudentModel studentModel = student_DAO.viewStudent(currentStudent.getStudent_rollno());
		if (studentModel == null) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		student_DAO.updateStudent(currentStudent, currentStudent.getStudent_rollno());
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
