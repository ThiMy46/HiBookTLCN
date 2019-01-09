package Com.hibook.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import Com.hibook.entity.Payment;
import Com.hibook.entity.Transport;
import Com.hibook.imp.PaymentImp;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class PaymentDAO implements PaymentImp{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<Payment> getAllPayment() {
		Session session=sessionFactory.getCurrentSession();
		List<Payment> payments= session.createQuery("from payment").getResultList();
		return payments;
	}

	@Transactional
	public int addPayment(Payment payment) {
		Session session=sessionFactory.getCurrentSession();
		int kt=(Integer) session.save(payment);
		return kt;
	}

	@Transactional
	public boolean updatePayment(Payment payment) {
		Session session=sessionFactory.getCurrentSession();
		Payment pay=session.get(Payment.class, payment.getIdPayment());
		pay.setNamePayment(payment.getNamePayment());
		try{
			session.update(pay);
		}catch (Exception e) {
			return false;
		}
		return true;
	}

	@Transactional
	public boolean deletePayment(int idPayment) {
		Session session=sessionFactory.getCurrentSession();
		Payment pay= session.get(Payment.class, idPayment);
		try{
			session.remove(pay);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
@Transactional
	public Payment getIdPay(int idPayment) {
		Session session=sessionFactory.getCurrentSession();
		Payment pay=(Payment) session.createQuery("from payment where idPayment ='"+idPayment +"'").getSingleResult();
		
		return pay;
	}

}
