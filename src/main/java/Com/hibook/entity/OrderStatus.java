package Com.hibook.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="orderstatus")
public class OrderStatus {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idStatus;
	private String nameStatus;
	
	public OrderStatus() {
		super();
	}
	public OrderStatus(int idStatus, String nameStatus) {
		super();
		this.idStatus = idStatus;
		this.nameStatus = nameStatus;
	}
	public OrderStatus(String nameStatus) {
		super();
		this.nameStatus = nameStatus;
	}
	public int getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}
	public String getNameStatus() {
		return nameStatus;
	}
	public void setNameStatus(String nameStatus) {
		this.nameStatus = nameStatus;
	}
	
}
