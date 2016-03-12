package com.simplepoll.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplepoll.models.Poll;
import com.simplepoll.services.PollOptionService;
import com.simplepoll.services.PollService;

/**
 * Servlet implementation class ViewPoll
 */
@WebServlet("/v/*")
public class ViewPoll extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PollService ps;
	
	@EJB
	private PollOptionService pos;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPoll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pollId = "";
		
		if (request.getPathInfo().matches("^\\/\\d+(\\/)?$")) {
			pollId = request.getPathInfo().replaceAll("\\/", "");
		} else {
			System.out.println("URL not recognized, redirecting ...");
			response.sendRedirect(request.getContextPath());
			return;
		}
		
		Poll poll = ps.findPollById(pollId);
		
		if (poll == null) {
			System.out.println("No poll found with ID " + pollId + ", redirecting ...");
			response.sendRedirect(request.getContextPath());
			return;
		}
		
		System.out.println("Found poll with ID " + pollId + ":\n" + poll);
		
		request.setAttribute("poll", poll);

		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/view_poll.jsp");
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pollId = request.getParameter("poll_id");
		String optionId = request.getParameter("option_id");
		
		if (pollId == null || optionId == null) {
			System.out.println("The parameter 'poll_id' or 'option_id' is not set, redirecting ...");
			response.sendRedirect(request.getContextPath());
			return;
		}
		
		pos.addVoteById(optionId);
		
		response.sendRedirect(request.getContextPath() + "/r/" + pollId);
	
	}

}
