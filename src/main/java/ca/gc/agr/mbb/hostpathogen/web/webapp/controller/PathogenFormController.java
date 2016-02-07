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
import ca.gc.agr.mbb.hostpathogen.web.service.HostPathogenManager;
import ca.gc.agr.mbb.hostpathogen.web.service.PathogenManager;

/**
 * @author bilkhus
 */
@Controller
@RequestMapping("/pathogenform*")
public class PathogenFormController extends BaseFormController {
	
    private PathogenManager pathogenManager;
    private HostPathogenManager hostPathogenManager;
	
    @Autowired
    public void setPathogenManager(final PathogenManager pathogenManager){
    	this.pathogenManager = pathogenManager;
    }
    
	public PathogenManager getPathogenManager() {
		return pathogenManager;
	}    
	
    @Autowired
	public void setHostPathogenManager(HostPathogenManager hostPathogenManager) {
		this.hostPathogenManager = hostPathogenManager;
	}
	
	public HostPathogenManager getHostPathogenManager() {
		return hostPathogenManager;
	}
	
	public List<Host> hostList = new ArrayList<Host>();
	
	/** The table id hosts list. */
	private String tableIdHostList = "hostList";
	
	/** The list columns hosts. */
	String[] listColumnsHosts = {"id", 
							     "genus", 
							     "species",
							     "subSpecificTaxa",
							     "cultivar", 
							     "enName",
							     "frName"
							     };
	
    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Pathogen showForm(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
    	final String pathogenId = request.getParameter("id");
        Pathogen ref =getPathogenManager().getPathogen(pathogenId);
        
        hostList = hostPathogenManager.getHostByPathogen(Long.parseLong(pathogenId));
		request.setAttribute("resultSize", hostList.size());
		request.setAttribute("hostList", hostList);
        
    	return ref;
    }

	/**
	 * @return the hostList
	 */
	public List<Host> getHostList() {
		return hostList;
	}

	/**
	 * @param hostList the hostList to set
	 */
	public void setHostList(List<Host> hostList) {
		this.hostList = hostList;
	}
    
}