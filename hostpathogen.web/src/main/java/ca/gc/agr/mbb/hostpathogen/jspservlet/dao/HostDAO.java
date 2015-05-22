package ca.gc.agr.mbb.hostpathogen.jspservlet.dao;

import ca.gc.agr.mbb.hostpathogen.nouns.Host;

public class HostDAO extends Host {
	protected String family;
	protected String genus;
	protected String species;
	protected String synonym;
	
	public String execute(){
		return "sucess";
	}
}
