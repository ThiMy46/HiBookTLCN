package Com.hibook.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import Com.hibook.entity.OrderStatus;
import Com.hibook.imp.OrderstatusImp;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class OrderStatusDAO implements OrderstatusImp{

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public List<OrderStatus> getAllOrderStatus() {
		Session session=sessionFactory.getCurrentSession();
		List<OrderStatus> authors= session.createQuery("from orderstatus").getResultList();
		return authors;
	}

	@Transactional
	public int addOrderStatus(OrderStatus orderStatus) {
		Session session=sessionFactory.getCurrentSession();
		int kt=(Integer) session.save(orderStatus);
		return kt;
	}

	@Transactional
	public boolean updateOrderStatus(OrderStatus orderStatus) {
		Session session=sessionFactory.getCurrentSession();
		OrderStatus status=session.get(OrderStatus.class, orderStatus.getIdStatus());
		status.setNameStatus(orderStatus.getNameStatus());
		try{
			session.update(status);
		}catch (Exception e) {
			return false;
		}
		return true;
	}

	@Transactional
	public boolean deleteOrderStatus(int idOrderStatus) {
		Session session=sessionFactory.getCurrentSession();
		OrderStatus status= session.get(OrderStatus.class, idOrderStatus);
		try{
			session.remove(status);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
}
