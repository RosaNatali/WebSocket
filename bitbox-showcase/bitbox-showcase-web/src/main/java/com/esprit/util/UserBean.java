package com.esprit.util;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import persistence.User;
import services.UserServicesRemote;

/**
 * @author Saria ESSID
 *
 */

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean
{
	private User user;
    
	
	@EJB
	private UserServicesRemote usr;

	@PostConstruct
	public void init()
	{
		user = new User();
	}
	
	
//	public void createUser()
//	{
//		usr.addUser(user);
//	}

	
     
  
	/************************************** Getters & Setters *************************************/



	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	public UserServicesRemote getUsr() {
		return usr;
	}


	public void setUsr(UserServicesRemote usr) {
		this.usr = usr;
	}

	
	

		
}
