package Com.hibook.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import Com.hibook.entity.Bill;
import Com.hibook.service.BillSer;
import Com.hibook.service.CartSer;

@Controller
public class InfoUserAPICon {
	@Autowired
	CartSer cartser;
    @RequestMapping({"/info_user/{idUser}"})
    public String chitiet(@PathVariable int idUser,ModelMap model) {
    	Com.hibook.entity.User use=new Com.hibook.entity.User();
    	String em="";
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(auth.getPrincipal() instanceof User) {
        	User us=(User)(auth.getPrincipal());
        	String email=us.getUsername();
        	use=cartser.getUser(email);
        	em=email;
        	int id=use.getIdUser(); 	
        	//System.out.println(id);
        	model.addAttribute("getIdUser", id);
    	}
    	model.addAttribute("info", use);
    	model.addAttribute("email", em);
    	
    	return "info_user";
    	
        
    }
    @RequestMapping({"/user_bill/{idUser}"})
    public String userbill(@PathVariable int idUser, ModelMap model) {
    	Com.hibook.entity.User use=new Com.hibook.entity.User();
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(auth.getPrincipal() instanceof User) {
    		User us=(User)(auth.getPrincipal());
        	String email=us.getUsername();
        	use=cartser.getUser(email);
        	model.addAttribute("getIdUser",use.getIdUser());
        	model.addAttribute("info",use);
    	}
    	return "info_user_bill";
    }
    @RequestMapping({"/user_update/{idUser}"})
    public String userupdate(@PathVariable int idUser, ModelMap model) {
    	Com.hibook.entity.User use=new Com.hibook.entity.User();
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(auth.getPrincipal() instanceof User) {
    		User us=(User)(auth.getPrincipal());
        	String email=us.getUsername();
        	use=cartser.getUser(email);
        	model.addAttribute("getIdUser",use.getIdUser());
        	model.addAttribute("info",use);
    	}
    	return "info_user_update";
    }

}
