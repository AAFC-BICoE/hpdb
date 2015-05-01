package ca.gc.agr.mbb.hostpathogen.nouns;

abstract public class Organism extends HasIdImpl {
	private long higherTaxaId;
	private long idAccepted;
	private String genus;
	private String species;
	private String subSpecificTaxa;
	private String author;
	private String enName;
	private String frName;

	public long getHigherTaxaId() {
		return higherTaxaId;
	}
	public void setHigherTaxaId(final long higherTaxaId) {
		this.higherTaxaId = higherTaxaId;
	}
	public long getIdAccepted() {
		return idAccepted;
	}
	public void setIdAccepted(final long idAccepted) {
		this.idAccepted = idAccepted;
	}
	public String getGenus() {
		return genus;
	}
	public void setGenus(final String genus) {
		this.genus = genus;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(final String species) {
		this.species = species;
	}
	public String getSubSpecificTaxa() {
		return subSpecificTaxa;
	}
	public void setSubSpecificTaxa(final String subSpecificTaxa) {
		this.subSpecificTaxa = subSpecificTaxa;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(final String author) {
		this.author = author;
	}
	public String getEnName() {
		return enName;
	}
	public void setEnName(final String enName) {
		this.enName = enName;
	}
	public String getFrName() {
		return frName;
	}
	public void setFrName(final String frName) {
		this.frName = frName;
	}
	
	@Override
	public String toString() {
		return "Organism [id=" + id + ", higherTaxaId=" + higherTaxaId
				+ ", idAccepted=" + idAccepted + ", genus=" + genus
				+ ", species=" + species + ", subSpecificTaxa="
				+ subSpecificTaxa + ", author=" + author + ", enName=" + enName
				+ ", frName=" + frName + ", getId()=" + getId()
				+ ", getHigherTaxaId()=" + getHigherTaxaId()
				+ ", getIdAccepted()=" + getIdAccepted() + ", getGenus()="
				+ getGenus() + ", getSpecies()=" + getSpecies()
				+ ", getSubSpecificTaxa()=" + getSubSpecificTaxa()
				+ ", getAuthor()=" + getAuthor() + ", getEnName()="
				+ getEnName() + ", getFrName()=" + getFrName()
				+ ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}
}
