package com.LastManagement.feeApp.DAO;

import java.util.List;

import com.LastManagement.feeApp.Model.Accountant;
import com.LastManagement.feeApp.Model.StudentModel;


public interface Admin_DAO {
	public void addAccountant(Accountant accountantl);

	public List<Accountant> getAccountants();

	public Accountant findById(int id);

	public Accountant update(Accountant accountant, int id);

	public void delete(int id);
}
