package Com.hibook.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import Com.hibook.entity.Author;
import Com.hibook.imp.AuthorImp;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class AuthorDAO implements AuthorImp{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<Author> getAllAuthor() {
		Session session=sessionFactory.getCurrentSession();
		List<Author> authors= session.createQuery("from author").getResultList();
		return authors;
	}

	@Transactional
	public int addAuthor(Author author) {
		Session session=sessionFactory.getCurrentSession();
		int kt=(Integer) session.save(author);
		return kt;
	}

	@Transactional
	public boolean updateAuthor(Author author) {
		Session session=sessionFactory.getCurrentSession();
		Author author2=session.get(Author.class, author.getIdAuthor());
		author2.setNameAuthor(author.getNameAuthor());
		try{
			session.update(author2);
		}catch (Exception e) {
			return false;
		}
		return true;
	}

	@Transactional
	public boolean deleteAuthor(int idAuthor) {
		Session session=sessionFactory.getCurrentSession();
		Author author= session.get(Author.class, idAuthor);
		try{
			session.remove(author);
		}catch (Exception e) {
			return false;
		}
		return true;
	}

}
