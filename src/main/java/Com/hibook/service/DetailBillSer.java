package Com.hibook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.hibook.dao.DetailBillDao;
import Com.hibook.entity.DetailBill;
import Com.hibook.imp.DetailbillImp;
@Service
public class DetailBillSer implements DetailbillImp {
@Autowired
DetailBillDao detai;
	public boolean addDetailbill(DetailBill detail) {
		return detai.addDetailbill(detail);
	}

}
