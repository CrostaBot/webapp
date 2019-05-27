package it.unipd.dei.webapp.servlet;

import it.unipd.dei.webapp.database.CreatePaperDatabase;
import it.unipd.dei.webapp.resource.Paper;
import it.unipd.dei.webapp.resource.Message;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class CreatePaperServlet extends AbstractDatabaseServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		// request parameters
		String title = null;
		String[] authors = null;
		int year = -1;
		String date = null;

		// model
		Paper p  = null;
		Message m = null;

		try{
			// retrieves the request parameters
			title = req.getParameter("title");
			authors = req.getParameter("authors");
			year = Integer.parseInt(req.getParameter("year"));
			mDate = req.getParameter("mDate");

			// creates a new paper from the request parameters
			p = new Paper(title, authors, year, mDate);

			// creates a new object for accessing the database and stores the employee
			new CreatePaperDatabase(getDataSource().getConnection(), p).createPaper();

			m = new Message(String.format("Paper %s successfully created.", title));

		} catch (NumberFormatException ex) {
			m = new Message("Cannot create the paper. Invalid input parameters: year must be integer.",
					"E100", ex.getMessage());
		}

		// stores the employee and the message as a request attribute
		req.setAttribute("paper", p);
		req.setAttribute("message", m);

		// forwards the control to the create-paper-result JSP
		req.getRequestDispatcher("/jsp/create-paper-result.jsp").forward(req, res);
	}

}
