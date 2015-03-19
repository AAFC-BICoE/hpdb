package ca.gc.agr.mbb.hostpathogen.jspservlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.gc.agr.mbb.hostpathogen.jspservlet.dao.RequestFormData;
import ca.gc.agr.mbb.hostpathogen.nouns.Pathogen;

@SuppressWarnings("serial")
@WebServlet(name = "HostPathogenServlet", urlPatterns = {"/search"})
public class HostPathogenServlet extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("JSP/ViewFormParam.jsp").forward(request, response);
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
		request.getRequestDispatcher("JSP/MainPage.jsp").forward(request, response);
		
		RequestFormData data = new RequestFormData();
		request.getSession().setAttribute("search", data);
		
		data.setPathogenGenus(request.getParameter("pathogenGenus"));
		data.setPathogenSpecies(request.getParameter("pathogenSpecies"));
		data.setPathogenVirus(request.getParameter("pathogenVirus"));
		data.setPathogenSynonym(request.getParameter("pathogenSynonym"));
		data.setCountry(request.getParameter("country"));
		data.setProvinceStateTerritory(request.getParameter("provinceStateTerritory"));
		data.setHostFamily(request.getParameter("hostFamily"));
		data.setHostGenus(request.getParameter("hostGenus"));
		data.setHostSpecies(request.getParameter("hostSpecies"));
		data.setHostSynonym(request.getParameter("hostSynonym"));
		
		String address;
		
		if(request.getParameter("SearchFormButton") != null){
			address = "SearchResult.jsp";
		}
		else if (request.getParameter("SerachForm") == null){
			address = "Error.jsp";
		}else {
			address = "MainPage.jsp";
		}
		request.getRequestDispatcher(address).forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("JSP/Error.jsp").forward(request, response);
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