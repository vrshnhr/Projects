package com.app.pojos;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "feedbacks")
public class Feedback {
	private Integer Id; // UserId;
	private String experience, suggestion;
	private User user1;

	public Feedback() {
		System.out.println("in Feedback CTOR");
	}

	public Feedback(Integer userId, String experience, String suggestion) {
		super();
		this.experience = experience;
		this.suggestion = suggestion;
	}

	@Id
	@GeneratedValue(generator = "Sequence-Generator")
	@GenericGenerator(name = "Sequence-Generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "F"), @Parameter(name = "initial_value", value = "1"),
			@Parameter(name = "increment_size", value = "1") })
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	/*
	 * public Integer getUserId() { return UserId; }
	 * 
	 * public void setUserId(Integer userId) { UserId = userId; }
	 */
	@Column(name = "experience", length = 20)
	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	@Column(name = "suggestion", length = 50)
	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

//----------------------
	@OneToOne
	@JoinColumn(name = "user_id")
	public User getUser1() {
		return user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

//----------------------
	@Override
	public String toString() {
		return "Feedback [Id=" + Id + ", " + ", experience=" + experience + ", suggestion=" + suggestion
				+ "]";
	}

}
