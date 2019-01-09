package Com.hibook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.hibook.dao.BookDao;

import Com.hibook.entity.Book;
import Com.hibook.imp.BookImp;
@Service
public class BookSer implements BookImp{

	@Autowired
	BookDao bookDao;
	
	public Book getDetailBook(int idBook) {
		return bookDao.getDetailBook(idBook);
	}

	public List<Book> loadtrangchu(int batdau) {
		return bookDao.loadtrangchu(batdau);
	}

	public List<Book> getAllBook() {
		return bookDao.getAllBook();
	}
	
	public int addBook(Book book) {
		return bookDao.addBook(book);
	}

	public boolean deleteBook(int idBook) {
		return bookDao.deleteBook(idBook);
	}

	public boolean updateBook(Book book) {
		return bookDao.updateBook(book);
	}

	public List<Book> search(String key, String type) {
		return bookDao.search(key, type);
	}

	public List<Book> getNumBooksSold() {
		return bookDao.getNumBooksSold();
	}

	

}
