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

import Com.hibook.entity.Payment;
import Com.hibook.service.PaymentSer;


/*===================DETAIL Payment================ */
@RestController
@RequestMapping(value = "/api")
public class PaymentAPICon {

	@Autowired
	PaymentSer paymentSer;
	
	/*======================GET all Payment================= */
	@GetMapping(value = "/payment")
	public ResponseEntity<?> loadPayment(){
		List<Payment> listPayment=paymentSer.getAllPayment();
		List<Payment> loadlist=new ArrayList<Payment>();
		for (Payment payment : listPayment) {
			Payment pay  =new Payment();
			pay.setIdPayment(payment.getIdPayment());
			pay.setNamePayment(payment.getNamePayment().toString());
			
			loadlist.add(pay);
		}
		if(loadlist.isEmpty()) {
			return new ResponseEntity<List<Payment>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<Payment>>(loadlist,HttpStatus.OK);
	}
	/*======================ADD Payment================= */
	@PostMapping(value="/payment")
	public ResponseEntity<?> addPayment(@RequestParam String namePayment){
		Payment Payment=new Payment();
		Payment.setNamePayment(namePayment);
		int idAdd=paymentSer.addPayment(Payment);
		if(idAdd==0){
			return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Integer>(1, HttpStatus.OK);
	}
	/*======================UPDATE Payment================= */
	@PutMapping(value="/payment/{idPayment}")
	public ResponseEntity<?> updatePayment(@PathVariable int idPayment, @RequestBody Payment payment){
		payment.setIdPayment(idPayment);
		boolean update=paymentSer.updatePayment(payment);
		if(!update){
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	/*======================DELETE Payment by ID================= */
	@DeleteMapping(value="payment/{idPayment}")
	public ResponseEntity<?> deletePayment(@PathVariable int idPayment){
		boolean delete=paymentSer.deletePayment(idPayment);
		if(!delete){
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
