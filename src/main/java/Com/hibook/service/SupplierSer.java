package Com.hibook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.hibook.dao.SupplierDAO;
import Com.hibook.entity.Supplier;
import Com.hibook.imp.SupplierImp;

@Service
public class SupplierSer implements SupplierImp{
	@Autowired
	SupplierDAO supplierDAO;

	public List<Supplier> getAllSupplier() {
		return supplierDAO.getAllSupplier();
	}

	public int addSupplier(Supplier supplier) {
		return supplierDAO.addSupplier(supplier);
	}

	public boolean updateSupplier(Supplier supplier) {
		return supplierDAO.updateSupplier(supplier);
	}

	public boolean deleteSupplier(int idSupplier) {
		return supplierDAO.deleteSupplier(idSupplier);
	}

}
