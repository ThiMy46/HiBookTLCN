package Com.hibook.DTO;

public class CartDTO {
	int idBook;
	String nameBook;
	String imgBook;
	int price;
	int quantity;
	int idCart;
	public int getIdCart() {
		return idCart;
	}
	public void setIdCart(int idCart) {
		this.idCart = idCart;
	}
	public CartDTO() {
		super();
	}
	public CartDTO(String nameBook, String imgBook, int price, int quantity) {
		super();
		this.nameBook = nameBook;
		this.imgBook = imgBook;
		this.price = price;
		this.quantity = quantity;
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
	public String getImgBook() {
		return imgBook;
	}
	public void setImgBook(String imgBook) {
		this.imgBook = imgBook;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
