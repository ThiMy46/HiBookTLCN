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

import Com.hibook.DTO.AuthorDTO;
import Com.hibook.entity.Author;
import Com.hibook.entity.Book;
import Com.hibook.service.AuthorSer;
/*===================DETAIL AUTHOR================ */
@RestController
@RequestMapping(value = "/api")
public class AuthorAPICon {

	@Autowired
	AuthorSer authorSer;
	
	/*======================GET all author================= */
	@GetMapping(value = "/author")
	public ResponseEntity<List<AuthorDTO>> loadAuthor(){
		List<Author> listAuthor=authorSer.getAllAuthor();
		List<AuthorDTO> loadlist=new ArrayList<AuthorDTO>();
		for (Author aut : listAuthor) {
			
			AuthorDTO authorDTO  =new AuthorDTO();
			authorDTO.setIdAuthor(aut.getIdAuthor());
			authorDTO.setNameAuthor(aut.getNameAuthor().toString());
			authorDTO.setNumberBook(aut.getBooks().size());
			loadlist.add(authorDTO);
		}
		if(loadlist.isEmpty()) {
			return new ResponseEntity<List<AuthorDTO>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<AuthorDTO>>(loadlist,HttpStatus.OK);
	}
	/*======================ADD author================= */
	@PostMapping(value="/author")
	public ResponseEntity<?> addAuthor(@RequestParam String nameAuthor){
		Author author=new Author();
		author.setNameAuthor(nameAuthor);
		int idAdd=authorSer.addAuthor(author);
		if(idAdd==0){
			return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Integer>(idAdd, HttpStatus.OK);
	}
	/*======================UPDATE author================= */
	@PutMapping(value="/author/{idAuthor}")
	public ResponseEntity<?> updateAuthor(@PathVariable int idAuthor, @RequestBody Author author){
		//Author author=new Author(idAuthor,nameAuthor);
		author.setIdAuthor(idAuthor);
		boolean update=authorSer.updateAuthor(author);
		if(!update){
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	/*======================DELETE author by ID================= */
	//not delete if constraint with book 
	@DeleteMapping(value="/author/{idAuthor}")
	public ResponseEntity<?> deleteAuthor(@PathVariable int idAuthor){
		boolean delete=authorSer.deleteAuthor(idAuthor);
		if(!delete){
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
