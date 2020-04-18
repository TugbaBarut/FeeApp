package com.LastManagement.feeApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.LastManagement.feeApp.DAO.Accountant_DAO;
import com.LastManagement.feeApp.Model.Accountant;
import com.LastManagement.feeApp.Model.StudentModel;
//import com.LastManagement.feeApp.services.Accountant_Service;


@RestController

@RequestMapping(value="/student")
public class AccountantController {
	
	@Autowired
	Accountant_DAO accountantDao;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentModel> getStudentById(@PathVariable("id") int id) {
		System.out.println("Fetching Student with id " + id);
		StudentModel studentModel = accountantDao.findById(id);
		if (studentModel == null) {
			return new ResponseEntity<StudentModel>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<StudentModel>(studentModel, HttpStatus.OK);
	}

	@PostMapping(value = "/create", headers = "Accept=application/json")
	public ResponseEntity<Void> createStudent(@RequestBody StudentModel studentModel, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Student " + studentModel.getStudent_name());
		accountantDao.addStudent(studentModel);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/accountant/{id}").buildAndExpand(studentModel.getStudent_rollno()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@GetMapping(value = "/get", headers = "Accept=application/json")
	public List<StudentModel> getAllStudents() {
		List<StudentModel> tasks = accountantDao.getStudents();
		return tasks;

	}

	@PutMapping(value = "/update", headers = "Accept=application/json")
	public ResponseEntity<String> updateStudent(@RequestBody StudentModel currentStudent) {
		System.out.println("sd");
		StudentModel studentModel = accountantDao.findById(currentStudent.getStudent_rollno());
		if (studentModel == null) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		accountantDao.update(currentStudent, currentStudent.getStudent_rollno());
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", headers = "Accept=application/json")
	public ResponseEntity<StudentModel> deleteStudent(@PathVariable("id") int id) {
		StudentModel studentModel = accountantDao.findById(id);
		if (studentModel == null) {
			return new ResponseEntity<StudentModel>(HttpStatus.NOT_FOUND);
		}
		accountantDao.delete(id);
		return new ResponseEntity<StudentModel>(HttpStatus.NO_CONTENT);
	}

	
	@GetMapping(value = "viewAccountant/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Accountant> getAccountantById(@PathVariable("id") int id) {
		System.out.println("Fetching Accountant with id " + id);
		Accountant accountant = accountantDao.viewAccountant(id);
		if (accountant == null) {
			return new ResponseEntity<Accountant>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Accountant>(accountant, HttpStatus.OK);
	}
	
	@PutMapping(value = "/updateAccountant", headers = "Accept=application/json")
	public ResponseEntity<String> updateAccountant(@RequestBody Accountant currentAccountant) {
		System.out.println("sd");
		Accountant accountant = accountantDao.viewAccountant(currentAccountant.getId());
		if (accountant == null) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		accountantDao.updateAccountant(currentAccountant, currentAccountant.getId());
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Autowired
//	private Accountant_Service accountant_Service;
//	 @PostMapping("save-student")  
//	    public boolean saveStudent(@RequestBody StudentModel student) {  
//	         return accountant_Service.saveStudent(student);  
//	          
//	    }  
//	      
//	    @GetMapping("students-list")  
//	    public List<StudentModel> allstudents() {  
//	         return accountant_Service.getStudents();  
//	          
//	    }  
//	      
//	    @DeleteMapping("delete-student/{student_id}")  
//	    public boolean deleteStudent(@PathVariable("student_rollno") int student_rollno,StudentModel student) {  
//	        student.setStudent_rollno(student_rollno);  
//	        return accountant_Service.deleteStudent(student);  
//	    }  
//	  
//	    
//	    
//	    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//		public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
//			System.out.println("Fetching User with id " + id);
//			User user = userService.findById(id);
//			if (user == null) {
//				return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//			}
//			return new ResponseEntity<User>(user, HttpStatus.OK);
//		}   
//	    
//	    
//	    
//	    
//	    @GetMapping(value="/{student_rollno}",produces = MediaType.APPLICATION_JSON_VALUE)  
//	    public ResponseEntity<StudentModel> getstudentByID(@PathVariable("student_rollno") int student_rollno,StudentModel student) {  
//	    	System.out.println("Fetching User with id " + student_rollno);
//			StudentModel studentModel = accountant_Service.getStudentByID(student);
//			if (studentModel == null) {
//				return new ResponseEntity<StudentModel>(HttpStatus.NOT_FOUND);
//			}
//			return new ResponseEntity<StudentModel>(studentModel, HttpStatus.OK);
//		}   
//}
//	    @PostMapping("update-student/{student_id}")  
//	   	    public boolean updateStudent(@RequestBody StudentModel student,@PathVariable("student_rollno") int student_rollno) {  
//	   	        student.setStudent_rollno(student_rollno);  
//	   	        return accountant_Service.updateStudent(student);  
//	   	    }  

}
