package Com.hibook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.hibook.dao.TypeBookDao;
import Com.hibook.entity.TypeBook;
import Com.hibook.imp.TypeBookImp;

@Service
public class TypeBookSer implements TypeBookImp {
	@Autowired 
	TypeBookDao typebookdao;
	
	public List<TypeBook> getAllTypeBook() {
		return typebookdao.getAllTypeBook();
	}

	public int addTypeBook(TypeBook typeBook) {
		return typebookdao.addTypeBook(typeBook);
	}

	public boolean updateTypeBook(TypeBook typeBook) {
		return typebookdao.updateTypeBook(typeBook);
	}

	public boolean deleteTypeBook(int idTypeBook) {
		return typebookdao.deleteTypeBook(idTypeBook);
	}

}
