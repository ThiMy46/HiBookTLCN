package Com.hibook.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.function.Predicate;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import Com.hibook.DTO.CartDTO;
import Com.hibook.entity.Book;
import Com.hibook.entity.Cart;
import Com.hibook.entity.DetailBill;
import Com.hibook.entity.Payment;
import Com.hibook.entity.Role;
import Com.hibook.entity.Transport;
import Com.hibook.service.CartSer;
import Com.hibook.service.PaymentSer;
import Com.hibook.service.TransportSer;
import Com.hibook.service.UserSer;
@Controller
public class ADetailController {
	@Autowired
	UserSer userser;
	@Autowired
	TransportSer tran;
	@Autowired
	PaymentSer pay;
	@Autowired
	CartSer cartser;
	@Autowired
	TransportSer transer;
	@Autowired
	PaymentSer payser;
    @RequestMapping({"/detail/{idBook}"})
    public String chitiet(@PathVariable int idBook,ModelMap model,HttpSession http) {
    	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(auth.getPrincipal() instanceof User) {
        	User us=(User)(auth.getPrincipal());
        	String email=us.getUsername();
        	//
        	Com.hibook.entity.User use=cartser.getUser(email);
        	int id=use.getIdUser();
        	
        	List<Cart> getquantity=cartser.getquantitynotice(id);
        	//String email=(String) http.getAttribute("idUser");
        	model.addAttribute("soluong", getquantity.size());
        	
        	//int number=getquantity.size();
        	//System.out.println(number);
        	//http.setAttribute("thongbaogiohang", number);
        	model.addAttribute("getIdUser", id);
        	model.addAttribute("email", email);
  
    	}
        return "detailbook";
    }
    @RequestMapping("/loadcart/{idUser}")
    public String giohang(@PathVariable int idUser,ModelMap model) {
    	int idd1=0;
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(auth.getPrincipal() instanceof User) {
        	User us=(User)(auth.getPrincipal());
        	String email=us.getUsername();
        	Com.hibook.entity.User use=cartser.getUser(email);
        	int id=use.getIdUser();
        	System.out.println(id+"haha");
        	idd1=id;
        	
        	List<Cart> getquantity=cartser.getquantitynotice(id);
        	//List<Book> listbook=new ArrayList<Book>();
        	List<CartDTO> listCartDTO=new ArrayList<CartDTO>();
        	List<Payment> listpay=pay.getAllPayment();
        	List<Transport> listtran=tran.getAllTransport();
        	
        	for(int i=0;i<getquantity.size();i++) {
        		//listCartDTO.get(i).setNameBook(getquantity.get(i).get);
        		CartDTO cartDTO=new CartDTO();
        		Book book=cartser.getBook(getquantity.get(i).getIdBook());
        		
        		cartDTO.setNameBook(book.getNameBook());
        		cartDTO.setImgBook(book.getPicBook());
        		cartDTO.setQuantity(getquantity.get(i).getQuantity());
        		cartDTO.setIdCart(getquantity.get(i).getIdCart());
        		int price=getquantity.get(i).getPrice();
        		int discount=book.getDiscount();
        		float gia=((price*discount)/100);
        		int giachinhthuc=Math.round(gia);
        		cartDTO.setPrice(giachinhthuc);
        		listCartDTO.add(cartDTO);
        	}    	
        	System.out.println(id+"hihihi");
        	model.addAttribute("listtran", listtran);
        	model.addAttribute("listpay", listpay);
        	model.addAttribute("listcart", listCartDTO);
        	model.addAttribute("listquantitycart", getquantity.size());
        	model.addAttribute("getidUser", id);
        	model.addAttribute("email", email);
        	model.addAttribute("getIdUser", idd1);
        	model.addAttribute("use", use);
        	
    	}
        return "cart";
    }
    @RequestMapping(value="/getbill/{idUser}",method=RequestMethod.POST)
    public String getbill(@PathVariable int idUser, @RequestParam(name="tenKhachHang") String tenKhachHang ,
    		@RequestParam(name="soDT") String soDT, @RequestParam(name="noigiaohang") String noigiaohang,  @RequestParam(name="diaChiGiao") String diaChiGiao,
    		@RequestParam(name="vanchuyen") int vanchuyen,ModelMap model)  {
    	
    	//String name=username;
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(auth.getPrincipal() instanceof User) {
        	User us=(User)(auth.getPrincipal());
        	String email=us.getUsername();
        	
        	
        	Transport tran=transer.getTransport(vanchuyen);
        	Payment pay=payser.getIdPay(Integer.parseInt(noigiaohang));
        	
        	 long miliSeconds = System.currentTimeMillis();
             Date date1 = new Date();
             
        	Com.hibook.entity.User use=cartser.getUser(email);
        	int id=use.getIdUser();
        	List<CartDTO> listCartDTO=new ArrayList<CartDTO>();
        	
        	List<Cart> getquantity=cartser.getquantitynotice(id);
        	
        	for(int i=0;i<getquantity.size();i++) {
        		CartDTO cartDTO=new CartDTO();
        		Book book=cartser.getBook(getquantity.get(i).getIdBook());
        		
        		cartDTO.setIdBook(book.getIdBook());
        		cartDTO.setNameBook(book.getNameBook());
        		cartDTO.setImgBook(book.getPicBook());
        		cartDTO.setQuantity(getquantity.get(i).getQuantity());
        		int price=getquantity.get(i).getPrice();
        		int discount=book.getDiscount();
        		System.out.println(price+"ll"+discount);
        		float gia=((price*discount)/100);
        		int giachinhthuc=Math.round(gia);
        		cartDTO.setPrice(giachinhthuc);
        		boolean id1=listCartDTO.add(cartDTO);
        		
        	}    		
        	model.addAttribute("idUser", idUser);  
        	model.addAttribute("listcart", listCartDTO);   
        	model.addAttribute("namereviece", tenKhachHang);
        	model.addAttribute("SDT", soDT);
        	model.addAttribute("diachi", diaChiGiao);
        	model.addAttribute("date", date1);
        	model.addAttribute("vanchuyen", tran);
        	model.addAttribute("thanhtoan", pay);
    	}
        return "Detail_Bill";
    }
  @RequestMapping(value="/register",method=RequestMethod.POST)  
    public String registrations(@RequestParam(name="uname") String uname ,
    		@RequestParam(name="psw") String psw, @RequestParam(name="rpsw") String rpsw,  @RequestParam(name="email") String email,ModelMap model)  {
    	Role role=new Role();
    	role.setIdRole(1);
    	String hash=BCrypt.hashpw(psw, BCrypt.gensalt(12));
    	
    	if(psw.equals(rpsw)) {
    		Com.hibook.entity.User user=new Com.hibook.entity.User();
        	user.setEmail(email);
        	user.setPassword(hash);
        	user.setRole(role);
        	user.setNameUser(uname);
        	userser.addUser(user);
        	return "redirect:/";
        	
    		
    	}
    	else {
    		
    		model.addAttribute("erro", "Xin nhập lại đúng password");
    		
    	}
    	return "redirect:/register";
    	}
    }
