package Com.hibook.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Com.hibook.entity.Role;
import Com.hibook.service.RoleSer;

/*===================DETAIL Role================ */
@RestController
@RequestMapping(value = "/api")
public class RoleAPICon {

	@Autowired
	RoleSer roleSer;
	
	/*======================GET all Role================= */
	@GetMapping(value = "/role")
	public ResponseEntity<?> loadRole(){
		List<Role> listRole=roleSer.getAllRole();
		List<Role> loadlist=new ArrayList<Role>();
		for (Role role : listRole) {
			Role role2  =new Role();
			role2.setIdRole(role.getIdRole());
			role2.setNameRole(role.getNameRole().toString());
			
			loadlist.add(role2);
		}
		if(loadlist.isEmpty()) {
			return new ResponseEntity<List<Role>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<Role>>(loadlist,HttpStatus.OK);
	}
	/*======================ADD Role================= */
	@PostMapping(value="/role")
	public ResponseEntity<?> addRole(@RequestParam String nameRole){
		Role role=new Role();
		role.setNameRole(nameRole);
		int idAdd=roleSer.addRole(role);
		if(idAdd==0){
			return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Integer>(1, HttpStatus.OK);
	}
	/*======================UPDATE Role================= */
	@PutMapping(value="/role")
	public ResponseEntity<?> updateRole(@RequestParam int idRole, @RequestParam String nameRole){
		Role role=new Role(idRole,nameRole);
		boolean update=roleSer.updateRole(role);
		if(!update){
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	/*======================NOT DELETE Role================= */
	
}
