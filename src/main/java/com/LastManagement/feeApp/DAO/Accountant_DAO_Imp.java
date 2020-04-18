package com.LastManagement.feeApp.DAO;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.LastManagement.feeApp.Model.Accountant;
import com.LastManagement.feeApp.Model.StudentModel;

@Repository
@Transactional
public class Accountant_DAO_Imp implements Accountant_DAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public void addStudent(StudentModel studentmodel) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(studentmodel);
	}

	
	@Override
	public List<StudentModel> getStudents() {
		
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<StudentModel> criteria = builder.createQuery(StudentModel.class);
	    Root<StudentModel> myObjectRoot = criteria.from(StudentModel.class);
	    criteria.select(myObjectRoot);
		TypedQuery<StudentModel> query = session.createQuery(criteria);
		return query.getResultList();
	}

	@Override
	public StudentModel findById(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		StudentModel studentModel = session.get(StudentModel.class, id);
		return studentModel;
	}

	
	@Override
	public StudentModel update(StudentModel studentModel, int id) {
		
		Session session = sessionFactory.getCurrentSession();
		StudentModel studentToUpdate = findById(id);
		studentToUpdate.setStudent_rollno(studentModel.getStudent_rollno());
		studentToUpdate.setStudent_name(studentModel.getStudent_name());
		session.update(studentToUpdate);
		return studentToUpdate;
	}

	
	@Override
	public void delete(int id) {
		
		Session session = sessionFactory.getCurrentSession();
	   StudentModel studentToDelete = findById(id);
		session.delete(studentToDelete);
	}


	@Override
	public Accountant viewAccountant(int id) {
		Session session = sessionFactory.getCurrentSession();
		Accountant accountant = session.get(Accountant.class, id);
		return accountant;
	}


	@Override
	public Accountant updateAccountant(Accountant accountant, int id) {
		Session session = sessionFactory.getCurrentSession();
		Accountant accountantToUpdate = viewAccountant(id);
		accountantToUpdate.setId(accountant.getId());
		accountantToUpdate.setName(accountant.getName());
		session.update(accountantToUpdate);
		return accountantToUpdate;
	}

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//	@Autowired
//	private SessionFactory sessionFactory;
//	@Override
//	public boolean saveStudent(StudentModel student) {
//		
//		
//		
//	 boolean status=false;
//	 try {
//		 sessionFactory.getCurrentSession().save(student);
//	 status=true;
//	 }catch(Exception e) {
//		 e.printStackTrace();
//	 }
//	 return status;
//	}
//
//	@Override
//	public List<StudentModel> getStudents() {
//		Session currentSession=sessionFactory.getCurrentSession();
//		Query<StudentModel>	query=currentSession.createQuery("from Student",StudentModel.class);
//		List<StudentModel> list=query.getResultList();
//		
//		return list;
//	}
//
//	@Override
//	public boolean deleteStudent(StudentModel student) {
//		boolean status=false;
//		try {
//			sessionFactory.getCurrentSession().delete(student);
//		status=true;
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return status;
//	}
//
//	@Override
//	public List<StudentModel> getStudentByID(StudentModel student) {
//			        Session currentSession = sessionFactory.getCurrentSession();  
//			        Query<StudentModel> query=currentSession.createQuery("from Student where student_rollno=:student_rollno", StudentModel.class);  
//		        query.setParameter("student_id", student.getStudent_rollno());  
//			        List<StudentModel> list=query.getResultList();  
//			        return list;  
//
//	}
//	@Override
//	public boolean updateStudent(StudentModel student) {
//		boolean status=false;  
//			        try {  
//			            sessionFactory.getCurrentSession().update(student);  
//			            status=true;  
//		        } catch (Exception e) {  
//			            e.printStackTrace();  
//			        }  
//			        return status;  
//
//	}
//}

