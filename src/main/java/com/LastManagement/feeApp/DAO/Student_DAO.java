package com.LastManagement.feeApp.DAO;

import com.LastManagement.feeApp.Model.StudentModel;

public  interface Student_DAO {
	
	public StudentModel viewStudent(int id);
	   
	public StudentModel updateStudent(StudentModel student ,int id);
	
}
