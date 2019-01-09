package Com.hibook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.hibook.dao.UserDao;
import Com.hibook.entity.User;
import Com.hibook.imp.UserImp;

@Service
public class UserSer implements UserImp{
	 @Autowired
	 UserDao userDAO;
	public List<User> Loaduser() {
		return userDAO.Loaduser();
	}
	public boolean deleteUser(int idUser) {
		return userDAO.deleteUser(idUser);
	}
	public boolean updateRoleUser(int idUser, int idRole) {
		return userDAO.updateRoleUser(idUser, idRole);
	}
	public int addUser(User user) {
		return userDAO.addUser(user);
	}
	public User findUserbyId(int idUser) {
		return userDAO.findUserbyId(idUser);
	}
	public boolean updateUser(User user) {
		return userDAO.updateUser(user);
	}
	public boolean updatePass(int idUser, String passNew) {
		return userDAO.updatePass(idUser, passNew);
	}

}
