package Com.hibook.imp;
import java.util.List;

import Com.hibook.entity.TypeBook;

public interface TypeBookImp {
	List<TypeBook> getAllTypeBook();
	int addTypeBook(TypeBook typeBook);
	boolean updateTypeBook(TypeBook typeBook);
	boolean deleteTypeBook(int idTypeBook);
}
