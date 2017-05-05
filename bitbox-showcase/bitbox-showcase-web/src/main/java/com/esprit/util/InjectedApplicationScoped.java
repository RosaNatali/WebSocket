package com.esprit.util;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;

import persistence.User;
import services.UserServicesRemote;


/**
 * @author Saria ESSID
 *
 */

@ApplicationScoped
public class InjectedApplicationScoped
{

	@EJB
	private UserServicesRemote usr;
	
	public void createUser(String name)
	{
		User user = new User(name);
		usr.addUser(user);
	}
	
}