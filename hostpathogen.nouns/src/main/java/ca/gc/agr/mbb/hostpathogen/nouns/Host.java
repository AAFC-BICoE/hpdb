package ca.gc.agr.mbb.hostpathogen.nouns;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Host extends Organism {
	private long higherTaxaId;
	private long idAccepted;
	private String genus;
	private String species;
	private String subSpecificTaxa;
	private String author;
	private String cultivar;
	private String enName;
	private String frName;
	private String notes;
	private long gbifId;

	public String getCultivar() {
		return cultivar;
	}
	public void setCultivar(final String cultivar) {
		this.cultivar = cultivar;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(final String notes) {
		this.notes = notes;
	}
	public long getGbifId() {
		return gbifId;
	}
	public void setGbifId(final long gbifId) {
		this.gbifId = gbifId;
	}

	@Override
	public String toString() {
		return "Host [id=" + id + ", higherTaxaId=" + higherTaxaId
				+ ", idAccepted=" + idAccepted + ", genus=" + genus
				+ ", species=" + species + ", subSpecificTaxa="
				+ subSpecificTaxa + ", author=" + author + ", cultivar="
				+ cultivar + ", enName=" + enName + ", frName=" + frName
				+ ", notes=" + notes + ", gbifId=" + gbifId + ", getId()="
				+ getId() + ", getHigherTaxaId()=" + getHigherTaxaId()
				+ ", getIdAccepted()=" + getIdAccepted() + ", getGenus()="
				+ getGenus() + ", getSpecies()=" + getSpecies()
				+ ", getSubSpecificTaxa()=" + getSubSpecificTaxa()
				+ ", getAuthor()=" + getAuthor() + ", getCultivar()="
				+ getCultivar() + ", getEnName()=" + getEnName()
				+ ", getFrName()=" + getFrName() + ", getNotes()=" + getNotes()
				+ ", getGbifId()=" + getGbifId() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
}
