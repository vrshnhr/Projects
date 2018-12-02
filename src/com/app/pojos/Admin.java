package com.app.pojos;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
@Table(name="admins")
public class Admin {

	private Integer id;
	private String email,pass;
	
	public Admin() {
	System.out.println("IN ADMIN Constructor");
	}

	public Admin(String email, String pass) {
		super();
		this.email = email;
		this.pass = pass;
	}
@Id
@GeneratedValue(generator="Sequence-Generator")
@GenericGenerator(
		name="Sequence-Generator",
		strategy="org.hibernate.id.enhanced.SequenceStyleGenerator",
		parameters={
				@Parameter(name="sequence_name", value="A"),
				@Parameter(name="initial_value", value="101"),
				@Parameter(name="increment_size", value="1")
		}
		)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="admin_name",length=20)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="pass",length=20)
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", email=" + email + ", pass=" + pass + "]";
	}
	
	
	
}
