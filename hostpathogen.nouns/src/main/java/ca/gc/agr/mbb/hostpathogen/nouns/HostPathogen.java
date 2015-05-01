package ca.gc.agr.mbb.hostpathogen.nouns;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HostPathogen extends HasIdImpl {
	private long referenceId;
	private long hostId;
	private long pathogenId;
	private String rustState;
	private String plantPart;
	private String symptom;
	private String notes;

	public long getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(final long referenceId) {
		this.referenceId = referenceId;
	}
	public long getHostId() {
		return hostId;
	}
	public void setHostId(final long hostId) {
		this.hostId = hostId;
	}
	public long getPathogenId() {
		return pathogenId;
	}
	public void setPathogenId(final long pathogenId) {
		this.pathogenId = pathogenId;
	}
	public String getRustState() {
		return rustState;
	}
	public void setRustState(final String rustState) {
		this.rustState = rustState;
	}
	public String getPlantPart() {
		return plantPart;
	}
	public void setPlantPart(final String plantPart) {
		this.plantPart = plantPart;
	}
	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(final String symptom) {
		this.symptom = symptom;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(final String notes) {
		this.notes = notes;
	}
	
	@Override
	public String toString() {
		return "HostPathogen [id=" + id + ", referenceId=" + referenceId
				+ ", hostId=" + hostId + ", pathogenId=" + pathogenId
				+ ", rustState=" + rustState + ", plantPart=" + plantPart
				+ ", symptom=" + symptom + ", notes=" + notes + ", getId()="
				+ getId() + ", getReferenceId()=" + getReferenceId()
				+ ", getHostId()=" + getHostId() + ", getPathogenId()="
				+ getPathogenId() + ", getRustState()=" + getRustState()
				+ ", getPlantPart()=" + getPlantPart() + ", getSymptom()="
				+ getSymptom() + ", getNotes()=" + getNotes() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}	
}