package com.simplepoll.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Poll
 *
 */
@Entity
@NamedQuery( name="Poll.findById", query = "SELECT p FROM Poll p WHERE p.id = :id" )
public class Poll implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column( name = "CREATED_AT" )
	private Date createdAt;

	private String question;

	@OneToMany(mappedBy = "poll", cascade = CascadeType.ALL)
	private List<PollOption> options = new ArrayList<>();

	public Poll() {
		super();
		this.createdAt = Calendar.getInstance().getTime();
	}
	
	public void addOption(PollOption option) {
		option.setPoll(this);
		options.add(option);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<PollOption> getOptions() {
		return options;
	}

	public void setOptions(List<PollOption> options) {
		this.options = options;
	}

	@Override
	public String toString() {
		return "Poll [id=" + id + ", createdAt=" + createdAt + ", question=" + question + ", options=" + options + "]";
	}

}
