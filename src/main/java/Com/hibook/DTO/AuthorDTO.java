package Com.hibook.DTO;

public class AuthorDTO {

	private int idAuthor;
	private String nameAuthor;
	private int numberBook;
	public AuthorDTO(int idAuthor, String nameAuthor, int numberBook) {
		super();
		this.idAuthor = idAuthor;
		this.nameAuthor = nameAuthor;
		this.numberBook = numberBook;
	}
	public AuthorDTO() {
		super();
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
	public int getNumberBook() {
		return numberBook;
	}
	public void setNumberBook(int numberBook) {
		this.numberBook = numberBook;
	}
	
	
}
