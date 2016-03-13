package com.simplepoll.webservices.rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.simplepoll.models.Poll;
import com.simplepoll.services.PollService;

@Path("/polls")
public class PollWebService {

	@EJB
	PollService ps;

	public PollWebService() {

	}

	@GET
	@Path("{poll_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Poll getPoll(@PathParam("poll_id") Integer pollId) {

		Poll poll = ps.findPollById(String.valueOf(pollId));

		if (poll == null) {
			throw new NotFoundException("Poll with ID " + pollId + " not found");
		}

		return poll;

	}

}
