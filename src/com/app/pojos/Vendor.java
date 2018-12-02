package com.app.pojos;
import java.util.List;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
@Table(name="vendor_details")
public class Vendor {

	private Integer id;
	private String name,pass,gender,email;
	private String dob,country,city,state,mobile,airlineName;
	private List<AirlineDetails> airdt;
	public Vendor() {
	System.out.println("in Vendor CTOR");
	}
	public Vendor(String name, String pass, String gender, String email, String dob, String country,
			String city, String state, String mobile, String airlineName) {
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
		this.airlineName = airlineName;
	}
	@Id
	@GeneratedValue(generator="Sequence-Generator")
	@GenericGenerator(
			name="Sequence-Generator",
			strategy="org.hibernate.id.enhanced.SequenceStyleGenerator",
			parameters={
					@Parameter(name="sequence_name", value="Vendor"),
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
	@Column(name="vendor_name",length=20)
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
	@Column(name="email",unique=true, length=20)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="date_of_birth",length=20)
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
	@Column(name="airline_name",length=20)
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	//----------------------
	@OneToMany (mappedBy="vendor1", cascade=CascadeType.ALL)
	public List<AirlineDetails> getAirdt() {
		return airdt;
	}
	public void setAirdt(List<AirlineDetails> airdt) {
		this.airdt = airdt;
	}
	//----------------------
	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", pass=" + pass + ", gender=" + gender + ", email="
				+ email + ", dob=" + dob + ", country=" + country + ", city=" + city
				+ ", state=" + state + ", mobile=" + mobile + ", airlineName=" + airlineName + "]";
	}
	
	
	
}
