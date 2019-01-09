package Com.hibook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Com.hibook.entity.Cart;
import Com.hibook.entity.User;
import Com.hibook.service.CartSer;

@Controller
@RequestMapping(value = "/api")
public class CartController {
	@Autowired
	CartSer cartser;
	
	@GetMapping(value = "/cart/{idBook}")
	@ResponseBody
	public int addCart(@PathVariable int idBook,@RequestParam String email,@RequestParam int quantity,@RequestParam int price ){
		Cart cart=new Cart();
		cart.setIdBook(idBook);
		User user=cartser.getUser(email);
		cart.setIdUser(user.getIdUser());
		cart.setPrice(price);
		cart.setQuantity(quantity);
		int add=cartser.addCart(cart);	
		//System.out.println(add);
		return add;
	}
	@GetMapping("/capnhatsoluong/{idBook}")
	@ResponseBody
	public void capnhapsoluong(@PathVariable int idBook,@RequestParam int soluong,@RequestParam int idCart) {			
				cartser.updatequantity(idCart, soluong);
	
	}
	@GetMapping("/xoagiohang/")
	@ResponseBody
	public void xoagiohang(@RequestParam int idCart) {
			//System.out.println(idBook);
				cartser.deleteCart(idCart);
				System.out.println("xóa thành công rồi!"+idCart);
	
	}
	@GetMapping(value = "/getnotice/{idBook}")
	@ResponseBody
	public int getquantitynotice(@PathVariable int idBook,@RequestParam String email,@RequestParam int price) {
		
		User user=cartser.getUser(email);
		int id=user.getIdUser();
		List<Cart> getnotice=cartser.getquantitynotice(id);	
		if(getnotice.size()==0) {
			Cart cart=new Cart();
			cart.setIdUser(id);
			cart.setPrice(price);
			cart.setQuantity(1);
			cart.setIdBook(idBook);
			int add=cartser.addCart(cart);
		
			return 0;
			
		}
		else {
			List<Cart> listcart2=cartser.getquantitynotice(id);
			int vitri=kiemtratrung(listcart2, idBook, id);
			if(vitri==-1) {
				Cart cart=new Cart();
				cart.setIdUser(id);
				cart.setPrice(price);
				cart.setQuantity(1);
				cart.setIdBook(idBook);
				int add=cartser.addCart(cart);	
				return 0;
			}
			else {
				boolean update=cartser.updatecartbyid(vitri);
				return -1;
			}
		}				
	}
	public int kiemtratrung(List<Cart> listcart,int idBook,int idUser) {
		for(int i=0;i<listcart.size();i++) {
			if(listcart.get(i).getIdBook()==idBook&&listcart.get(i).getIdUser()==idUser) {
				return listcart.get(i).getIdCart();
			}
		}
		return -1;
	}

}
