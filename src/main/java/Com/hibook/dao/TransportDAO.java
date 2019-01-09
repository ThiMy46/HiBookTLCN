package Com.hibook.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import Com.hibook.entity.Book;
import Com.hibook.entity.Transport;
import Com.hibook.imp.TransportImp;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class TransportDAO implements TransportImp{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<Transport> getAllTransport() {
		Session session=sessionFactory.getCurrentSession();
		List<Transport> transports= session.createQuery("from transport").getResultList();
		return transports;
	}

	@Transactional
	public int addTransport(Transport transport) {
		Session session=sessionFactory.getCurrentSession();
		int kt=(Integer) session.save(transport);
		return kt;
	}

	@Transactional
	public boolean updateTransport(Transport transport) {
		Session session=sessionFactory.getCurrentSession();
		Transport trans=session.get(Transport.class, transport.getIdTransport());
		trans.setNameTransport(transport.getNameTransport());
		trans.setDescribes(transport.getDescribes());
		trans.setFee(transport.getFee());
		try{
			session.update(trans);
		}catch (Exception e) {
			return false;
		}
		return true;
	}

	@Transactional
	public boolean deleteTransport(int idTransport) {
		Session session=sessionFactory.getCurrentSession();
		Transport trans= session.get(Transport.class, idTransport);
		try{
			session.remove(trans);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
@Transactional
	public Transport getTransport(int idTransport) {
		Session session=sessionFactory.getCurrentSession();
		Transport tran=(Transport) session.createQuery("from transport where idTransport ='"+idTransport +"'").getSingleResult();
		
		return tran;
	}

}
