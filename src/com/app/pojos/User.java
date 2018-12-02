package com.app.pojos;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="user_details")
public class User {
	private Integer id;
	private String name,pass,gender,email;
	private String dob,country,city,state,mobile;
	private Feedback feedback;
	private AirlineDetails airdtls;
	private List<Passengers> passenger;
	public User() {
		System.out.println("in user ctor");
	}
	public User(String name, String pass, String gender, String email, String dob, String country,
			String city, String state, String mobile) {
		super();
		this.name = name;
		this.pass = pass;
		this.gender = gender;
		this.email = email;
		this.dob = dob;
		this.country = country;
		this.city = city;
		this.state = state;
		this.mobile = mobile;
	}
	
	@Id
	@GeneratedValue(generator="Sequence-Generator")
	@GenericGenerator(
			name="Sequence-Generator",
			strategy="org.hibernate.id.enhanced.SequenceStyleGenerator",
			parameters={
					@Parameter(name="sequence_name", value="User"),
					@Parameter(name="initial_value", value="1"),
					@Parameter(name="increment_size", value="1")
			}
			)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="user_name",length=20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="pass",length=20)
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Column(name="gender",length=20)
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Column(name="email",length=20,unique=true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="date_of_birth",length=20)
	//@Temporal(TemporalType.DATE)
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	@Column(name="country",length=20)
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Column(name="city",length=20)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(name="state",length=20)
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Column(name="mobile_number",length=20)
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	//--------------------
	@OneToOne(cascade=CascadeType.ALL,mappedBy="user1")
	public Feedback getFeedback() {
		return feedback;
	}
	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}
	//---------------------
	@OneToOne(cascade=CascadeType.ALL,mappedBy="user2")
	public AirlineDetails getAirdtls() {
		return airdtls;
	}
	public void setAirdtls(AirlineDetails airdtls) {
		this.airdtls = airdtls;
	}
	@OneToMany(mappedBy="user3",cascade=CascadeType.ALL)
	public List<Passengers> getPassenger() {
		return passenger;
	}
	public void setPassenger(List<Passengers> passenger) {
		this.passenger = passenger;
	}
	//----------------------
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pass=" + pass + ", gender=" + gender
				+ ", email=" + email + ", dob=" + dob + ", country=" + country + ", city="
				+ city + ", state=" + state + ", mobile=" + mobile + "]";
	}
	
	
	
}
