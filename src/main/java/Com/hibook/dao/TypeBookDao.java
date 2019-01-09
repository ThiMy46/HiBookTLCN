package Com.hibook.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import Com.hibook.entity.TypeBook;
import Com.hibook.imp.TypeBookImp;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class TypeBookDao implements TypeBookImp{
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public List<TypeBook> getAllTypeBook() {
		Session session=sessionFactory.getCurrentSession();
		List<TypeBook> typeBooks= session.createQuery("from typebook").getResultList();
		return typeBooks;
	}

	@Transactional
	public int addTypeBook(TypeBook typeBook) {
		Session session=sessionFactory.getCurrentSession();
		int kt=(Integer) session.save(typeBook);
		return kt;
	}

	@Transactional
	public boolean updateTypeBook(TypeBook typeBook) {
		Session session=sessionFactory.getCurrentSession();
		TypeBook type=session.get(TypeBook.class, typeBook.getIdType());
		type.setNameType(typeBook.getNameType());
		try{
			session.update(type);
		}catch (Exception e) {
			return false;
		}
		return true;
	}

	@Transactional
	public boolean deleteTypeBook(int idTypeBook) {
		Session session=sessionFactory.getCurrentSession();
		TypeBook type= session.get(TypeBook.class, idTypeBook);
		try{
			session.remove(type);
		}catch (Exception e) {
			return false;
		}
		return true;
	}

}
