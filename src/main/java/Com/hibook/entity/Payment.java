package Com.hibook.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="payment")
public class Payment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPayment;
	private String namePayment;
	
	public Payment() {
		super();
	}
	
	public Payment(String namePayment) {
		super();
		this.namePayment = namePayment;
	}

	public int getIdPayment() {
		return idPayment;
	}
	public void setIdPayment(int idPayment) {
		this.idPayment = idPayment;
	}
	public String getNamePayment() {
		return namePayment;
	}
	public void setNamePayment(String namePayment) {
		this.namePayment = namePayment;
	}
	public Payment(int idPayment, String namePayment) {
		super();
		this.idPayment = idPayment;
		this.namePayment = namePayment;
	}
	
}
