package Com.hibook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.hibook.dao.TransportDAO;
import Com.hibook.entity.Transport;
import Com.hibook.imp.TransportImp;

@Service
public class TransportSer implements TransportImp{

	@Autowired
	TransportDAO transportDAO;
	
	public List<Transport> getAllTransport() {
		return transportDAO.getAllTransport();
	}

	public int addTransport(Transport transport) {
		return transportDAO.addTransport(transport);
	}

	public boolean updateTransport(Transport transport) {
		return transportDAO.updateTransport(transport);
	}

	public boolean deleteTransport(int idTransport) {
		return transportDAO.deleteTransport(idTransport);
	}

	public Transport getTransport(int idTransport) {
		
		return transportDAO.getTransport(idTransport);
	}

}
