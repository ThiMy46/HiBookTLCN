package Com.hibook.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="detailbill")
public class DetailBill implements Serializable{

	@Id
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idBook")
	private Book book;
	@Id
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idBill")
	private Bill bill;
	
	private int quantityBuy;
	private int price;
	
	public DetailBill() {
		super();
	}
	public DetailBill(int idBook, int idBill, int quantityBuy, int price) {
		super();
		this.quantityBuy = quantityBuy;
		this.price = price;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	public int getQuantityBuy() {
		return quantityBuy;
	}
	public void setQuantityBuy(int quantityBuy) {
		this.quantityBuy = quantityBuy;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
