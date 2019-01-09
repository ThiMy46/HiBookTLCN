package Com.hibook.imp;

import java.util.List;

import Com.hibook.entity.OrderStatus;

public interface OrderstatusImp {

	List<OrderStatus> getAllOrderStatus();
	int addOrderStatus(OrderStatus orderStatus);
	boolean updateOrderStatus(OrderStatus orderStatus);
	boolean deleteOrderStatus(int idOrderStatus);
}
