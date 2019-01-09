package Com.hibook.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="userreview")
public class UserReview implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idReview;
	private int star;
	private String title;
	private String content;
	private String timeReview;
	private int reportNum;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idUser")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idBook")
	private Book book;
	
	public UserReview() {
		super();
	}
	public UserReview(int idReview, int star, String title, String content, String timeReview, int reportNum,
			int idUser) {
		super();
		this.idReview = idReview;
		this.star = star;
		this.title = title;
		this.content = content;
		this.timeReview = timeReview;
		this.reportNum = reportNum;
	}
	public int getIdReview() {
		return idReview;
	}
	public void setIdReview(int idReview) {
		this.idReview = idReview;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTimeReview() {
		return timeReview;
	}
	public void setTimeReview(String timeReview) {
		this.timeReview = timeReview;
	}
	public int getReportNum() {
		return reportNum;
	}
	public void setReportNum(int reportNum) {
		this.reportNum = reportNum;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
}
