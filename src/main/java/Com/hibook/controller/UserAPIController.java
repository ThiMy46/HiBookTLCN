package Com.hibook.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Com.hibook.entity.Role;
import Com.hibook.entity.User;
import Com.hibook.service.UserSer;

@RestController
@RequestMapping(value = "/api")
public class UserAPIController {
	@Autowired
	UserSer userSer;
	@GetMapping(value = "/user")
	public ResponseEntity<List<User>> loaduseradmin() {
		List<User> listUser=userSer.Loaduser();
		List<User> list=new ArrayList<User>();
		for (User user : listUser) {
			User us=new User();
			Role role=new Role();	
			role.setIdRole(user.getRole().getIdRole());
			role.setNameRole(user.getRole().getNameRole());
			us.setIdUser(user.getIdUser());
			us.setNameUser(user.getNameUser());
			us.setNumberphone(user.getNumberphone());
			us.setEmail(user.getEmail());
			us.setPassword(user.getPassword());
			us.setSex(user.getSex());
			us.setBirthday(user.getBirthday());
			us.setAddress(user.getAddress());
			us.setRole(role);
			list.add(us);
		}
		if(list.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
		
	}
	/*======================GET user by IDUser================= */
	@GetMapping(value = "/user/{idUser}")
	public ResponseEntity<User> getUser(@PathVariable int idUser) {
		User user=userSer.findUserbyId(idUser);
		
		User us=new User();
		Role role=new Role();	
		role.setIdRole(user.getRole().getIdRole());
		role.setNameRole(user.getRole().getNameRole());
		us.setIdUser(user.getIdUser());
		us.setNameUser(user.getNameUser());
		us.setNumberphone(user.getNumberphone());
		us.setEmail(user.getEmail());
		us.setPassword(user.getPassword());
		us.setSex(user.getSex());
		us.setBirthday(user.getBirthday());
		us.setAddress(user.getAddress());
		us.setRole(role);
		
		return new ResponseEntity<User>(us, HttpStatus.OK);
		
	}
	/*======================ADD user================= */
	@PostMapping(value="/user")
	public ResponseEntity<?> addUser(@RequestParam String nameUser, @RequestParam String numberphone,
			@RequestParam String email, @RequestParam String password, @RequestParam int role, 
			@RequestParam int sex, @RequestParam String birthday, @RequestParam String address){
		User user=new User(nameUser, numberphone, email, BCrypt.hashpw(password,BCrypt.gensalt(12)), sex, birthday, address);
		
		Role role1 =new Role();
		role1.setIdRole(role);
		user.setRole(role1);
		int idAdd=userSer.addUser(user);
		if(idAdd==0){
			return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Integer>(idAdd, HttpStatus.OK);
	}
	
	@PostMapping(value="/user/{idUser}")
	public ResponseEntity<?> updatePass(@PathVariable int idUser, @RequestParam String old, @RequestParam String passnew){
		User user=userSer.findUserbyId(idUser);
		if(BCrypt.checkpw(old,user.getPassword())){
			boolean update=userSer.updatePass(idUser, BCrypt.hashpw(passnew,BCrypt.gensalt(12)));
			if(!update){
				return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Integer>(1, HttpStatus.OK);
		}else{
			return new ResponseEntity<Integer>(-1, HttpStatus.OK);
		}
		
	}
	
	/*======================Update Role by idUser================= */
	@PutMapping(value="/user/{idUser}/role/{idRole}")
	public ResponseEntity<?> updateRoleUser(@PathVariable int idUser, @PathVariable int idRole){
		boolean up=userSer.updateRoleUser(idUser, idRole);
		if(!up){
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	/*======================Update User================= */
	@PutMapping(value="/user/{idUser}")
	public ResponseEntity<?> updateUser(@PathVariable int idUser, @RequestBody User user){
		System.out.println(idUser);
		user.setIdUser(idUser);
		boolean update=userSer.updateUser(user);
		if(!update){
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	/*======================DELETE user by ID================= */
	@DeleteMapping(value="/user/{idUser}")
	public ResponseEntity<?> deleteAuthor(@PathVariable int idUser){
		/*======================================ADMIN========== */
		boolean delete=userSer.deleteUser(idUser);
		if(!delete){
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	

}
