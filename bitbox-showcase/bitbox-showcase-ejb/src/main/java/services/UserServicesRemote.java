package services;

import java.util.List;

import javax.ejb.Remote;

import persistence.User;

@Remote
public interface UserServicesRemote {
	void addUser(User user);

	List<User> findAllUsers();
	
	User findUserById(Integer id);
}
