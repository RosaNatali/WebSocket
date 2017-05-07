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
	private String aa;
    
	
	@EJB
	private UserServicesRemote usr;

	@PostConstruct
	public void init()
	{
		user = new User();
	}
	
	public String getText() {
        return " Sarsoura";
    }
	
	public void createUser()
	{
		System.out.println("------------------------------------- LOL");
		usr.addUser(user);
	}

//	public void deletePublication(Integer userId, Integer idPublication) {
//		Publication publication = umr.findPublicationById(idPublication);
//		umr.deletePublication(publication);
//		lps = umr.findPublicationsByUser(userId);
//	}

	
	
//	public void updatePublication(Integer id) {
//		Publication publication = umr.findPublicationById(id);
//		publication.setTitle(selectedPublication.getTitle());
//		umr.updatePublication(publication);
//	}

	
//	public void quit() throws IOException {
//		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//		session.invalidate();
//		FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
//	}
	
     
  
	/************************************** Getters & Setters *************************************/



	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getAa() {
		return aa;
	}


	public void setAa(String aa) {
		this.aa = aa;
	}


	public UserServicesRemote getUsr() {
		return usr;
	}


	public void setUsr(UserServicesRemote usr) {
		this.usr = usr;
	}

	
	

		
}
