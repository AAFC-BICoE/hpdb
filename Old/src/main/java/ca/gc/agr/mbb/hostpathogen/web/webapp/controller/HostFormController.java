package ca.gc.agr.mbb.hostpathogen.web.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.gc.agr.mbb.hostpathogen.web.model.Host;
import ca.gc.agr.mbb.hostpathogen.web.model.Pathogen;
import ca.gc.agr.mbb.hostpathogen.web.service.HostManager;
import ca.gc.agr.mbb.hostpathogen.web.service.HostPathogenManager;

/**
 * @author bilkhus
 */
@Controller
@RequestMapping("/hostform*")
public class HostFormController extends BaseFormController {
	
    private HostManager hostManager;
    private HostPathogenManager hostPathogenManager;
	
    @Autowired
    public void setHostManager(final HostManager hostManager){
    	this.hostManager = hostManager;
    }
    
	public HostManager getHostManager() {
		return hostManager;
	}    
	
    @Autowired
	public void setHostPathogenManager(HostPathogenManager hostPathogenManager) {
		this.hostPathogenManager = hostPathogenManager;
	}
	
	public HostPathogenManager getHostPathogenManager() {
		return hostPathogenManager;
	}
	
	public List<Pathogen> pathogenList = new ArrayList<Pathogen>();

	/** The table id pathogen list. */
	private String tableIdPathogenList = "pathogenList";
	
	/** The list columns pathogen. */
	String[] listColumnsPathogens = {"id", 
								     "genus", 
								     "species",
								     "subSpecificTaxa",
								     "virusNames",
								     "enName",
								     "frName",
								     "fungalState"
								     };
	
    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Host showForm(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
    	final String hostId = request.getParameter("id");
        Host ref =getHostManager().getHost(hostId);
        
		pathogenList = hostPathogenManager.getPathogenByHost(Long.parseLong(hostId));
		request.setAttribute("resultSize", pathogenList.size());
		request.setAttribute("pathogenList", pathogenList);
        
    	return ref;
    }

	/**
	 * @return the pathogenList
	 */
	public List<Pathogen> getPathogenList() {
		return pathogenList;
	}

	/**
	 * @param pathogenList the pathogenList to set
	 */
	public void setPathogenList(List<Pathogen> pathogenList) {
		this.pathogenList = pathogenList;
	}

}