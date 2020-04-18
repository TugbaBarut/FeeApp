package com.LastManagement.feeApp.DAO;





import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.LastManagement.feeApp.Model.StudentModel;
@Repository
public class Student_DAO_Imp implements Student_DAO{
@Autowired
private SessionFactory sessionFactory;

@Override
public StudentModel viewStudent(int id) {

	
	return sessionFactory.getCurrentSession().get(StudentModel.class, id);
}

@Override
public StudentModel updateStudent(StudentModel student, int id) {
	Session session = sessionFactory.getCurrentSession();
	StudentModel studentToUpdate = viewStudent(id);
	studentToUpdate.setStudent_rollno(student.getStudent_rollno());
	studentToUpdate.setStudent_name(student.getStudent_name());
	session.update(studentToUpdate);
	return studentToUpdate;
	
}





}
