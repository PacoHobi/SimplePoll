package com.simplepoll.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entity implementation class for Entity: PollOption
 *
 */
@Entity
@Table(name = "POLL_OPTION")
@NamedQuery(name = "PollOption.addVoteById", query = "UPDATE PollOption p SET p.votes = p.votes + 1 WHERE p.id = :id")
public class PollOption implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String text;

	private Integer votes;

	@ManyToOne
	@JoinColumn(name = "POLL_FK")
	private Poll poll;

	public PollOption() {
		super();
	}

	public PollOption(String text) {
		super();
		this.text = text;
		this.votes = 0;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getVotes() {
		return votes;
	}

	public void setVotes(Integer votes) {
		this.votes = votes;
	}

	public Poll getPoll() {
		return poll;
	}

	public void setPoll(Poll poll) {
		this.poll = poll;
	}

	@Override
	public String toString() {
		return "PollOption [id=" + id + ", text=" + text + ", votes=" + votes + ", poll=" + poll.getQuestion() + "]";
	}

}
