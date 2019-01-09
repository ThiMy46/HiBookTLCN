package Com.hibook.dao;

import javax.swing.text.StyledEditorKit.BoldAction;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import Com.hibook.entity.Bill;
import Com.hibook.entity.Book;
import Com.hibook.entity.DetailBill;
import Com.hibook.imp.DetailbillImp;
@Repository
@org.springframework.context.annotation.Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class DetailBillDao implements DetailbillImp {
	@Autowired
	SessionFactory sessionFactory; 
	@Transactional
	public boolean addDetailbill(DetailBill detail) {
		Session session=sessionFactory.getCurrentSession();
		Book book=session.get(Book.class, detail.getBook().getIdBook());
		Bill bill=session.get(Bill.class, detail.getBill().getIdBill());
		detail.setBill(bill);
		detail.setBook(book);
		try{
			session.save(detail);
			return true;
		}catch(Exception e){
			return false;
		}
		
	}

}
