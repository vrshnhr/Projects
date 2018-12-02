package com.app.pojos;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
@Table(name="passengers")
public class Passengers {

	private Integer PnrId;		//,UserId,FlightId;
	private String passengerName,gender;
	private String dob;
	private User user3;
	public Passengers() {
	System.out.println("in pass ctor");
	}

	public Passengers(Integer userId, Integer flightId, String passengerName, String gender, String dob) {
		super();
		/*UserId = userId;
		FlightId = flightId;*/
		this.passengerName = passengerName;
		this.gender = gender;
		this.dob = dob;
	}
	@Id
	@Column(name="pnr_number",length=20)
	@GeneratedValue(generator="Sequence-Generator")
	@GenericGenerator(
			name="Sequence-Generator",
			strategy="org.hibernate.id.enhanced.SequenceStyleGenerator",
			parameters={
					@Parameter(name="sequence_name", value="Apnr"),
					@Parameter(name="initial_value", value="1101"),
					@Parameter(name="increment_size", value="1")
			}
			)
	public Integer getPnrId() {
		return PnrId;
	}

	public void setPnrId(Integer pnrId) {
		PnrId = pnrId;
	}
	/*@Column(name="user_name",length=20)
	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
		UserId = userId;
	}
	@Column(name="flight_id",length=20)
	public Integer getFlightId() {
		return FlightId;
	}

	public void setFlightId(Integer flightId) {
		FlightId = flightId;
	}*/
	@Column(name="passenger_name",length=20)
	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	@Column(name="gender",length=20)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	@Column(name="date_of_birth",length=20)
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	@ManyToOne
	@JoinColumn(name="user_id")
	public User getUser3() {
		return user3;
	}

	public void setUser3(User user3) {
		this.user3 = user3;
	}

	@Override
	public String toString() {
		return "Passengers [PnrId=" + PnrId + ", passengerName="
				+ passengerName + ", gender=" + gender + ", dob=" + dob + "]";
	}
	
	
}
