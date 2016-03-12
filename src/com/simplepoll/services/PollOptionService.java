package com.simplepoll.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.simplepoll.models.PollOption;

import javax.persistence.EntityManager;

/**
 * Session Bean implementation class PollOptionService
 */
@Stateless
@LocalBean
public class PollOptionService {
	
	@PersistenceContext( unitName = "simplepoll" )
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public PollOptionService() {
        // TODO Auto-generated constructor stub
    }
    
    public int addVoteById(String pollOptionId) {
    	TypedQuery<PollOption> poQuery = em.createNamedQuery("PollOption.addVoteById", PollOption.class);
    	poQuery.setParameter("id", Integer.parseInt(pollOptionId));
    	int numRowsUpdated = poQuery.executeUpdate();
    	return numRowsUpdated;
    }

}
