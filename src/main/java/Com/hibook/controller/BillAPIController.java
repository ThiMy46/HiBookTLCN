package Com.hibook.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Com.hibook.DTO.BillDTO;
import Com.hibook.DTO.DetailBillDTO;
import Com.hibook.entity.Bill;
import Com.hibook.entity.Book;
import Com.hibook.entity.Cart;
import Com.hibook.entity.DetailBill;
import Com.hibook.entity.OrderStatus;
import Com.hibook.entity.Payment;
import Com.hibook.entity.Transport;
import Com.hibook.entity.User;
import Com.hibook.service.BillSer;
import Com.hibook.service.BookSer;
import Com.hibook.service.CartSer;
import Com.hibook.service.DetailBillSer;

@RestController
@RequestMapping(value = "/api")
public class BillAPIController {
	@Autowired
	DetailBillSer detailser;
	@Autowired
	BookSer book;
	@Autowired
	BillSer billser;
	@Autowired
	CartSer cartser;
	@Autowired
	DetailBillSer detailbillSer;
	@GetMapping(value = "/bill")
	public ResponseEntity<List<Bill>> loadBill(){
		List<Bill> listbill=billser.loadlistbill();
		List<Bill> loadlist=new ArrayList<Bill>();
		for (Bill bill : listbill) {
			Bill billnew=new Bill();
			User user=new User();
			Payment pay=new Payment();
			OrderStatus oder=new OrderStatus();
			Transport trans=new Transport();
			
			pay.setIdPayment(bill.getPayment().getIdPayment());	
			pay.setNamePayment(bill.getPayment().getNamePayment());
			user.setIdUser(bill.getUser().getIdUser());
			user.setNameUser(bill.getUser().getNameUser());
			oder.setIdStatus(bill.getOrderStatus().getIdStatus());
			oder.setNameStatus(bill.getOrderStatus().getNameStatus());
			trans.setIdTransport(bill.getTransport().getIdTransport());
			trans.setNameTransport(bill.getTransport().getNameTransport());
					
			billnew.setIdBill(bill.getIdBill());
			billnew.setNameReceiver(bill.getNameReceiver());
			billnew.setNumberphone(bill.getNumberphone());
			billnew.setDeliveryAdress(bill.getDeliveryAdress());
			billnew.setDateCreate(bill.getDateCreate());
			billnew.setTotal(bill.getTotal());
			billnew.setUser(user);
			billnew.setPayment(pay);
			billnew.setOrderStatus(oder);
			billnew.setTransport(trans);
			
			loadlist.add(billnew);
			
		}
		if(loadlist.isEmpty()) {
			return new ResponseEntity<List<Bill>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<Bill>>(loadlist,HttpStatus.OK);
		
	}
	@GetMapping(value = "/bill/{idBill}")
	public ResponseEntity<?> getBillbyID(@PathVariable int idBill){
		Bill bill=billser.getBillbyId(idBill);
		BillDTO billnew=new BillDTO();
		billnew.setIdBill(bill.getIdBill());
		billnew.setNameReceiver(bill.getNameReceiver());
		billnew.setNumberphone(bill.getNumberphone());
		billnew.setDeliveryAdress(bill.getDeliveryAdress());
		billnew.setDateCreate(bill.getDateCreate());
		billnew.setTotal(bill.getTotal());
		billnew.setNameUser(bill.getUser().getNameUser());
		billnew.setNamePayment(bill.getPayment().getNamePayment());
		billnew.setIdStatus(bill.getOrderStatus().getIdStatus());
		billnew.setNameTransport(bill.getTransport().getNameTransport());
		billnew.setFeeTransport(bill.getTransport().getFee());
		billnew.setNameStatus(bill.getOrderStatus().getNameStatus());
		List<DetailBillDTO> detailBillDTOs=new ArrayList<DetailBillDTO>();
		for (int i = 0; i < bill.getDetailBills().size(); i++) {
			DetailBillDTO detailBillDTO=new DetailBillDTO();
			detailBillDTO.setPrice(bill.getDetailBills().get(i).getPrice());
			detailBillDTO.setQuantityBuy(bill.getDetailBills().get(i).getQuantityBuy());
			Book book=new Book();
			book.setNameBook(bill.getDetailBills().get(i).getBook().getNameBook());
			book.setPicBook(bill.getDetailBills().get(i).getBook().getPicBook());
			book.setPrice(bill.getDetailBills().get(i).getBook().getPrice());
			detailBillDTO.setBook(book);
			
			detailBillDTOs.add(detailBillDTO);
		}
		billnew.setDetailBillDTOs(detailBillDTOs);
		
		return new ResponseEntity<BillDTO>(billnew,HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/bill/user/{idUser}")
	public ResponseEntity<?> getBillbyUser(@PathVariable int idUser){
		List<Bill> bills=billser.getBillbyUser(idUser);
		List<BillDTO> listDTO=new ArrayList<BillDTO>();
		for (Bill bill : bills) {
			BillDTO billnew=new BillDTO();
			billnew.setIdBill(bill.getIdBill());
			billnew.setNameReceiver(bill.getNameReceiver());
			billnew.setNumberphone(bill.getNumberphone());
			billnew.setDeliveryAdress(bill.getDeliveryAdress());
			billnew.setDateCreate(bill.getDateCreate());
			billnew.setTotal(bill.getTotal());
			billnew.setNameUser(bill.getUser().getNameUser());
			billnew.setNamePayment(bill.getPayment().getNamePayment());
			billnew.setIdStatus(bill.getOrderStatus().getIdStatus());
			billnew.setNameStatus(bill.getOrderStatus().getNameStatus());
			billnew.setNameTransport(bill.getTransport().getNameTransport());
			billnew.setFeeTransport(bill.getTransport().getFee());
			billnew.setDetailBillDTOs(null);
			listDTO.add(billnew);
		}
		return new ResponseEntity<List<BillDTO>>(listDTO,HttpStatus.OK);
		
	}


	@PostMapping(value = "/bill")
	public ResponseEntity<?> addBill(@RequestParam String nameReceiver, @RequestParam String numberphone,
			 @RequestParam String deliveryAdress, @RequestParam String dateCreate,
			 @RequestParam int total, @RequestParam int idUser,
			 @RequestParam int idPayment, @RequestParam int idTransport){
		
		Bill bill=new Bill();
		bill.setNameReceiver(nameReceiver);
		bill.setNumberphone(numberphone);
		bill.setDeliveryAdress(deliveryAdress);
		bill.setDateCreate(dateCreate);
		bill.setTotal(total);
		User user=new User();
		user.setIdUser(idUser);
		bill.setUser(user);
		Payment payment=new Payment();
		payment.setIdPayment(idPayment);
		bill.setPayment(payment);
		Transport transport=new Transport();
		transport.setIdTransport(idTransport);
		bill.setTransport(transport);
		
		int idAdd=billser.addBill(bill);
		bill.setIdBill(idAdd);
		//đổ dữ liệu cart sang detailBill
		List<Cart> lstCartbyidUser=cartser.getquantitynotice(idUser);
		for (Cart cart : lstCartbyidUser) {
			DetailBill detailBill=new DetailBill();
			
			Book book =new Book();
			book.setIdBook(cart.getIdBook());
			detailBill.setBook(book);
			detailBill.setBill(bill);
			detailBill.setPrice(cart.getPrice());
			detailBill.setQuantityBuy(cart.getQuantity());
			detailbillSer.addDetailbill(detailBill);
			cartser.deleteBookCart(cart.getIdBook());
		}
		return new ResponseEntity<Integer>(idAdd,HttpStatus.OK);
		
	}
	
	/*======================Update Status Bill ================= */
	@PutMapping(value="/bill/{idBill}/status/{idStatus}")
	public ResponseEntity<?> updateRoleUser(@PathVariable int idBill, @PathVariable int idStatus){
		boolean update=billser.updateStatusBill(idBill, idStatus);
		if(!update){
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	}
