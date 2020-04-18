package com.LastManagement.feeApp.DAO;

import java.util.List;

import com.LastManagement.feeApp.Model.Accountant;
import com.LastManagement.feeApp.Model.StudentModel;


public interface Accountant_DAO {
	
	public void addStudent(StudentModel studentModel);
    
	public Accountant viewAccountant(int id);
   
	public Accountant updateAccountant(Accountant accountant ,int id);
	
	public List<StudentModel> getStudents();

	public StudentModel findById(int id);

	public StudentModel update(StudentModel studentModel, int id);

	public void delete(int id);
}
