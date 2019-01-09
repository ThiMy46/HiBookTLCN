package Com.hibook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.hibook.dao.PaymentDAO;
import Com.hibook.entity.Payment;
import Com.hibook.imp.PaymentImp;

@Service
public class PaymentSer implements PaymentImp{

	@Autowired
	PaymentDAO paymentDAO;
	
	public List<Payment> getAllPayment() {
		return paymentDAO.getAllPayment();
	}

	public int addPayment(Payment payment) {
		return paymentDAO.addPayment(payment);
	}

	public boolean updatePayment(Payment payment) {
		return paymentDAO.updatePayment(payment);
	}

	public boolean deletePayment(int idPayment) {
		return paymentDAO.deletePayment(idPayment);
	}

	public Payment getIdPay(int idPayment) {
		// TODO Auto-generated method stub
		return paymentDAO.getIdPay(idPayment);
	}

}
