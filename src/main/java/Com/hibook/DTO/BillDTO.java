package Com.hibook.DTO;

import java.util.ArrayList;
import java.util.List;

public class BillDTO {

	private int idBill;
	private String nameReceiver;
	private String numberphone;
	private String deliveryAdress;
	private String dateCreate;
	private int total;
	
	private String nameUser;
	private String namePayment;
	private String nameTransport;
	private int feeTransport;
	private int idStatus;
	private String nameStatus;
	
	private List<DetailBillDTO> detailBillDTOs=new ArrayList<DetailBillDTO>();

	public BillDTO() {
		super();
	}
	

	public String getNameStatus() {
		return nameStatus;
	}


	public void setNameStatus(String nameStatus) {
		this.nameStatus = nameStatus;
	}


	public int getIdBill() {
		return idBill;
	}

	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}

	public String getNameReceiver() {
		return nameReceiver;
	}

	public void setNameReceiver(String nameReceiver) {
		this.nameReceiver = nameReceiver;
	}

	public String getNumberphone() {
		return numberphone;
	}

	public void setNumberphone(String numberphone) {
		this.numberphone = numberphone;
	}

	public String getDeliveryAdress() {
		return deliveryAdress;
	}

	public void setDeliveryAdress(String deliveryAdress) {
		this.deliveryAdress = deliveryAdress;
	}

	public String getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(String dateCreate) {
		this.dateCreate = dateCreate;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getNamePayment() {
		return namePayment;
	}

	public void setNamePayment(String namePayment) {
		this.namePayment = namePayment;
	}

	public String getNameTransport() {
		return nameTransport;
	}

	public void setNameTransport(String nameTransport) {
		this.nameTransport = nameTransport;
	}

	public int getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	public List<DetailBillDTO> getDetailBillDTOs() {
		return detailBillDTOs;
	}

	public void setDetailBillDTOs(List<DetailBillDTO> detailBillDTOs) {
		this.detailBillDTOs = detailBillDTOs;
	}

	public int getFeeTransport() {
		return feeTransport;
	}

	public void setFeeTransport(int feeTransport) {
		this.feeTransport = feeTransport;
	}
	
	
	
}
