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
import com.simplepoll.models.PollOption;
import com.simplepoll.services.PollService;

/**
 * Servlet implementation class CreatePoll
 */
@WebServlet("")
public class CreatePoll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	PollService ps;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreatePoll() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/create_poll.jsp");
		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("errors", false);
		request.setAttribute("question_error", false);

		Poll poll = new Poll();

		String question = request.getParameter("question");
		String option1 = request.getParameter("option1");
		String option2 = request.getParameter("option2");
		String option3 = request.getParameter("option3");
		String option4 = request.getParameter("option4");

		if (question == null || question.length() == 0) {
			request.setAttribute("errors", true);
			request.setAttribute("question_error", true);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/create_poll.jsp");
			view.forward(request, response);
			return;
		}

		poll.setQuestion(question);

		if (option1.length() > 0)
			poll.addOption(new PollOption(option1));

		if (option2.length() > 0)
			poll.addOption(new PollOption(option2));

		if (option3.length() > 0)
			poll.addOption(new PollOption(option3));

		if (option4.length() > 0)
			poll.addOption(new PollOption(option4));

		System.out.println("New poll created: " + poll);

		ps.addPoll(poll);

		response.sendRedirect(request.getContextPath() + "/v/" + poll.getId());

	}

}
