package Com.hibook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.hibook.dao.AuthorDAO;
import Com.hibook.entity.Author;
import Com.hibook.imp.AuthorImp;

@Service
public class AuthorSer implements AuthorImp{
	
	@Autowired
	AuthorDAO authorDAO;

	public List<Author> getAllAuthor() {
		return authorDAO.getAllAuthor();
	}

	public boolean updateAuthor(Author author) {
		return authorDAO.updateAuthor(author);
	}

	public boolean deleteAuthor(int idAuthor) {
		return authorDAO.deleteAuthor(idAuthor);
	}

	public int addAuthor(Author author) {
		return authorDAO.addAuthor(author);
	}

}
