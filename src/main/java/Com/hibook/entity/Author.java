package Com.hibook.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity(name="author")
public class Author {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAuthor;
	private String nameAuthor;
	
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="authorbook",
	joinColumns=@JoinColumn(name="idAuthor"),
	inverseJoinColumns=@JoinColumn(name="idBook"))
	@JsonIgnore
	List<Book> books;
	
	public Author() {
		super();
	}
	public Author(int idAuthor, String nameAuthor) {
		super();
		this.idAuthor = idAuthor;
		this.nameAuthor = nameAuthor;
	}
	public Author(String nameAuthor) {
		super();
		this.nameAuthor = nameAuthor;
	}
	public int getIdAuthor() {
		return idAuthor;
	}
	public void setIdAuthor(int idAuthor) {
		this.idAuthor = idAuthor;
	}
	public String getNameAuthor() {
		return nameAuthor;
	}
	public void setNameAuthor(String nameAuthor) {
		this.nameAuthor = nameAuthor;
	}
	
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
	
}
