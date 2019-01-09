package Com.hibook.imp;

import java.util.List;

import Com.hibook.entity.Transport;

public interface TransportImp {
	List<Transport> getAllTransport();
	int addTransport(Transport transport);
	boolean updateTransport(Transport transport);
	boolean deleteTransport(int idTransport);
	Transport getTransport(int idTransport);
}
