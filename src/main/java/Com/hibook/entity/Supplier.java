package Com.hibook.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name="supplier")
public class Supplier {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSupplier;
	private String nameSupplier;
	
	public Supplier() {
		super();
	}
	public Supplier(int idSupplier, String nameSupplier) {
		super();
		this.idSupplier = idSupplier;
		this.nameSupplier = nameSupplier;
	}
	public Supplier(String nameSupplier) {
		super();
		this.nameSupplier = nameSupplier;
	}
	public int getIdSupplier() {
		return idSupplier;
	}
	public void setIdSupplier(int idSupplier) {
		this.idSupplier = idSupplier;
	}
	public String getNameSupplier() {
		return nameSupplier;
	}
	public void setNameSupplier(String nameSupplier) {
		this.nameSupplier = nameSupplier;
	}
	
}
