package ca.gc.agr.mbb.hostpathogen.jspservlet.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ca.gc.agr.mbb.hostpathogen.jspservlet.dao.RequestFormData;
import ca.gc.agr.mbb.hostpathogen.nouns.Pathogen;

@SuppressWarnings("serial")
@WebServlet(name = "HostPathogenWeb", urlPatterns = {"/hpdb/eng/"})
public class HostPathogenServlet extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("JSP/HPDB_Form.jsp").forward(request, response);
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
<<<<<<< HEAD
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

		request.getRequestDispatcher(data).forward(request, response);
=======
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		try {
			URL url = new URL("http://localhost:8080/hpdb/eng/");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
			request.getRequestDispatcher("JSP/HPDB_FormResults.jsp").forward(request, response);
			conn.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		}
>>>>>>> f90cb5809dbb32f3fe61e78d632de4b19737c2c1
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