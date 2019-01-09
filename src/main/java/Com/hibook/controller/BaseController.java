package Com.hibook.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.jaas.AuthorityGranter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import Com.hibook.entity.Bill;
import Com.hibook.entity.Cart;
import Com.hibook.entity.DetailBill;
import Com.hibook.entity.OrderStatus;
import Com.hibook.entity.Payment;
import Com.hibook.entity.Transport;
import Com.hibook.service.BillSer;
import Com.hibook.service.BookSer;
import Com.hibook.service.CartSer;
import Com.hibook.service.DetailBillSer;

@Controller
@SessionAttributes("thongbaogiohang")
public class BaseController {
	@Autowired
	DetailBillSer detailser;
	@Autowired
	BookSer book;
	@Autowired
	BillSer billser;
	@Autowired
	CartSer cartser;
	@RequestMapping({"/","/login"})
    public String home(ModelMap model) {
		Com.hibook.entity.User use1=new Com.hibook.entity.User();
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(auth.getPrincipal() instanceof User) {
        	User us=(User)(auth.getPrincipal());
        	String email=us.getUsername();     	
        	//Book book=cartser.getBook(idBook);        	
        	//
        	Com.hibook.entity.User use=cartser.getUser(email);
        	int id=use.getIdUser(); 	
        	//System.out.println(id);
        	model.addAttribute("getIdUser", id);
    	}
    	model.addAttribute("user", use1);
		
        return "trangchu";
    }
	
    /*LOAD ADMIN*/
    @RequestMapping("/admin-data")
   	public String pageAdminDatabase() {
    	
   		return "Admin_database";
   	}
    /*LOAD ADMIN MAIN*/
    @RequestMapping("/adminmain")
	public String pageAdmin(ModelMap model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(auth.getPrincipal() instanceof User) {
        	User us=(User)(auth.getPrincipal());
        	String email=us.getUsername();     	
        	//Book book=cartser.getBook(idBook);        	
        	//
        	Com.hibook.entity.User use=cartser.getUser(email);
        	int id=use.getIdUser(); 	
        	//System.out.println(id);
        	model.addAttribute("getIdUseradmin", id);
    	}
		return "Admin_Dashboard";
	}
    @RequestMapping("/admin-author")
   	public String pageAdminAuthor(ModelMap model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(auth.getPrincipal() instanceof User) {
        	User us=(User)(auth.getPrincipal());
        	String email=us.getUsername();     	
        	//Book book=cartser.getBook(idBook);        	
        	//
        	Com.hibook.entity.User use=cartser.getUser(email);
        	int id=use.getIdUser(); 	
        	//System.out.println(id);
        	model.addAttribute("getIdUseradmin", id);
    	}
   		return "Admin_Author";
   	}
    @RequestMapping("/admin-status")
   	public String pageAdminStatus(ModelMap model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(auth.getPrincipal() instanceof User) {
        	User us=(User)(auth.getPrincipal());
        	String email=us.getUsername();     	
        	//Book book=cartser.getBook(idBook);        	
        	//
        	Com.hibook.entity.User use=cartser.getUser(email);
        	int id=use.getIdUser(); 	
        	//System.out.println(id);
        	model.addAttribute("getIdUseradmin", id);
    	}
   		return "Admin_OrderStatus";
   	}
    @RequestMapping("/admin-payment")
   	public String pageAdminPayment(ModelMap model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(auth.getPrincipal() instanceof User) {
        	User us=(User)(auth.getPrincipal());
        	String email=us.getUsername();     	
        	//Book book=cartser.getBook(idBook);        	
        	//
        	Com.hibook.entity.User use=cartser.getUser(email);
        	int id=use.getIdUser(); 	
        	//System.out.println(id);
        	model.addAttribute("getIdUseradmin", id);
    	}
   		return "Admin_Payment";
   	}
    @RequestMapping("/admin-supplier")
   	public String pageAdminSuppliert(ModelMap model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(auth.getPrincipal() instanceof User) {
        	User us=(User)(auth.getPrincipal());
        	String email=us.getUsername();     	
        	//Book book=cartser.getBook(idBook);        	
        	//
        	Com.hibook.entity.User use=cartser.getUser(email);
        	int id=use.getIdUser(); 	
        	//System.out.println(id);
        	model.addAttribute("getIdUseradmin", id);
    	}
   		return "Admin_Supplier";
   	}
    @RequestMapping("/admin-transport")
   	public String pageAdminTransport(ModelMap model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(auth.getPrincipal() instanceof User) {
        	User us=(User)(auth.getPrincipal());
        	String email=us.getUsername();     	
        	//Book book=cartser.getBook(idBook);        	
        	//
        	Com.hibook.entity.User use=cartser.getUser(email);
        	int id=use.getIdUser(); 
        	//System.out.println(id);
        	model.addAttribute("getIdUseradmin", id);
    	}
   		return "Admin_Transport";
   	}
    @RequestMapping("/admin-typebook")
   	public String pageAdminTypeBook(ModelMap model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(auth.getPrincipal() instanceof User) {
        	User us=(User)(auth.getPrincipal());
        	String email=us.getUsername();     	
        	//Book book=cartser.getBook(idBook);        	
        	//
        	Com.hibook.entity.User use=cartser.getUser(email);
        	int id=use.getIdUser(); 	
        	//System.out.println(id);
        	model.addAttribute("getIdUseradmin", id);
    	}
   		return "Admin_TypeBook";
   	}
    @RequestMapping("/admin-userreview")
   	public String pageAdminUserReview(ModelMap model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(auth.getPrincipal() instanceof User) {
        	User us=(User)(auth.getPrincipal());
        	String email=us.getUsername();     	
        	//Book book=cartser.getBook(idBook);        	
        	//
        	Com.hibook.entity.User use=cartser.getUser(email);
        	int id=use.getIdUser(); 	
        	//System.out.println(id);
        	model.addAttribute("getIdUseradmin", id);
    	}
   		return "Admin_UserReview";
   	}
    @RequestMapping("/admin-book")
   	public String pageAdminBook(ModelMap model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(auth.getPrincipal() instanceof User) {
        	User us=(User)(auth.getPrincipal());
        	String email=us.getUsername();     	
        	//Book book=cartser.getBook(idBook);        	
        	//
        	Com.hibook.entity.User use=cartser.getUser(email);
        	int id=use.getIdUser(); 	
        	//System.out.println(id);
        	model.addAttribute("getIdUseradmin", id);
    	}
   		return "Admin_Book";
   	}
    @RequestMapping({"/add-book","/add-book/{idBook}"})
   	public String pageAddBook(ModelMap model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(auth.getPrincipal() instanceof User) {
        	User us=(User)(auth.getPrincipal());
        	String email=us.getUsername();     	
        	//Book book=cartser.getBook(idBook);        	
        	//
        	Com.hibook.entity.User use=cartser.getUser(email);
        	int id=use.getIdUser(); 	
        	//System.out.println(id);
        	model.addAttribute("getIdUseradmin", id);
    	}
   		return "AddBook";
   	}
    
    @RequestMapping({"/detail-bill","/detail-bill/{idBill}"})
   	public String pageDetailBill(ModelMap model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(auth.getPrincipal() instanceof User) {
        	User us=(User)(auth.getPrincipal());
        	String email=us.getUsername();     	
        	//Book book=cartser.getBook(idBook);        	
        	//
        	Com.hibook.entity.User use=cartser.getUser(email);
        	int id=use.getIdUser(); 	
        	//System.out.println(id);
        	model.addAttribute("getIdUser", id);
    	}
    	
   		return "DetailBill";
   	}

    @RequestMapping("/admin-user")
   	public String pageAdminUser(ModelMap model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(auth.getPrincipal() instanceof User) {
        	User us=(User)(auth.getPrincipal());
        	String email=us.getUsername();     	
        	//Book book=cartser.getBook(idBook);        	
        	//
        	Com.hibook.entity.User use=cartser.getUser(email);
        	int id=use.getIdUser(); 	
        	//System.out.println(id);
        	model.addAttribute("getIdUseradmin", id);
    	}
   		return "Admin_User";
   	}
    
    @RequestMapping({"/add-user","/add-user/{idUser}"})
   	public String pageAddUser(ModelMap model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(auth.getPrincipal() instanceof User) {
        	User us=(User)(auth.getPrincipal());
        	String email=us.getUsername();     	
        	//Book book=cartser.getBook(idBook);        	
        	//
        	Com.hibook.entity.User use=cartser.getUser(email);
        	int id=use.getIdUser(); 	
        	//System.out.println(id);
        	model.addAttribute("getIdUseradmin", id);
    	}
   		return "AddUser";
   	}
    @RequestMapping("/admin-bill")
   	public String pageBill(ModelMap model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(auth.getPrincipal() instanceof User) {
        	User us=(User)(auth.getPrincipal());
        	String email=us.getUsername();     	
        	//Book book=cartser.getBook(idBook);        	
        	//
        	Com.hibook.entity.User use=cartser.getUser(email);
        	int id=use.getIdUser(); 	
        	//System.out.println(id);
        	model.addAttribute("getIdUseradmin", id);
    	}
   		return "Admin_Bill";
   	}
    @RequestMapping({"/search","/booknew","/bookssold"})
   	public String pageSearch(ModelMap model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(auth.getPrincipal() instanceof User) {
        	User us=(User)(auth.getPrincipal());
        	String email=us.getUsername();     	
        	//Book book=cartser.getBook(idBook);        	
        	//
        	Com.hibook.entity.User use=cartser.getUser(email);
        	int id=use.getIdUser(); 	
        	//System.out.println(id);
        	model.addAttribute("getIdUser", id);
    	}
   		return "list_search";
   	}

    @RequestMapping("/loginsuccess")
 	public String loginsuccess() {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	boolean isAdmin=false,isUser=false;
    	if(auth.getPrincipal() instanceof User) {
    	User us=(User)(auth.getPrincipal());
    	isAdmin=us.getAuthorities().stream().anyMatch(new Predicate<GrantedAuthority>() {

			public boolean test(GrantedAuthority role) {
				return role.getAuthority().equalsIgnoreCase("ROLE_ADMIN");
			}
		});
    	isUser=us.getAuthorities().stream().anyMatch(new Predicate<GrantedAuthority>() {

			public boolean test(GrantedAuthority role) {
				return role.getAuthority().equalsIgnoreCase("ROLE_USER");
			}
		});
    	}
    	else {
    		isAdmin=(auth.getPrincipal()).equals("ROLE_ADMIN");
    		isUser=(auth.getPrincipal()).equals("ROLE_USER");
    	}

    	
    	if(isAdmin) {
    		return "redirect:/adminmain";
    	}
    	if(isUser) {
    		
    		return "redirect:/";
    		
    	}
    	return "redirect:/";
    	
    	
 	}
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }
    
}
