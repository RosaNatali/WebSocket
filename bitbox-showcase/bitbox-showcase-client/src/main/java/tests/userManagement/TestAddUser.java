package tests.userManagement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.User;
import services.UserServicesRemote;

//import entities.User;
//import services.userManagement.UserManagementRemote;

public class TestAddUser {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserServicesRemote usr = (UserServicesRemote) context
				.lookup("bitbox-showcase-ear/bitbox-showcase-ejb/UserServices!services.UserServicesRemote");
		User user = new User();
		user.setId(1);
		user.setName("Cristiano Ronaldo");
		usr.addUser(user);
	}
}
