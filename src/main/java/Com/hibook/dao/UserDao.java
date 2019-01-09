package Com.hibook.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Com.hibook.entity.Role;
import Com.hibook.entity.User;
import Com.hibook.imp.UserImp;
@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class UserDao implements UserImp {
	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	public List<User> Loaduser() {
		Session session=sessionFactory.getCurrentSession();
		List<User> loaduser=(List<User>) session.createQuery("from user").getResultList();
		// TODO Auto-generated method stub
		return loaduser;
	}
	
	@Transactional
	public int addUser(User user) {
		Session session=sessionFactory.getCurrentSession();
		Role role= session.get(Role.class, user.getRole().getIdRole());
		user.setRole(role);
		int kt=(Integer) session.save(user);
		return kt;
	}
	
	@Transactional
	public boolean updateRoleUser(int idUser, int idRole) {
		Session session=sessionFactory.getCurrentSession();
		Query us= session.createQuery("update user set idRole= :idRole where idUser = :idUser");
		us.setParameter("idRole", idRole);
		us.setParameter("idUser", idUser);
		try{
			us.executeUpdate();
		}catch (Exception e) {
			return false;
		}
		return true;
	}

	@Transactional
	public boolean deleteUser(int idUser) {
		Session session=sessionFactory.getCurrentSession();
		Query de= session.createQuery("delete user where idUser = :idUser");
		de.setParameter("idUser", idUser);
		
		try{
			de.executeUpdate();
		}catch (Exception e) {
			return false;
		}
		return true;
	}

	@Transactional
	public User findUserbyId(int idUser) {
		Session session=sessionFactory.getCurrentSession();
		User user=session.get(User.class, idUser);
		return user;
	}
	@Transactional
	public boolean updateUser(User user) {
		Session session=sessionFactory.getCurrentSession();
		Query us;
		if(user.getPassword().equals("")){
			 us= session.createQuery("update user set nameUser = :nameUser, numberphone= :numberphone, email= :email, sex= :sex, birthday= :birthday, address= :address where idUser = :idUser");
		}else{
			us= session.createQuery("update user set nameUser = :nameUser, numberphone= :numberphone, email= :email, password= :password, sex= :sex, birthday= :birthday, address= :address where idUser = :idUser");
			us.setParameter("password", BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
		}
		us.setParameter("nameUser", user.getNameUser());
		us.setParameter("numberphone", user.getNumberphone());
		us.setParameter("email", user.getEmail());
		us.setParameter("sex", user.getSex());
		us.setParameter("birthday", user.getBirthday());
		us.setParameter("address", user.getAddress());
		us.setParameter("idUser", user.getIdUser());
		try{
			us.executeUpdate();
		}catch (Exception e) {
			return false;
		}
		return true;
	}

	@Transactional
	public boolean updatePass(int idUser, String passNew) {
		Session session=sessionFactory.getCurrentSession();
		Query us= session.createQuery("update user set password= :password where idUser = :idUser");
			us.setParameter("password", passNew);
			us.setParameter("idUser", idUser);
		
		try{
			us.executeUpdate();
		}catch (Exception e) {
			return false;
		}
		return true;
	}
}
