package Com.hibook.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Com.hibook.entity.Book;
import Com.hibook.entity.User;
import Com.hibook.entity.UserReview;
import Com.hibook.service.UserReviewSer;

@RestController
@RequestMapping(value = "/api")
public class UserReviewAPIController {

	@Autowired
	UserReviewSer userReviewSer;
//	Load userreview admin
	@GetMapping(value = "/review")
	public ResponseEntity<List<UserReview>> loadUserReview(){
		List<UserReview> listReview=userReviewSer.getAllUserReview();
		List<UserReview> loadlist=new ArrayList<UserReview>();
		for (UserReview uReview : listReview) {
			UserReview review=new UserReview();
			Book book=new Book();
			book.setIdBook(uReview.getBook().getIdBook());
			book.setNameBook(uReview.getBook().getNameBook());
			System.out.println(uReview.getBook().getNameBook());
			User user=new User();
			user.setIdUser(uReview.getUser().getIdUser());
			user.setNameUser(uReview.getUser().getNameUser());
			
			review.setIdReview(uReview.getIdReview());
			review.setStar(uReview.getStar());
			review.setTitle(uReview.getTitle());
			review.setContent(uReview.getContent());
			review.setTimeReview(uReview.getTimeReview());
			review.setReportNum(uReview.getReportNum());
			review.setBook(book);
			review.setUser(user);
			
			loadlist.add(review);
		}
		if(loadlist.isEmpty()) {
			return new ResponseEntity<List<UserReview>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<UserReview>>(loadlist,HttpStatus.OK);
		
	}
	/*======================DELETE Review by ID================= */
	@DeleteMapping(value="/review/{idReview}")
	public ResponseEntity<?> deleteReview( int idReview){
		System.out.println("==============="+idReview);
		boolean delete=userReviewSer.deleteUserReview(idReview);
		if(!delete){
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
