package ca.gc.agr.mbb.hostpathogen.nouns;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Pathogen extends Organism {
	private long higherTaxaId;
	private long idAccepted;
	private long anamorphId;
	private String virusMPLO;
	private String genus;
	private String species;
	private String subSpecificTaxa;
	private String author;
	private String fungalState;
	private String enName;
	private String enDiseaseNames;
	private String frName;
	private String frDiseaseNames;
	private String fullPathogen;
	private long gbifId;

	public long getAnamorphId() {
		return anamorphId;
	}
	public void setAnamorphId(final long anamorphId) {
		this.anamorphId = anamorphId;
	}
	public String getVirusMPLO() {
		return virusMPLO;
	}
	public void setVirusMPLO(final String virusMPLO) {
		this.virusMPLO = virusMPLO;
	}

	public String getFungalState() {
		return fungalState;
	}
	public void setFungalState(final String fungalState) {
		this.fungalState = fungalState;
	}
	public String getEnDiseaseNames() {
		return enDiseaseNames;
	}
	public void setEnDiseaseNames(final String enDiseaseNames) {
		this.enDiseaseNames = enDiseaseNames;
	}
	public String getFrDiseaseNames() {
		return frDiseaseNames;
	}
	public void setFrDiseaseNames(final String frDiseaseNames) {
		this.frDiseaseNames = frDiseaseNames;
	}
	public String getFullPathogen() {
		return fullPathogen;
	}
	public void setFullPathogen(final String fullPathogen) {
		this.fullPathogen = fullPathogen;
	}
	public long getGbifId() {
		return gbifId;
	}
	public void setGbifId(final long gbifId) {
		this.gbifId = gbifId;
	}
	
	@Override
	public String toString() {
		return "Pathogen [id=" + id + ", higherTaxaId=" + higherTaxaId
				+ ", idAccepted=" + idAccepted + ", anamorphId=" + anamorphId
				+ ", virusMPLO=" + virusMPLO + ", genus=" + genus
				+ ", species=" + species + ", subSpecificTaxa="
				+ subSpecificTaxa + ", author=" + author + ", fungalState="
				+ fungalState + ", enName=" + enName + ", enDiseaseNames="
				+ enDiseaseNames + ", frName=" + frName + ", frDiseaseNames="
				+ frDiseaseNames + ", fullPathogen=" + fullPathogen
				+ ", gbifId=" + gbifId + ", getId()=" + getId()
				+ ", getHigherTaxaId()=" + getHigherTaxaId()
				+ ", getIdAccepted()=" + getIdAccepted() + ", getAnamorphId()="
				+ getAnamorphId() + ", getVirusMPLO()=" + getVirusMPLO()
				+ ", getGenus()=" + getGenus() + ", getSpecies()="
				+ getSpecies() + ", getSubSpecificTaxa()="
				+ getSubSpecificTaxa() + ", getAuthor()=" + getAuthor()
				+ ", getFungalState()=" + getFungalState() + ", getEnName()="
				+ getEnName() + ", getEnDiseaseNames()=" + getEnDiseaseNames()
				+ ", getFrName()=" + getFrName() + ", getFrDiseaseNames()="
				+ getFrDiseaseNames() + ", getFullPathogen()="
				+ getFullPathogen() + ", getGbifId()=" + getGbifId()
				+ ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}
}