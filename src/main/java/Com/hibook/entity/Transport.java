package Com.hibook.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="transport")
public class Transport {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTransport;
	private String nameTransport;
	private String describes;
	private int fee;
	
	public Transport() {
		super();
	}
	public Transport(int idTransport, String nameTransport, String describes, int fee) {
		super();
		this.idTransport = idTransport;
		this.nameTransport = nameTransport;
		this.describes = describes;
		this.fee = fee;
	}
	public Transport(String nameTransport, String describes, int fee) {
		super();
		this.nameTransport = nameTransport;
		this.describes = describes;
		this.fee = fee;
	}
	public int getIdTransport() {
		return idTransport;
	}
	public void setIdTransport(int idTransport) {
		this.idTransport = idTransport;
	}
	public String getNameTransport() {
		return nameTransport;
	}
	public void setNameTransport(String nameTransport) {
		this.nameTransport = nameTransport;
	}
	public String getDescribes() {
		return describes;
	}
	public void setDescribes(String describes) {
		this.describes = describes;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	
}
