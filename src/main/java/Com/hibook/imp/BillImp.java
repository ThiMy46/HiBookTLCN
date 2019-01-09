package Com.hibook.imp;

import java.util.List;

import Com.hibook.entity.Bill;
import Com.hibook.entity.OrderStatus;
import Com.hibook.entity.Payment;
import Com.hibook.entity.Transport;

public interface BillImp {
	List<Bill> loadlistbill();
	List<Bill> getBillbyUser(int idUser);
	Bill getBillbyId(int idBill);
	int addBill(Bill bill);
	boolean updateStatusBill(int idBill, int idStatus);
	boolean updateBill(Bill bill);
	boolean deleteBill(int idBill);
	Payment getIdPayment(int idPayment);
	Transport getIdTranspot(int idTransport);
	OrderStatus getIdStatus(int idStatus);
}
