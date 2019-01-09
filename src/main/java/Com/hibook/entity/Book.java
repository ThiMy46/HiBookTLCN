package Com.hibook.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="book")
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBook;
	private String publisher;
	private String nameBook;
	private String size;
	private int numberPage;
	private String publicationDate;
	private String cover;
	private int quantity;
	private String introBook;
	private int discount;
	private int price;
	private String picBook;
	private String proofread;
	
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="idType")
	private TypeBook typeBook;
	
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="idSupplier")
	private Supplier supplier;
	
	//mappedBy hiểu là map đến fiel book bên class UserReview
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany( cascade=CascadeType.ALL,mappedBy = "book")
	@JsonIgnore
	Set<UserReview> userReviews;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="detailpromotion",
	joinColumns=@JoinColumn(name="idBook"),
	inverseJoinColumns=@JoinColumn(name="idPromotion"))
	Set<Promotion> promotions;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="authorbook",
	joinColumns=@JoinColumn(name="idBook"),
	inverseJoinColumns=@JoinColumn(name="idAuthor"))
	List<Author> authors;
	
	public Book(){
		
	}
	

	public Book(String publisher, String nameBook, String size, int numberPage, String publicationDate,
			String cover, int quantity, String introBook, int discount, int price, String picBook, String proofread,
			TypeBook typeBook, Supplier supplier) {
		super();
		this.publisher = publisher;
		this.nameBook = nameBook;
		this.size = size;
		this.numberPage = numberPage;
		this.publicationDate = publicationDate;
		this.cover = cover;
		this.quantity = quantity;
		this.introBook = introBook;
		this.discount = discount;
		this.price = price;
		this.picBook = picBook;
		this.proofread = proofread;
		this.typeBook = typeBook;
		this.supplier = supplier;
	}


	public TypeBook getTypeBook() {
		return typeBook;
	}


	public void setTypeBook(TypeBook typeBook) {
		this.typeBook = typeBook;
	}


	public Supplier getSupplier() {
		return supplier;
	}


	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}


	public int getIdBook() {
		return idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getNameBook() {
		return nameBook;
	}

	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getNumberPage() {
		return numberPage;
	}

	public void setNumberPage(int numberPage) {
		this.numberPage = numberPage;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getIntroBook() {
		return introBook;
	}

	public void setIntroBook(String introBook) {
		this.introBook = introBook;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPicBook() {
		return picBook;
	}

	public void setPicBook(String picBook) {
		this.picBook = picBook;
	}

	public String getProofread() {
		return proofread;
	}

	public void setProofread(String proofread) {
		this.proofread = proofread;
	}


	public Set<UserReview> getUserReviews() {
		return userReviews;
	}


	public void setUserReviews(Set<UserReview> userReviews) {
		this.userReviews = userReviews;
	}
	

	public Set<Promotion> getPromotions() {
		return promotions;
	}


	public void setPromotions(Set<Promotion> promotions) {
		this.promotions = promotions;
	}


	public List<Author> getAuthors() {
		return authors;
	}


	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
}
