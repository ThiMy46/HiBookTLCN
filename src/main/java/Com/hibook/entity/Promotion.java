package Com.hibook.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name="promotion")
public class Promotion {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPromotion;
    private String titlePromotion;
    private String contentPromotion;
	private String timeStart;
    private String timeEnd;
    private String picPromotion;
    private int saleOff;
    
    @ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="detailpromotion",
	joinColumns={@JoinColumn(name="idPromotion", referencedColumnName="idPromotion")},
	inverseJoinColumns={@JoinColumn(name="idBook", referencedColumnName="idBook")})
	List<Book> books;
    
	public Promotion() {
		super();
	}
	public Promotion(int idPromotion, String titlePromotion, String contentPromotion, String timeStart, String timeEnd,
			String picPromotion, int saleOff) {
		super();
		this.idPromotion = idPromotion;
		this.titlePromotion = titlePromotion;
		this.contentPromotion = contentPromotion;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.picPromotion = picPromotion;
		this.saleOff = saleOff;
	}
	public int getIdPromotion() {
		return idPromotion;
	}
	public void setIdPromotion(int idPromotion) {
		this.idPromotion = idPromotion;
	}
	public String getTitlePromotion() {
		return titlePromotion;
	}
	public void setTitlePromotion(String titlePromotion) {
		this.titlePromotion = titlePromotion;
	}
	public String getContentPromotion() {
		return contentPromotion;
	}
	public void setContentPromotion(String contentPromotion) {
		this.contentPromotion = contentPromotion;
	}
	public String getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}
	public String getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}
	public String getPicPromotion() {
		return picPromotion;
	}
	public void setPicPromotion(String picPromotion) {
		this.picPromotion = picPromotion;
	}
	public int getSaleOff() {
		return saleOff;
	}
	public void setSaleOff(int saleOff) {
		this.saleOff = saleOff;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
    
}
