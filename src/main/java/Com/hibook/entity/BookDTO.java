package Com.hibook.entity;

import java.util.List;
import java.util.Set;

public class BookDTO {
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
	private Supplier supplier;
	Set<UserReview> userReviews;
	Set<Promotion> promotions;
	List<Author> authors;
	private TypeBook typeBook;
	public BookDTO() {
		super();
	}
	
	
	
	public BookDTO(String publisher, String nameBook, String size, int numberPage, String publicationDate, String cover,
			int quantity, String introBook, int discount, int price, String picBook, String proofread) {
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
	}



	public TypeBook getTypeBook() {
		return typeBook;
	}
	public void setTypeBook(TypeBook typeBook) {
		this.typeBook = typeBook;
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
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
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
