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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="typebook")
public class TypeBook {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idType;
	private String nameType;
	
	public TypeBook() {
		super();
	}
	public TypeBook(int idType, String nameType) {
		super();
		this.idType = idType;
		this.nameType = nameType;
	}
	public TypeBook(String nameType) {
		super();
		this.nameType = nameType;
	}
	public int getIdType() {
		return idType;
	}
	public void setIdType(int idType) {
		this.idType = idType;
	}
	public String getNameType() {
		return nameType;
	}
	public void setNameType(String nameType) {
		this.nameType = nameType;
	}

}
