package Com.hibook.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Com.hibook.entity.Role;
import Com.hibook.imp.RoleImp;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class RoleDAO implements RoleImp{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<Role> getAllRole() {
		Session session=sessionFactory.getCurrentSession();
		List<Role> roles= session.createQuery("from role").getResultList();
		return roles;
	}

	@Transactional
	public int addRole(Role role) {
		Session session=sessionFactory.getCurrentSession();
		int kt=(Integer) session.save(role);
		return kt;
	}

	@Transactional
	public boolean updateRole(Role role) {
		Session session=sessionFactory.getCurrentSession();
		Role role2=session.get(Role.class, role.getIdRole());
		role2.setNameRole(role.getNameRole());
		try{
			session.update(role2);
		}catch (Exception e) {
			return false;
		}
		return true;
	}


}
