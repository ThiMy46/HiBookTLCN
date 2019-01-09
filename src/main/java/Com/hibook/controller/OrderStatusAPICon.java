package Com.hibook.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Com.hibook.entity.OrderStatus;
import Com.hibook.service.OrderStatusSer;

/*===================DETAIL OrderStatus================ */
@RestController
@RequestMapping(value = "/api")
public class OrderStatusAPICon {

	@Autowired
	OrderStatusSer orderStatusSer;
	
	/*======================GET all OrderStatus================= */
	@GetMapping(value = "/status")
	public ResponseEntity<?> loadOrderStatus(){
		List<OrderStatus> listOrderStatus=orderStatusSer.getAllOrderStatus();
		List<OrderStatus> loadlist=new ArrayList<OrderStatus>();
		for (OrderStatus oStatus : listOrderStatus) {
			OrderStatus orderStatus  =new OrderStatus();
			orderStatus.setIdStatus(oStatus.getIdStatus());
			orderStatus.setNameStatus(oStatus.getNameStatus().toString());
			
			loadlist.add(orderStatus);
		}
		if(loadlist.isEmpty()) {
			return new ResponseEntity<List<OrderStatus>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<OrderStatus>>(loadlist,HttpStatus.OK);
	}
	/*======================ADD OrderStatus================= */
	@PostMapping(value="/status")
	public ResponseEntity<?> addOrderStatus(@RequestParam String nameStatus){
		OrderStatus orderStatus=new OrderStatus(nameStatus);
		int idAdd=orderStatusSer.addOrderStatus(orderStatus);
		if(idAdd==0){
			return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Integer>(1, HttpStatus.OK);
	}
	/*======================UPDATE OrderStatus================= */
	@PutMapping(value="/status/{idStatus}")
	public ResponseEntity<?> updateOrderStatus(@PathVariable int idStatus, @RequestBody OrderStatus orderStatus){
		orderStatus.setIdStatus(idStatus);
		boolean update=orderStatusSer.updateOrderStatus(orderStatus);
		if(!update){
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	/*======================DELETE OrderStatus by ID================= */
	@DeleteMapping(value="status/{idStatus}")
	public ResponseEntity<?> deleteOrderStatus(@PathVariable int idStatus){
		boolean delete=orderStatusSer.deleteOrderStatus(idStatus);
		if(!delete){
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
