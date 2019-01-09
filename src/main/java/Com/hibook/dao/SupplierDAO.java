package Com.hibook.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import Com.hibook.entity.Supplier;
import Com.hibook.imp.SupplierImp;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class SupplierDAO implements SupplierImp{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<Supplier> getAllSupplier() {
		Session session=sessionFactory.getCurrentSession();
		List<Supplier> suppliers= session.createQuery("from supplier").getResultList();
		return suppliers;
	}

	@Transactional
	public int addSupplier(Supplier supplier) {
		Session session=sessionFactory.getCurrentSession();
		int kt=(Integer) session.save(supplier);
		return kt;
	}

	@Transactional
	public boolean updateSupplier(Supplier supplier) {
		Session session=sessionFactory.getCurrentSession();
		Supplier supp=session.get(Supplier.class, supplier.getIdSupplier());
		supp.setNameSupplier(supplier.getNameSupplier());
		try{
			session.update(supp);
		}catch (Exception e) {
			return false;
		}
		return true;
	}

	@Transactional
	public boolean deleteSupplier(int idSupplier) {
		Session session=sessionFactory.getCurrentSession();
		Supplier sub= session.get(Supplier.class, idSupplier);
		try{
			session.remove(sub);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
}
