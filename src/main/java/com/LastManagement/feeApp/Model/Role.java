package com.LastManagement.feeApp.Model;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="roles")
public class Role {
    @Id
   @GeneratedValue(strategy= GenerationType.AUTO)
   private long role_id;
@Enumerated(EnumType.STRING)
    private RoleType role_type;

@ManyToMany(mappedBy="roles" ,cascade = CascadeType.ALL)
private List<User> users;
@OneToMany(cascade=CascadeType.ALL,mappedBy="roles")
private List<Menu>menu;


public long getRole_id() {
	return role_id;
}
public void setRole_id(long role_id) {
	this.role_id = role_id;
}
public RoleType getRole_type() {
	return role_type;
}
public void setRole_type(RoleType role_type) {
	this.role_type = role_type;
}



}
