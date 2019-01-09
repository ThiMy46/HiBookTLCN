package Com.hibook.security;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.SessionAttributes;

import Com.hibook.dao.UserDao;
import Com.hibook.dao.UserDaoSercurity;
import Com.hibook.entity.User;
import Com.hibook.imp.UserImp;
import Com.hibook.service.UserSer;
 
@Service
public class MyUserDetailsService implements UserDetailsService {
 
    
    private UserDaoSercurity userDao; 
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.loadUserEmail(username);
        String name=user.getEmail();
        int idUser=user.getIdUser();
        System.out.println("User= " + name);
        System.out.println("User= " + idUser);
        if (name == null) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
         
        String role= user.getRole().getNameRole();
         
        List<GrantedAuthority> grantList= new ArrayList<GrantedAuthority>();
        if(role!= null)  {
                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
                grantList.add(authority);
        }        
         
        UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(user.getEmail(), //
                user.getPassword(),grantList);
 
        return userDetails;
    }


	public UserDaoSercurity getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDaoSercurity userDao) {
		this.userDao = userDao;
	}
 
}