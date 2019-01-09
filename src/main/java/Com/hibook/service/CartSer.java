package Com.hibook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import Com.hibook.dao.CartDAO;
import Com.hibook.entity.Book;
import Com.hibook.entity.Cart;
import Com.hibook.entity.User;
import Com.hibook.imp.CartImp;

@Service
public class CartSer implements CartImp {
	@Autowired
	CartDAO cartDao;
	
	
	public int getCart(int idUser) {
		// TODO Auto-generated method stub
		return cartDao.getCart(idUser);
	}


	public User getUser(String email) {
		// TODO Auto-generated method stub
		return cartDao.getUser(email);
	}


	public int addCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartDao.addCart(cart);
	}


	public List<Cart> getquantitynotice(int idUser) {
		// TODO Auto-generated method stub
		return cartDao.getquantitynotice(idUser);
	}


	public boolean updatecartbyid(int idCart) {
		return cartDao.updatecartbyid(idCart);
	}


	public Book getBook(int idBook) {
		// TODO Auto-generated method stub
		return cartDao.getBook(idBook);
	}


	public boolean deleteBookCart(int idBook) {
		// TODO Auto-generated method stub
		return cartDao.deleteBookCart(idBook);
	}
	public boolean updatequantity(int idCart, int soluong) {
		// TODO Auto-generated method stub
		return cartDao.updatequantity(idCart, soluong);
	}


	public boolean deleteCart(int idCart) {
		// TODO Auto-generated method stub
		return cartDao.deleteCart(idCart);
	}
	

}
