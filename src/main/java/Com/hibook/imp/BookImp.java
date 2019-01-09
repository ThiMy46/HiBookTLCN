package Com.hibook.imp;

import java.util.List;

import Com.hibook.DTO.BookHomeDTO;
import Com.hibook.entity.Book;

public interface BookImp {

	Book getDetailBook(int idBook);
	List<Book> loadtrangchu(int batdau);
	List<Book> getAllBook();
	int addBook(Book book);
	boolean updateBook(Book book);
	boolean deleteBook(int idBook);
	List<Book> search(String key, String type);
	List<Book> getNumBooksSold();
}
