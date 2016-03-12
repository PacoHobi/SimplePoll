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
import com.simplepoll.services.PollService;

/**
 * Servlet implementation class ViewPollResults
 */
@WebServlet("/r/*")
public class ViewPollResults extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PollService ps;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPollResults() {
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

		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/poll_results.jsp");
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
