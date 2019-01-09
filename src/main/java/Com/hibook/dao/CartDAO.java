package Com.hibook.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import Com.hibook.entity.Book;
import Com.hibook.entity.Cart;
import Com.hibook.entity.User;
import Com.hibook.imp.CartImp;
@Repository
@org.springframework.context.annotation.Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class CartDAO implements CartImp {
	@Autowired
	SessionFactory sessionFactory; 
	@Transactional
	public int getCart(int idUser ) {
				Session session=sessionFactory.getCurrentSession();
				int cartList=(Integer) session.createQuery("from cart where idUser ='"+idUser +"'").getSingleResult();
				return cartList;
		
	}
	@Transactional
	public User getUser(String email) {
		Session session=sessionFactory.getCurrentSession();
		User user=(User) session.createQuery("from user where email ='"+email +"'").getSingleResult();
		
		return user;
	}
	@Transactional
	public int addCart(Cart cart) {
		Session session=sessionFactory.getCurrentSession();
		int kt=(Integer)session.save(cart);
		
		return kt;
	}
	@Transactional
	public List<Cart> getquantitynotice(int idUser) {
		Session session=sessionFactory.getCurrentSession();
		List<Cart> cartListnotice= session.createQuery("from cart where idUser ='"+idUser +"'").getResultList();
		return cartListnotice;
	}
	@Transactional
	public boolean updatecartbyid(int idCart) {
		Session session=sessionFactory.getCurrentSession();
		Query de= session.createQuery("update cart set quantity=(quantity+1) where idCart = :idCart");
		de.setParameter("idCart", idCart);
		
		try{
			de.executeUpdate();
		}catch (Exception e) {
			return false;
		}
		return true;
	
	}
	@Transactional
	public Book getBook(int idBook) {
		Session session=sessionFactory.getCurrentSession();
		Book book=(Book) session.createQuery("from book where idBook ='"+idBook +"'").getSingleResult();
		
		return book;
	}
	@Transactional
	public boolean deleteBookCart(int idBook) {
		Session session=sessionFactory.getCurrentSession();
		Query decart= session.createQuery("delete cart where idBook = :idBook");
		decart.setParameter("idBook", idBook);
		
		try{
			decart.executeUpdate();
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	@Transactional
	public boolean updatequantity(int idCart,int soluong) {
		Session session=sessionFactory.getCurrentSession();
		Query de= session.createQuery("update cart set quantity=:quantity where idCart = :idCart");
		de.setParameter("idCart", idCart);
		de.setParameter("quantity", soluong);
		
		try{
			de.executeUpdate();
		}catch (Exception e) {
			return false;
		}
		return true;
	
	}
	@Transactional
	public boolean deleteCart(int idCart) {
		Session session=sessionFactory.getCurrentSession();
		Query decart= session.createQuery("delete cart where idCart = :idCart");
		decart.setParameter("idCart", idCart);
		
		try{
			decart.executeUpdate();
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	
	

}
