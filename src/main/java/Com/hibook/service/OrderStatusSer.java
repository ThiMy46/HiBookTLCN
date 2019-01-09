package Com.hibook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.hibook.dao.OrderStatusDAO;
import Com.hibook.entity.OrderStatus;
import Com.hibook.imp.OrderstatusImp;

@Service
public class OrderStatusSer implements OrderstatusImp{

	@Autowired
	OrderStatusDAO orderStatusDAO;
	
	public List<OrderStatus> getAllOrderStatus() {
		return orderStatusDAO.getAllOrderStatus();
	}

	public int addOrderStatus(OrderStatus orderStatus) {
		return orderStatusDAO.addOrderStatus(orderStatus);
	}

	public boolean updateOrderStatus(OrderStatus orderStatus) {
		return orderStatusDAO.updateOrderStatus(orderStatus);
	}

	public boolean deleteOrderStatus(int idOrderStatus) {
		return orderStatusDAO.deleteOrderStatus(idOrderStatus);
	}

}
