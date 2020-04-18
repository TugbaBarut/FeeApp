package com.LastManagement.feeApp.DAO;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.LastManagement.feeApp.Model.Accountant;


@Repository
@Transactional
public class Admin_DAO_Imp  implements Admin_DAO{
	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public void addAccountant(Accountant accountant) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(accountant);
	}

	
	@Override
	public List<Accountant> getAccountants() {
		
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Accountant> criteria = builder.createQuery(Accountant.class);
	    Root<Accountant> myObjectRoot = criteria.from(Accountant.class);
	    criteria.select(myObjectRoot);
		TypedQuery<Accountant> query = session.createQuery(criteria);
		return query.getResultList();
	}

	@Override
	public Accountant findById(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Accountant accountant = session.get(Accountant.class, id);
		return accountant;
	}

	
	@Override
	public Accountant update(Accountant accountant, int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Accountant accountantToUpdate = findById(id);
		accountantToUpdate.setName(accountant.getName());
		accountantToUpdate.setEmail(accountant.getEmail());
		session.update(accountantToUpdate);
		return accountantToUpdate;
	}

	
	@Override
	public void delete(int id) {
		
		Session session = sessionFactory.getCurrentSession();
	   Accountant accountantToDelete = findById(id);
		session.delete(accountantToDelete);
	}

}
