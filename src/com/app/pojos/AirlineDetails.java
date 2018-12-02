package com.app.pojos;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "airline_details")
public class AirlineDetails {

	private Integer Id; // VendorId,FlightId;
	private String FlightNumber, AirlineName, FromLocation, ToLocation, DepartureTime, ArrivalTime, Duration;
	private int TotalSeats;
	private double Fare;
	private User user2;
	private Vendor vendor1;

	public AirlineDetails() {
		System.out.println("in airline detail CTOR");
	}

	public AirlineDetails(Integer vendorId, Integer flightId, String flightNumber, String airlineName,
			String fromLocation, String toLocation, String departureTime, String arrivalTime, String duration,
			int totalSeats, double fare) {
		super();
		/*VendorId = vendorId;
		FlightId = flightId;*/
		FlightNumber = flightNumber;
		AirlineName = airlineName;
		FromLocation = fromLocation;
		ToLocation = toLocation;
		DepartureTime = departureTime;
		ArrivalTime = arrivalTime;
		Duration = duration;
		TotalSeats = totalSeats;
		Fare = fare;
	}

	@Id
	@GeneratedValue(generator = "Sequence-Generator")
	@GenericGenerator(name = "Sequence-Generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "Flight"), @Parameter(name = "initial_value", value = "1101"),
			@Parameter(name = "increment_size", value = "1") })
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	/*public Integer getFlightId() {
		return FlightId;
	}

	public void setFlightId(Integer flightId) {
		FlightId = flightId;
	}

	public Integer getVendorId() {
		return VendorId;
	}

	public void setVendorId(Integer vendorId) {
		VendorId = vendorId;
	}
*/
	@Column(name = "flight_number", length = 20)
	public String getFlightNumber() {
		return FlightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		FlightNumber = flightNumber;
	}

	@Column(name = "airline_name", length = 20)
	public String getAirlineName() {
		return AirlineName;
	}

	public void setAirlineName(String airlineName) {
		AirlineName = airlineName;
	}

	@Column(name = "from", length = 20)
	public String getFromLocation() {
		return FromLocation;
	}

	public void setFromLocation(String fromLocation) {
		FromLocation = fromLocation;
	}

	@Column(name = "to", length = 20)
	public String getToLocation() {
		return ToLocation;
	}

	public void setToLocation(String toLocation) {
		ToLocation = toLocation;
	}

	@Column(name = "departure", length = 20)
	public String getDepartureTime() {
		return DepartureTime;
	}

	public void setDepartureTime(String departureTime) {
		DepartureTime = departureTime;
	}

	@Column(name = "arrival", length = 20)
	public String getArrivalTime() {
		return ArrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		ArrivalTime = arrivalTime;
	}

	@Column(name = "duration", length = 20)
	public String getDuration() {
		return Duration;
	}

	public void setDuration(String duration) {
		Duration = duration;
	}

	@Column(name = "available_seats", length = 20)
	public int getTotalSeats() {
		return TotalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		TotalSeats = totalSeats;
	}

	@Column(name = "fares", length = 20)
	public double getFare() {
		return Fare;
	}

	public void setFare(double fare) {
		Fare = fare;
	}

//----------------------
	@OneToOne
	@JoinColumn(name = "user_id")
	public User getUser1() {
		return user2;
	}
	public void setUser1(User user2) {
		this.user2 = user2;
	}

//----------------------
	@ManyToOne
	@JoinColumn(name="vendor_id")
	public Vendor getVendor1() {
		return vendor1;
	}

	public void setVendor1(Vendor vendor1) {
		this.vendor1 = vendor1;
	}
//----------------------
	@Override
	public String toString() {
		return "AirlineDetails [Id=" + Id +", FlightNumber="
				+ FlightNumber + ", AirlineName=" + AirlineName + ", FromLocation=" + FromLocation + ", ToLocation="
				+ ToLocation + ", DepartureTime=" + DepartureTime + ", ArrivalTime=" + ArrivalTime + ", Duration="
				+ Duration + ", TotalSeats=" + TotalSeats + ", Fare=" + Fare + "]";
	}

	

}
