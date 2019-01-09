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

import Com.hibook.entity.Book;
import Com.hibook.entity.Supplier;
import Com.hibook.service.SupplierSer;

/*===================DETAIL Supplier================ */
@RestController
@RequestMapping(value = "/api")
public class SupplierAPIController {
	
	@Autowired
	SupplierSer supplierSer;

	@GetMapping(value = "/supplier")
	public ResponseEntity<?> loadSupplier(){
		List<Supplier> listsupplier=supplierSer.getAllSupplier();
		List<Supplier> loadlist=new ArrayList<Supplier>();
		for (Supplier sup : listsupplier) {
			Supplier supplier=new Supplier();
			supplier.setIdSupplier(sup.getIdSupplier());
			supplier.setNameSupplier(sup.getNameSupplier());
			loadlist.add(supplier);
		}
		if(loadlist.isEmpty()) {
			return new ResponseEntity<List<Supplier>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<Supplier>>(loadlist,HttpStatus.OK);
	}
	
	/*======================ADD Supplier================= */
	@PostMapping(value="/supplier")
	public ResponseEntity<?> addSupplier(@RequestParam String nameSupplier){
		Supplier supplier=new Supplier();
		supplier.setNameSupplier(nameSupplier);
		int idAdd=supplierSer.addSupplier(supplier);
		if(idAdd==0){
			return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Integer>(1, HttpStatus.OK);
	}
	/*======================UPDATE Supplier================= */
	@PutMapping(value="/supplier/{idSupplier}")
	public ResponseEntity<?> updateSupplier(@PathVariable int idSupplier, @RequestBody Supplier supplier){
		supplier.setIdSupplier(idSupplier);
		boolean update=supplierSer.updateSupplier(supplier);
		if(!update){
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	/*======================DELETE Supplier by ID================= */
	@DeleteMapping(value="supplier/{idSupplier}")
	public ResponseEntity<?> deleteSupplier(@PathVariable int idSupplier){
		boolean delete=supplierSer.deleteSupplier(idSupplier);
		if(!delete){
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
