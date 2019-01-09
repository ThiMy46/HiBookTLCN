package Com.hibook.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUser; 
    private String nameUser;
	private String numberphone;
    private String email;
    private String password;
    private int sex;
    private String birthday;
    private String address;
    
    @OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idRole")
    private Role role;
    
  //mappedBy hiểu là map đến fiel book bên class UserReview
  	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL,mappedBy = "user")
  	Set<UserReview> userReviews;
    
    @OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="user")
	List<Bill> bills;
    
	public User() {
		super();
	}
	public User(String nameUser) {
		super();
		this.nameUser = nameUser;
	}
	
	public User( String nameUser, String numberphone, String email, String password, int sex,
			String birthday, String address) {
		super();
		this.nameUser = nameUser;
		this.numberphone = numberphone;
		this.email = email;
		this.password = password;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
	}
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getNameUser() {
		return nameUser;
	}
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	public String getNumberphone() {
		return numberphone;
	}
	public void setNumberphone(String numberphone) {
		this.numberphone = numberphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public Set<UserReview> getUserReviews() {
		return userReviews;
	}

	public void setUserReviews(Set<UserReview> userReviews) {
		this.userReviews = userReviews;
	}

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}
	
}
