package services;

import javax.ejb.Local;

import persistence.User;

@Local
public interface UserServicesLocal {
	void addUser(User user);
}
