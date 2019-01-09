package Com.hibook.dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.result.ResultSetOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Repository;

import Com.hibook.entity.Author;
import Com.hibook.entity.Book;
import Com.hibook.entity.Supplier;
import Com.hibook.entity.TypeBook;
import Com.hibook.imp.BookImp;
@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class BookDao implements BookImp{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public Book getDetailBook(int idBook) {
		Session session=sessionFactory.getCurrentSession();
		Book book= session.get(Book.class, idBook);
		Hibernate.initialize(book.getAuthors());
		return book;
	}
	/*================NOTE=================== */
	@Transactional
	public List<Book> loadtrangchu(int batdau) {
			Session session=sessionFactory.getCurrentSession();
			List<Book> sanphamList=new ArrayList<Book>();
			if(batdau>0) {
				sanphamList=session.createQuery("from book").setFirstResult(batdau).setMaxResults(8).getResultList();
			}
			else {
				sanphamList=session.createQuery("from book").getResultList();
			}
			return sanphamList;
	}
	@Transactional
	public List<Book> getAllBook() {
			Session session=sessionFactory.getCurrentSession();
			List<Book> bookList=session.createQuery("from book").getResultList();
			return bookList;
	}
	
	@Transactional
	public List<Book> getNumBooksSold() {
			Session session=sessionFactory.getCurrentSession();
			ProcedureCall query= session.createStoredProcedureCall("getNumBooksSold",Book.class);
			ResultSetOutput resultSetOutput = (ResultSetOutput) query.getOutputs().getCurrent();
			List<Book> bookList=resultSetOutput.getResultList();
			return bookList;
	}
	
	@Transactional
	public int addBook(Book book) {
		Session session=sessionFactory.getCurrentSession();
		List<Author> authors=new ArrayList<Author>();
		for (Author author : book.getAuthors()) {
			Author author2=session.get(Author.class, author.getIdAuthor());
			authors.add(author2);
		}
		book.setAuthors(authors);
		Supplier supplier=session.get(Supplier.class,book.getSupplier().getIdSupplier());
		book.setSupplier(supplier);
		TypeBook typeBook=session.get(TypeBook.class, book.getTypeBook().getIdType());
		book.setTypeBook(typeBook);
		
		int kt=(Integer) session.save(book);
		return kt;
	}
	
	@Transactional
	public boolean updateBook(Book book) {
		Session session=sessionFactory.getCurrentSession();
		
		TypeBook typeBook=session.get(TypeBook.class, book.getTypeBook().getIdType());
		book.setTypeBook(typeBook);
		Supplier supplier=session.get(Supplier.class,book.getSupplier().getIdSupplier());
		book.setSupplier(supplier);
		
		/*List<Author> authors=new ArrayList<Author>();
		for (Author author : book.getAuthors()) {
			Author author2=session.get(Author.class, author.getIdAuthor());
			authors.add(author2);
		}
		book.setAuthors(authors);*/
		session.update(book);
		return true;
	}
	
	@Transactional
	public boolean deleteBook(int idBook) {
		Session session=sessionFactory.getCurrentSession();
		Query de= session.createQuery("delete book where idBook = :idBook");
		de.setParameter("idBook", idBook);
		
		try{
			de.executeUpdate();
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Transactional
	public List<Book> search(String key, String type) {
		Session session=sessionFactory.getCurrentSession();
		Query de;
		if(type.equals("")){
			de= session.createQuery("from book where nameBook like :nameBook");
			de.setParameter("nameBook", "%"+key+"%");
		}else {
			de= session.createQuery("from book where nameBook like :nameBook and idType = :idType");
			de.setParameter("idType", type);
			de.setParameter("nameBook", "%"+key+"%");
		}
		try{
			List<Book> books=de.getResultList();
			return books;
		}catch (Exception e) {
			return null;
		}
	}

}
