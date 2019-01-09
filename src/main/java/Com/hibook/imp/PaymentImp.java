package Com.hibook.imp;

import java.util.List;

import Com.hibook.entity.Payment;

public interface PaymentImp {

	List<Payment> getAllPayment();
	int addPayment(Payment payment);
	boolean updatePayment(Payment payment);
	boolean deletePayment(int idPayment);
	Payment getIdPay(int idPayment );
}
