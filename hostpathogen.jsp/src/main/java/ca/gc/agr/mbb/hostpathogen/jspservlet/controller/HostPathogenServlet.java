package ca.gc.agr.mbb.hostpathogen.jspservlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.gc.agr.mbb.hostpathogen.nouns.Pathogen;

@SuppressWarnings("serial")
@WebServlet(name = "HostPathogenServlet", urlPatterns = {"/search"})
public class HostPathogenServlet extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		String action = request.getParameter("action");
		String pgenus = request.getParameter("pathgenus");
		String pspecies = request.getParameter("pathspecies");
		String pvirus = request.getParameter("pathvirus");
		String psyn = request.getParameter("pathsyn");
		String hfamily = request.getParameter("hostfamily");
		String hgenus = request.getParameter("hostgenus");
		String hspecies = request.getParameter("hostspecies");
		String country = request.getParameter("country");
		String provstate = request.getParameter("provstate");

		PrintWriter out = response.getWriter();

		try {
			out.println("<!DOCTYPE html>");
			out.println("<html><head>");
			out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
			out.println("<title>Host-Pathogen JSP Servlet</title></head>");
			out.println("<body>");
			out.println("<h1>Hello, Welcome to Host-Pathogen Servlet</h1>");  // says Hello
			// Echo client's request information
			out.println("<p>Request URI: " + request.getRequestURI() + "</p>");
			out.println("<p>Protocol: " + request.getProtocol() + "</p>");
			out.println("<p>PathInfo: " + request.getPathInfo() + "</p>");
			out.println("<p>You have request: " + "</br>"
			+ action + "</br>"
			+ pgenus + "</br>"
			+ pspecies + "</br>"
			+ pvirus + "</br>"
			+ psyn + "</br>"
			+ hfamily + "</br>"
			+ hgenus + "</br>"
			+ hspecies + "</br>"
			+ country + "</br>"
			+ provstate + "</br>" + "</p>");

			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close();  // Always close the output writer
		}*/
		request.getRequestDispatcher("/JSP/formview.jsp").forward(request, response);
	}

	/**
	 * Handles the HTTP
	 * <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/JSP/MainPage.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}
}