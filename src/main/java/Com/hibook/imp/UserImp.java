package Com.hibook.imp;

import java.util.List;

import Com.hibook.entity.User;

public interface UserImp {
	List<User> Loaduser();
	int addUser(User user);
	User findUserbyId(int idUser);
	boolean deleteUser(int idUser);
	boolean updateUser(User user);
	boolean updatePass(int idUser, String passNew);
	boolean updateRoleUser(int idUser, int idRole);
}
