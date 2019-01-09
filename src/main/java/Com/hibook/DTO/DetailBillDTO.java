package Com.hibook.DTO;

import Com.hibook.entity.Book;


public class DetailBillDTO {

	private Book book;
	private int quantityBuy;
	private int price;
	public DetailBillDTO(Book book, int quantityBuy, int price) {
		super();
		this.book = book;
		this.quantityBuy = quantityBuy;
		this.price = price;
	}
	
	public DetailBillDTO() {
		super();
	}

	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
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
