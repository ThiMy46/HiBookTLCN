package Com.hibook.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import Com.hibook.entity.Bill;
import Com.hibook.entity.OrderStatus;
import Com.hibook.entity.Payment;
import Com.hibook.entity.Transport;
import Com.hibook.entity.User;
import Com.hibook.imp.BillImp;
import antlr.collections.impl.LList;
@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class BillDao implements BillImp {
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<Bill> loadlistbill() {	
		Session session=sessionFactory.getCurrentSession();
		List<Bill> billList=new ArrayList<Bill>();
		billList=session.createQuery("from bill").getResultList();
		return billList;
	}
	
	@Transactional
	public Bill getBillbyId(int idBill) {	
		Session session=sessionFactory.getCurrentSession();
		Bill bill=(Bill) session.createQuery("from bill where idBill='"+idBill+"'").getSingleResult();
		return bill;
	}

	@Transactional
	public int addBill(Bill bill) {
		Session session=sessionFactory.getCurrentSession();
		Transport transport=session.get(Transport.class, bill.getTransport().getIdTransport());
		bill.setTransport(transport);
		Payment payment=session.get(Payment.class, bill.getPayment().getIdPayment());
		bill.setPayment(payment);
		OrderStatus orderStatus= session.get(OrderStatus.class, 1);
		bill.setOrderStatus(orderStatus);
		User user= session.get(User.class, bill.getUser().getIdUser());
		bill.setUser(user);
		int idAdd=(Integer) session.save(bill);
		return idAdd;
	}

	@Transactional
	public boolean updateStatusBill(int idBill, int idStatus) {
		Session session=sessionFactory.getCurrentSession();
		Query bill= session.createQuery("update bill set idStatus= :idStatus where idBill = :idBill");
		bill.setParameter("idBill", idBill);
		bill.setParameter("idStatus", idStatus);
		try{
			bill.executeUpdate();
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Transactional
	public boolean updateBill(Bill bill) {
		Session session=sessionFactory.getCurrentSession();
		try{
			session.save(bill);
		}catch (Exception e) {
			return false;
		}
		return true;
	}

	@Transactional
	public boolean deleteBill(int idBill) {
		Session session=sessionFactory.getCurrentSession();
		try{
			session.remove(idBill);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	@Transactional
	public Payment getIdPayment(int idPayment) {
		Session session=sessionFactory.getCurrentSession();
		Payment pay=(Payment) session.createQuery("from payment where idPayment='"+idPayment+"'").getSingleResult();
		return pay;
	}
	@Transactional
	public Transport getIdTranspot(int idTransport) {
		Session session=sessionFactory.getCurrentSession();
		Transport tran=(Transport) session.createQuery("from transport where idTransport='"+idTransport+"'").getSingleResult();
		return tran;
	}
	@Transactional
	public OrderStatus getIdStatus(int idStatus) {
		Session session=sessionFactory.getCurrentSession();
		OrderStatus or=(OrderStatus) session.createQuery("from orderstatus where idStatus='"+idStatus+"'").getSingleResult();
		return or;
	}

	@Transactional
	public List<Bill> getBillbyUser(int idUser) {
		Session session=sessionFactory.getCurrentSession();
		List<Bill> bills= session.createQuery("from bill where idUser='"+idUser+"'").getResultList();
		return bills;
	}
}
