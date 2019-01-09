package Com.hibook.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Com.hibook.DTO.BookDTONew;
import Com.hibook.DTO.BookHomeDTO;
import Com.hibook.entity.Author;
import Com.hibook.entity.Book;
import Com.hibook.entity.BookDTO;
import Com.hibook.entity.Supplier;
import Com.hibook.entity.TypeBook;
import Com.hibook.entity.User;
import Com.hibook.entity.UserReview;
import Com.hibook.service.BookSer;


@RestController
@RequestMapping(value = "/api")
public class HomeController {

	@Autowired
	BookSer bookser;

	/*==========Lấy những cuốn sách được mua nhiều================= OK*/
	@GetMapping(value="/bookssold")
	public ResponseEntity<List<BookHomeDTO>> Loadbookssold() throws ParseException {
		List<Book> bookssold =bookser.getNumBooksSold();
		List<BookHomeDTO> lstHomeSold=new ArrayList<BookHomeDTO>();
    	for(Book booksold:bookssold) {
    		Date date1=new SimpleDateFormat("MM-yyyy").parse(booksold.getPublicationDate());  
    		BookHomeDTO book=new BookHomeDTO();	    		
    		
    		book.setPublicationDate(date1);
    		book.setNameBook(booksold.getNameBook());
    		book.setIdBook(booksold.getIdBook());
    		book.setDiscount(booksold.getDiscount());
    		book.setPrice(booksold.getPrice());
    		book.setPicBook(booksold.getPicBook());
    		
    		
    		lstHomeSold.add(book); 		
    	}
    	
    	if (lstHomeSold.isEmpty()) {
    		return new ResponseEntity<List<BookHomeDTO>>(HttpStatus.NOT_FOUND);
    	}
    	return new ResponseEntity<List<BookHomeDTO>>(lstHomeSold, HttpStatus.OK);
	}
	/*==============Lấy những cuốn sách ngày xuất bản giảm dần========== OK*/
	@GetMapping(value = "/booknew")
    public ResponseEntity<List<BookHomeDTO>> LoadtrangchuNew() throws ParseException {
    	List<Book> books =bookser.loadtrangchu(0);
    	List<BookHomeDTO> lstHome=new ArrayList<BookHomeDTO>();
    	for(Book listbook:books) {
    		Date date1=new SimpleDateFormat("MM-yyyy").parse(listbook.getPublicationDate());  
    		BookHomeDTO book=new BookHomeDTO();	    		
    		
    		book.setPublicationDate(date1);
    		book.setNameBook(listbook.getNameBook());
    		book.setIdBook(listbook.getIdBook());
    		book.setDiscount(listbook.getDiscount());
    		book.setPrice(listbook.getPrice());
    		book.setPicBook(listbook.getPicBook());
    		List<Author> authors=new ArrayList<Author>();
    		for (Author author1 : listbook.getAuthors()) {
    			Author author=new Author();
    			author.setIdAuthor(author1.getIdAuthor());
    			author.setNameAuthor(author1.getNameAuthor());
    			authors.add(author);
    		}
    		book.setAuthors(authors);
    		
    		lstHome.add(book); 		
    	}
    	//Sắp xếp giảm dần về ngày xuất bản
    	Collections.sort(lstHome);
    	Collections.reverse(lstHome);
    	
    	if (lstHome.isEmpty()) {
    		return new ResponseEntity<List<BookHomeDTO>>(HttpStatus.NOT_FOUND);
    	}
    	return new ResponseEntity<List<BookHomeDTO>>(lstHome, HttpStatus.OK);
    }
	
	
	@RequestMapping("/get-detail-book/{idBook}")
	public ResponseEntity<BookDTO> getDetailBookById(@PathVariable int idBook) {
		Book book1= bookser.getDetailBook(idBook);
		
		TypeBook type=new TypeBook();
		Supplier supplier=new Supplier();
		
		try{
    		supplier.setNameSupplier(book1.getSupplier().getNameSupplier());
    		supplier.setIdSupplier(book1.getSupplier().getIdSupplier());
		}
    	catch (NullPointerException e) {
    		supplier.setNameSupplier("N/A");
    		supplier.setIdSupplier(0);
		}
		try{
    		type.setNameType(book1.getTypeBook().getNameType());
    		type.setIdType(book1.getTypeBook().getIdType());
		}catch (NullPointerException e) {
			supplier.setNameSupplier("N/A");
    		supplier.setIdSupplier(0);
		}
		
		BookDTO book=new BookDTO();
		book.setTypeBook(type);
		book.setNameBook(book1.getNameBook());
		book.setCover(book1.getCover());
		book.setIdBook(book1.getIdBook());
		book.setPublisher(book1.getPublisher());
		book.setSize(book1.getSize());
		book.setNumberPage(book1.getNumberPage());
		book.setPublicationDate(book1.getPublicationDate());
		book.setQuantity(book1.getQuantity());
		book.setIntroBook(book1.getIntroBook());
		book.setDiscount(book1.getDiscount());
		book.setPrice(book1.getPrice());
		book.setPicBook(book1.getPicBook());
		book.setProofread(book1.getProofread());
		book.setSupplier(supplier);
		List<Author> authors=new ArrayList<Author>();
		for (Author author1 : book1.getAuthors()) {
			Author author=new Author();
			author.setIdAuthor(author1.getIdAuthor());
			author.setNameAuthor(author1.getNameAuthor());
			authors.add(author);
		}
		Set<UserReview> uList=new HashSet<UserReview>();
		for (UserReview userReview : book1.getUserReviews()) {
			UserReview uReview=new UserReview();
			uReview.setIdReview(userReview.getIdReview());
			uReview.setContent(userReview.getContent());
			uReview.setTitle(userReview.getTitle());
			uReview.setTimeReview(userReview.getTimeReview());
			uReview.setStar(userReview.getStar());
			uReview.setUser(new User(userReview.getUser().getNameUser()));
			uList.add(uReview);
		}
		book.setAuthors(authors);
		book.setUserReviews(uList);
		
		
		return new ResponseEntity<BookDTO>(book,HttpStatus.OK);
	}
}
