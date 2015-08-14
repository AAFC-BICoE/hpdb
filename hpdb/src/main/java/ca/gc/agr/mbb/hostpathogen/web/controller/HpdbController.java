package ca.gc.agr.mbb.hostpathogen.web.controller;

import java.io.IOException;
import java.util.Properties;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.gc.agr.mbb.hostpathogen.nouns.*;
import ca.gc.agr.mbb.hostpathogen.web.actions.*;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/hpdb"})
public class HpdbController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);

	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);	
		
		//execute the action
		if (action.equals("reset.action")){
			//Refresh the page
		}else if (action.equals("submit.action")){
			//instantiate action class
			Host host = new Host();
			host.setGenus("hostgenus");
			host.setSpecies("hostspecies");
			//host.getDetails();
			request.setAttribute("host", host);
		}
		//Foward to view
		String dispatchUrl = null;
		if(action.equals("")){
			dispatchUrl = "/pages/hpdbView.jsp";
		} else if(action.equals("reset")){
			dispatchUrl = "/pages/hpdbForm.jsp";
		}
		
		if (dispatchUrl != null){
			RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
			rd.forward(request, response);
		}
	}
}
