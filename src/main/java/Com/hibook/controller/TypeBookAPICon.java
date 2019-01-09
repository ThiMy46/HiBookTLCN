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

import Com.hibook.entity.TypeBook;
import Com.hibook.service.TypeBookSer;

/*===================DETAIL TypeBook================ */
@RestController
@RequestMapping(value = "/api")
public class TypeBookAPICon {

	@Autowired
	TypeBookSer typeBookSer;
	
	/*======================GET all TypeBook================= */
	@GetMapping(value = "/typebook")
	public ResponseEntity<?> loadTypeBook(){
		List<TypeBook> listTypeBook=typeBookSer.getAllTypeBook();
		List<TypeBook> loadlist=new ArrayList<TypeBook>();
		for (TypeBook typeBook : listTypeBook) {
			TypeBook type  =new TypeBook();
			type.setIdType(typeBook.getIdType());
			type.setNameType(typeBook.getNameType().toString());
			loadlist.add(type);
		}
		if(loadlist.isEmpty()) {
			return new ResponseEntity<List<TypeBook>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<TypeBook>>(loadlist,HttpStatus.OK);
	}
	/*======================ADD TypeBook================= */
	@PostMapping(value="/typebook")
	public ResponseEntity<?> addTypeBook(@RequestParam String nameType){
		TypeBook typeBook=new TypeBook(nameType);
		int idAdd=typeBookSer.addTypeBook(typeBook);
		if(idAdd==0){
			return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Integer>(1, HttpStatus.OK);
	}
	/*======================UPDATE TypeBook================= */
	@PutMapping(value="/typebook/{idType}")
	public ResponseEntity<?> updateTypeBook(@PathVariable int idType, @RequestBody TypeBook typeBook){
		typeBook.setIdType(idType);
		boolean update=typeBookSer.updateTypeBook(typeBook);
		if(!update){
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	/*======================DELETE TypeBook by ID================= */
	@DeleteMapping(value="typebook/{idType}")
	public ResponseEntity<?> deleteTypeBook(@PathVariable int idType){
		boolean delete=typeBookSer.deleteTypeBook(idType);
		if(!delete){
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
