package ca.gc.agr.mbb.hostpathogen.nouns;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HigherTaxa extends HasIdImpl {
	private String kingdom;
	private String division;
	private String clazz;
	private String order;
	private String family;

	public String getKingdom() {
		return kingdom;
	}
	public void setKingdom(final String kingdom) {
		this.kingdom = kingdom;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(final String division) {
		this.division = division;
	}
	public String getClazz() {
		return clazz;	
	}
	public void setClazz(final String clazz) {
		this.clazz = clazz;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(final String order) {
		this.order = order;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(final String family) {
		this.family = family;
	}
	
	@Override
	public String toString() {
		return "HigherTaxa [id=" + id + ", kingdom=" + kingdom + ", division="
				+ division + ", clazz=" + clazz + ", order=" + order
				+ ", family=" + family + ", getId()=" + getId()
				+ ", getKingdom()=" + getKingdom() + ", getDivision()="
				+ getDivision() + ", getClazz()=" + getClazz()
				+ ", getOrder()=" + getOrder() + ", getFamily()=" + getFamily()
				+ ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}	
}
