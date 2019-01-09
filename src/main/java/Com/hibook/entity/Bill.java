package Com.hibook.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity(name="bill")
public class Bill {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBill;
	private String nameReceiver;
	private String numberphone;
	private String deliveryAdress;
	private String dateCreate;
	private int total;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idUser")
	private User user;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idPayment")
	private Payment payment;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idStatus")
	private OrderStatus orderStatus;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idTransport")
	private Transport transport;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="idBill")
	List<DetailBill> detailBills;
	 
	public Bill() {
		super();
	}
	public Bill(String nameReceiver, String numberphone, String deliveryAdress, String dateCreate,
			int total) {
		super();
		this.nameReceiver = nameReceiver;
		this.numberphone = numberphone;
		this.deliveryAdress = deliveryAdress;
		this.dateCreate = dateCreate;
		this.total = total;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Transport getTransport() {
		return transport;
	}
	public void setTransport(Transport transport) {
		this.transport = transport;
	}
	public List<DetailBill> getDetailBills() {
		return detailBills;
	}
	public void setDetailBills(List<DetailBill> detailBills) {
		this.detailBills = detailBills;
	}
	
	
}
