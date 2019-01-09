package Com.hibook.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Com.hibook.DTO.CartDTO;
import Com.hibook.entity.Book;
import Com.hibook.entity.Cart;
import Com.hibook.service.CartSer;
@RestController
public class CartAPICon {
	@Autowired
	CartSer cartser;
    @RequestMapping({"/detail1"})
    public String chitiet() {
    	int soluong=0;
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(auth.getPrincipal() instanceof User) {
        	User us=(User)(auth.getPrincipal());
        	String email=us.getUsername();
        	Com.hibook.entity.User use=cartser.getUser(email);
        	int id=use.getIdUser();  	
        	List<Cart> getquantity=cartser.getquantitynotice(id);
        	soluong= getquantity.size();
    	}
    	System.out.println(soluong);
    	return soluong+"";
        
    }


}
