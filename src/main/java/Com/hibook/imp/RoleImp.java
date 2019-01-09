package Com.hibook.imp;

import java.util.List;

import Com.hibook.entity.Role;

public interface RoleImp {

	List<Role> getAllRole();
	int addRole(Role role);
	boolean updateRole(Role role);
}
