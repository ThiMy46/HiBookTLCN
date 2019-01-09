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

import Com.hibook.entity.Transport;
import Com.hibook.service.TransportSer;

/*===================DETAIL Transport================ */
@RestController
@RequestMapping(value = "/api")
public class TransportAPICon {

	@Autowired
	TransportSer transportSer;
	
	/*======================GET all Transport================= */
	@GetMapping(value = "/transport")
	public ResponseEntity<?> loadTransport(){
		List<Transport> listTransport=transportSer.getAllTransport();
		List<Transport> loadlist=new ArrayList<Transport>();
		for (Transport transport : listTransport) {
			Transport trans  =new Transport();
			trans.setIdTransport(transport.getIdTransport());
			trans.setNameTransport(transport.getNameTransport().toString());
			trans.setDescribes(transport.getDescribes());
			trans.setFee(transport.getFee());
			
			loadlist.add(trans);
		}
		if(loadlist.isEmpty()) {
			return new ResponseEntity<List<Transport>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<Transport>>(loadlist,HttpStatus.OK);
	}
	/*======================ADD Transport================= */
	@PostMapping(value="/transport")
	public ResponseEntity<?> addTransport(@RequestParam String nameTransport, @RequestParam String describes, @RequestParam int fee){
		Transport transport=new Transport();
		transport.setNameTransport(nameTransport);
		transport.setDescribes(describes);
		transport.setFee(fee);
		int idAdd=transportSer.addTransport(transport);
		if(idAdd==0){
			return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Integer>(1, HttpStatus.OK);
	}
	/*======================UPDATE Transport================= */
	@PutMapping(value="/transport/{idTransport}")
	public ResponseEntity<?> updateTransport(@PathVariable int idTransport, @RequestBody Transport transport){
		transport.setIdTransport(idTransport);
		boolean update=transportSer.updateTransport(transport);
		if(!update){
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	/*======================DELETE Transport by ID================= */
	@DeleteMapping(value="transport/{idTransport}")
	public ResponseEntity<?> deleteTransport(@PathVariable int idTransport){
		boolean delete=transportSer.deleteTransport(idTransport);
		if(!delete){
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
