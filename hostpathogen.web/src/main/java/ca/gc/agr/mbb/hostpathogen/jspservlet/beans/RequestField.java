package ca.gc.agr.mbb.hostpathogen.jspservlet.beans;

public class RequestField {
	protected String pathogenGenus;
	protected String pathogenSpecies;
	protected String pathogenSynonym;
	protected String pathogenVirus;
	protected String hostGenus;
	protected String hostSpecies;
	protected String hostSynonym;
	protected String hostFamily;
	protected String country;
	protected String provinceStateTerritory;
	protected String search;
	protected String reset;
	
	public RequestField(){}
	
	public final String getPathogenGenus() {
		return pathogenGenus;
	}
	public final void setPathogenGenus(String pathogenGenus) {
		this.pathogenGenus = pathogenGenus;
	}
	public final String getPathogenSpecies() {
		return pathogenSpecies;
	}
	public final void setPathogenSpecies(String pathogenSpecies) {
		this.pathogenSpecies = pathogenSpecies;
	}
	public final String getPathogenSynonym() {
		return pathogenSynonym;
	}
	public final void setPathogenSynonym(String pathogenSynonym) {
		this.pathogenSynonym = pathogenSynonym;
	}
	public final String getPathogenVirus() {
		return pathogenVirus;
	}
	public final void setPathogenVirus(String pathogenVirus) {
		this.pathogenVirus = pathogenVirus;
	}
	public final String getHostGenus() {
		return hostGenus;
	}
	public final void setHostGenus(String hostGenus) {
		this.hostGenus = hostGenus;
	}
	public final String getHostSpecies() {
		return hostSpecies;
	}
	public final void setHostSpecies(String hostSpecies) {
		this.hostSpecies = hostSpecies;
	}
	public final String getHostSynonym() {
		return hostSynonym;
	}
	public final void setHostSynonym(String hostSynonym) {
		this.hostSynonym = hostSynonym;
	}
	public final String getHostFamily() {
		return hostFamily;
	}
	public final void setHostFamily(String hostFamily) {
		this.hostFamily = hostFamily;
	}
	public final String getCountry() {
		return country;
	}
	public final void setCountry(String country) {
		this.country = country;
	}
	public final String getProvinceStateTerritory() {
		return provinceStateTerritory;
	}
	public final void setProvinceStateTerritory(String provinceStateTerritory) {
		this.provinceStateTerritory = provinceStateTerritory;
	}
	public final String getSearch() {
		return search;
	}
	public final void setSearch(String search) {
		this.search = search;
	}
	public final String getReset() {
		return reset;
	}
	public final void setReset(String reset) {
		this.reset = reset;
	}
	public String execute() {  
		return "SUCCESS";  
	}  
	public String getDetail(){  
		return "SUCCESS";  
	}  
}
