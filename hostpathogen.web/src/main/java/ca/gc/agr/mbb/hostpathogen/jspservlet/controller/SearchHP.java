package ca.gc.agr.mbb.hostpathogen.jspservlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebInitParam;
import javax.ws.rs.Path;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/hpdb/eng/search")
public class SearchHP extends HttpServlet {
	private static final long serialVersionUID=1L;
	
	private static final Logger logger = Logger.getLogger(SearchHP.class);
	
	public SearchHP(){
		super();
	}
	/*
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("JSP/ViewFormParam.jsp").forward(request, response);
	}*/

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
		doPost(request, response);
		
		/*
		searchHP data = new searchHP();
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

		request.getRequestDispatcher(data).forward(request, response);*/
	}
	/**
	 * Handles the HTTP
	 * <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathogenvirus = request.getParameter("pathvirus");
		String pathogengenus = request.getParameter("pathgenus");
		String pathogenspecies = request.getParameter("pathspecies");
		String pathogensyn = request.getParameter("pathsyn");
		String hostfamily = request.getParameter("hfamily");
		String hostgenus = request.getParameter("hgenus");
		String hostspecies = request.getParameter("hspecies");
		String hostsyn = request.getParameter("hsyn");
		String country = request.getParameter("country");
		String provstate = request.getParameter("provstate");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = null;
		request.setAttribute(provstate, "provstate");
		request.setAttribute(country, "country");
		request.setAttribute(pathogenvirus, "pathvirus");
		request.setAttribute(pathogengenus, "pathgenus");
		request.setAttribute(pathogenspecies, "pathspecies");
		request.setAttribute(pathogensyn, "pathsyn");
		request.setAttribute(hostfamily, "hfamily");
		request.setAttribute(hostgenus, "hgenus");
		request.setAttribute(hostspecies, "hspecies");
		request.setAttribute(hostsyn, "hsyn");
		
		rd = request.getRequestDispatcher("/hpdb/eng/search");
		rd.forward(request, response);
		out.close();
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
	/*
	private void handleForm( HttpServletRequest req, HttpServletResponse res) { 
		GuestbookEntry entry = new GuestbookEntry(); 
		entry.name = req.getParameter(" name"); 
		entry.email = req.getParameter(" email"); 
		entry.comment = req.getParameter(" comment"); 
		entries.addElement( entry); // Make note we have a new last modified time 
		lastModified = System.currentTimeMillis();
	}
	
	public long getLastModified( HttpServletRequest req) { 
		return lastModified; 
	}*/
 
 
}