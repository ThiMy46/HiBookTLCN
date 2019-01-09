package Com.hibook.DTO;

import java.util.Date;
import java.util.List;

import Com.hibook.entity.Author;

public class BookHomeDTO implements Comparable<BookHomeDTO>{

	private int idBook;
	private String nameBook;
	private Date publicationDate;
	private int discount;
	private int price;
	private String picBook;
	List<Author> authors;
	
	
	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public int getIdBook() {
		return idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	public String getNameBook() {
		return nameBook;
	}

	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}

	
	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
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

	public int compareTo(BookHomeDTO o) {
		if (getPublicationDate() == null || o.getPublicationDate() == null) {
		      return 0;
		    }
		    return getPublicationDate().compareTo(o.getPublicationDate());
	}
}
