package services;

import java.util.List;

import javax.ejb.Local;

import persistence.User;

@Local
public interface UserServicesLocal {
	void addUser(User user);
	
	List<User> findAllUsers();
	
	User findUserById(Integer id);
}
