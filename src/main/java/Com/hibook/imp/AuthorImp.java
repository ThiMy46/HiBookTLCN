package Com.hibook.imp;

import java.util.List;

import Com.hibook.entity.Author;

public interface AuthorImp {

	List<Author> getAllAuthor();
	int addAuthor(Author author);
	boolean updateAuthor(Author author);
	boolean deleteAuthor(int idAuthor);
}
