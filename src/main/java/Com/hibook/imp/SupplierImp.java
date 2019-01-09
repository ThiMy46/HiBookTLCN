package Com.hibook.imp;

import java.util.List;

import Com.hibook.entity.Supplier;

public interface SupplierImp {

	List<Supplier> getAllSupplier();
	int addSupplier(Supplier supplier);
	boolean updateSupplier(Supplier supplier);
	boolean deleteSupplier(int idSupplier);
}
