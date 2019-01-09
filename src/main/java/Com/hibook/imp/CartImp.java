package Com.hibook.imp;
import java.util.List;

import Com.hibook.entity.Book;
import Com.hibook.entity.Cart;
import Com.hibook.entity.User;
public interface CartImp {
	public int getCart(int idUser);
	public User getUser(String email);
	public int addCart(Cart cart);
	public List<Cart> getquantitynotice(int idUser);
	public boolean updatecartbyid(int idCart);
	public Book getBook(int idBook);
	public boolean deleteBookCart(int idBook);
	public boolean updatequantity(int idCart,int soluong);
	public boolean deleteCart(int idCart);

}
