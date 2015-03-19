package ca.gc.agr.mbb.hostpathogen.jspservlet.dao;

public class Host {
	protected String family;
	protected String genus;
	protected String species;
	protected String synonym;
	
	public Host(String family, String genus, String species, String synonym){
		this.family = family;
		this.genus = genus;
		this.species = species;
		this.synonym = synonym;
	}
	public final String getFamily() {
		return family;
	}
	public final void setFamily(String family) {
		this.family = family;
	}
	public final String getGenus() {
		return genus;
	}
	public final void setGenus(String genus) {
		this.genus = genus;
	}
	public final String getSpecies() {
		return species;
	}
	public final void setSpecies(String species) {
		this.species = species;
	}
	public final String getSynonym() {
		return synonym;
	}
	public final void setSynonym(String synonym) {
		this.synonym = synonym;
	}
}
