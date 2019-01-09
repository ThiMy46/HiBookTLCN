package Com.hibook.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import Com.hibook.DTO.BookDTONew;
import Com.hibook.entity.Author;
import Com.hibook.entity.Book;
import Com.hibook.entity.BookDTO;
import Com.hibook.entity.Supplier;
import Com.hibook.entity.TypeBook;
import Com.hibook.service.BookSer;

/*===================DETAIL BOOK================ */
@RestController
@RequestMapping(value = "/api")
public class BookAPICon {

	@Autowired
	BookSer bookSer;
	
	@GetMapping(value = "/search")
	public ResponseEntity<List<BookDTONew>> search(@RequestParam(value = "q") String keyword,@RequestParam(value = "type") String type) throws ParseException{
		List<Book> books= bookSer.search(keyword, type);
		List<BookDTONew> loadlist=new ArrayList<BookDTONew>();
		for (Book book : books) {
			
			BookDTONew bookDTO  =new BookDTONew();
    		bookDTO.setTypeBook(book.getTypeBook().getIdType());
    		bookDTO.setNameBook(book.getNameBook());
    		bookDTO.setIdBook(book.getIdBook());
    		bookDTO.setPublicationDate(new SimpleDateFormat("MM-yyyy").parse(book.getPublicationDate()));
    		bookDTO.setDiscount(book.getDiscount());
    		bookDTO.setPrice(book.getPrice());
    		bookDTO.setPicBook(book.getPicBook());
    		bookDTO.setSupplier(book.getSupplier().getIdSupplier());
    		List<Author> authors=new ArrayList<Author>();
    		for (Author author1 : book.getAuthors()) {
    			Author author=new Author();
    			author.setIdAuthor(author1.getIdAuthor());
    			author.setNameAuthor(author1.getNameAuthor());
    			authors.add(author);
    		}
    		bookDTO.setAuthors(authors);
			loadlist.add(bookDTO);
		}
		if(loadlist.isEmpty()) {
			return new ResponseEntity<List<BookDTONew>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<BookDTONew>>(loadlist,HttpStatus.OK);
	}
	
	/*======================GET all book================= */
	@GetMapping(value = "/book")
	public ResponseEntity<List<BookDTO>> loadAuthor(){
		List<Book> books=bookSer.getAllBook();
		List<BookDTO> loadlist=new ArrayList<BookDTO>();
		for (Book book : books) {
			
			BookDTO bookDTO  =new BookDTO();
			TypeBook type=new TypeBook();
    		Supplier supplier=new Supplier();
    		try{
	    		supplier.setNameSupplier(book.getSupplier().getNameSupplier());
	    		supplier.setIdSupplier(book.getSupplier().getIdSupplier());
    		}
	    	catch (NullPointerException e) {
	    		supplier.setNameSupplier("N/A");
	    		supplier.setIdSupplier(0);
			}
    		try{
	    		type.setNameType(book.getTypeBook().getNameType());
	    		type.setIdType(book.getTypeBook().getIdType());
    		}catch (NullPointerException e) {
    			type.setNameType("N/A");
    			type.setIdType(0);
			}
    		bookDTO.setTypeBook(type);
    		bookDTO.setNameBook(book.getNameBook());
    		bookDTO.setCover(book.getCover());
    		bookDTO.setIdBook(book.getIdBook());
    		bookDTO.setPublisher(book.getPublisher());
    		bookDTO.setSize(book.getSize());
    		bookDTO.setNumberPage(book.getNumberPage());
    		bookDTO.setPublicationDate(book.getPublicationDate());
    		bookDTO.setQuantity(book.getQuantity());
    		bookDTO.setIntroBook(book.getIntroBook());
    		bookDTO.setDiscount(book.getDiscount());
    		bookDTO.setPrice(book.getPrice());
    		bookDTO.setPicBook(book.getPicBook());
    		bookDTO.setProofread(book.getProofread());
    		bookDTO.setSupplier(supplier);
    		 
			loadlist.add(bookDTO);
		}
		if(loadlist.isEmpty()) {
			return new ResponseEntity<List<BookDTO>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<BookDTO>>(loadlist,HttpStatus.OK);
	}
	/*======================GET book ID================= */
	@GetMapping(value = "/book/{idBook}")
	public ResponseEntity<Com.hibook.DTO.BookDTO> getBookbyID(@PathVariable int idBook){
		Book book=bookSer.getDetailBook(idBook);
			
		Com.hibook.DTO.BookDTO bookDTO  =new Com.hibook.DTO.BookDTO();
		bookDTO.setIdType(book.getTypeBook().getIdType());
		bookDTO.setIdSupplier(book.getSupplier().getIdSupplier());
		bookDTO.setNameBook(book.getNameBook());
		bookDTO.setCover(book.getCover());
		bookDTO.setPublisher(book.getPublisher());
		bookDTO.setSize(book.getSize());
		bookDTO.setNumberPage(book.getNumberPage());
		bookDTO.setPublicationDate(book.getPublicationDate());
		bookDTO.setQuantity(book.getQuantity());
		bookDTO.setIntro(book.getIntroBook());
		bookDTO.setDiscount(book.getDiscount());
		bookDTO.setPrice(book.getPrice());
		bookDTO.setFileimg(book.getPicBook());
		bookDTO.setFileproofread(book.getProofread());
		List<Integer> arr=new ArrayList<Integer>();
		List<String> arr_name=new ArrayList<String>();
		for (Author author : book.getAuthors()) {
			arr.add(author.getIdAuthor());
			arr_name.add(author.getNameAuthor());
		}
		bookDTO.setArr_author(arr);
		bookDTO.setArr_nameauthor(arr_name);
    	
		 return new ResponseEntity<Com.hibook.DTO.BookDTO>(bookDTO,HttpStatus.OK);
	}
	/*======================ADD Book================= */
	@PostMapping(value="/book")
	public ResponseEntity<?> addBook(@RequestParam String publisher,@RequestParam String nameBook, @RequestParam int price, @RequestParam int discount, 
			@RequestParam String size, @RequestParam int numberPage, @RequestParam String publicationDate,
			@RequestParam int quantity, @RequestParam String cover, @RequestParam String intro, @RequestParam String fileimg,
			@RequestParam String fileproofread, @RequestParam int idType, @RequestParam int idSupplier, @RequestParam(value="arr_author[]") List<Integer> arr_author){
	
		System.out.println(nameBook+'='+price+"="+discount+"="+publisher+'='+size+"="+numberPage+"="
				   +publicationDate+'='+quantity+"="+cover+"="+intro+"="+fileimg+"="+fileproofread+"="+idType+
				   "="+idSupplier+"="+arr_author.get(0));
		Book book=new Book();
		book.setNameBook(nameBook);
		book.setTypeBook(new TypeBook(idType, null));
		book.setCover(cover);
		book.setPublisher(publisher);
		book.setSize(size);
		book.setNumberPage(numberPage);
		book.setPublicationDate(publicationDate);
		book.setQuantity(quantity);
		book.setIntroBook(intro);
		book.setDiscount(discount);
		book.setPrice(price);
		book.setPicBook(fileimg);
		book.setProofread(fileproofread);
		book.setSupplier(new Supplier(idSupplier,null));
		List<Author> authors=new ArrayList<Author>();
		for (int author : arr_author) {
			authors.add(new Author(author,null));
		}
		book.setAuthors(authors);
		
		int idAdd= bookSer.addBook(book);
		System.out.println("aaaaaaaaaaaaaaa"+idAdd);
		if(idAdd<1){
			return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Integer>(idAdd, HttpStatus.OK);
	}
	/*======================ADD Book================= */
	@PutMapping(value="/book/{idBook}")
	public ResponseEntity<?> updateBook(@PathVariable int idBook, @RequestBody Com.hibook.DTO.BookDTO bookdto){
	
		System.out.println(bookdto.getNameBook()+'='+bookdto.getPrice()+'='+bookdto.getFileimg()+'='+bookdto.getFileproofread()+"="+bookdto.getIdSupplier()+"="+bookdto.getArr_author().get(0));
		Book book=bookSer.getDetailBook(idBook);
		book.setNameBook(bookdto.getNameBook());
		
		book.setTypeBook(new TypeBook(bookdto.getIdType(), null));
		book.setCover(bookdto.getCover());
		book.setPublisher(bookdto.getPublisher());
		book.setSize(bookdto.getSize());
		book.setNumberPage(bookdto.getNumberPage());
		book.setPublicationDate(bookdto.getPublicationDate());
		book.setQuantity(bookdto.getQuantity());
		book.setIntroBook(bookdto.getIntro());
		book.setDiscount(bookdto.getDiscount());
		book.setPrice(bookdto.getPrice());
		book.setPicBook(bookdto.getFileimg());
		book.setProofread(bookdto.getFileproofread());
		
		book.setSupplier(new Supplier(bookdto.getIdSupplier(),null));
		/*List<Author> authors=new ArrayList<Author>();
		for (int author : bookdto.getArr_author()) {
			authors.add(new Author(author,null));
		}
		book.setAuthors(authors);*/
		
		boolean idAdd= bookSer.updateBook(book);
		if(!idAdd){
			return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Integer>(idBook, HttpStatus.OK);
	}
	/*======================DELETE book by ID================= */
	@DeleteMapping(value="/book/{idBook}")
	public ResponseEntity<?> deleteBook(@PathVariable int idBook){
		boolean delete=bookSer.deleteBook(idBook);
		if(!delete){
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
