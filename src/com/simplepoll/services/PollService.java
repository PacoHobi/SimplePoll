package com.simplepoll.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.simplepoll.models.Poll;

/**
 * Session Bean implementation class PollService
 */
@Stateless
@LocalBean
public class PollService {

	@PersistenceContext(unitName = "simplepoll")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public PollService() {
		// TODO Auto-generated constructor stub
	}

	public void addPoll(Poll p) {
		em.persist(p);
	}

	public Poll findPollById(String pollId) {
		TypedQuery<Poll> pQuery = em.createNamedQuery("Poll.findById", Poll.class);
		pQuery.setParameter("id", Integer.parseInt(pollId));
		
		Poll poll = null;
		try {
			poll = pQuery.getSingleResult();
		} catch (NoResultException e) {
		}
		
		return poll;
	}

}
