package Com.hibook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.hibook.dao.RoleDAO;
import Com.hibook.entity.Role;
import Com.hibook.imp.RoleImp;

@Service
public class RoleSer implements RoleImp{

	@Autowired
	RoleDAO roleDAO;
	
	public List<Role> getAllRole() {
		return roleDAO.getAllRole();
	}

	public int addRole(Role role) {
		return roleDAO.addRole(role);
	}

	public boolean updateRole(Role role) {
		return roleDAO.updateRole(role);
	}
}
