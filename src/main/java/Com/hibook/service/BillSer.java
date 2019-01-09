package Com.hibook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.hibook.dao.BillDao;
import Com.hibook.entity.Bill;
import Com.hibook.entity.OrderStatus;
import Com.hibook.entity.Payment;
import Com.hibook.entity.Transport;
import Com.hibook.imp.BillImp;
@Service
public class BillSer implements BillImp{
 
	@Autowired
	BillDao billDao;
	public List<Bill> loadlistbill() {
		// TODO Auto-generated method stub
		return billDao.loadlistbill();
	}
	public int addBill(Bill bill) {
		return billDao.addBill(bill);
	}
	public boolean updateStatusBill(int idBill, int idStatus) {
		return billDao.updateStatusBill(idBill, idStatus);
	}
	public Bill getBillbyId(int idBill) {
		return billDao.getBillbyId(idBill);
	}
	public boolean updateBill(Bill bill) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean deleteBill(int idBill) {
		// TODO Auto-generated method stub
		return false;
	}
	public Payment getIdPayment(int idPayment) {
		// TODO Auto-generated method stub
		return billDao.getIdPayment(idPayment);
	}
	public Transport getIdTranspot(int idTransport) {
		// TODO Auto-generated method stub
		return billDao.getIdTranspot(idTransport);
	}
	public OrderStatus getIdStatus(int idStatus) {
		// TODO Auto-generated method stub
		return billDao.getIdStatus(idStatus);
	}
	public List<Bill> getBillbyUser(int idUser) {
		return billDao.getBillbyUser(idUser);
	}
	
	

}
