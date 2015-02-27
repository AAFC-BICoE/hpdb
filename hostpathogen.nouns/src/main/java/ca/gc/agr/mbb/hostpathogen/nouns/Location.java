package ca.gc.agr.mbb.hostpathogen.nouns;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Location extends HasIdImpl {
	private String provinceStateTerritory;
	private String country;
	
	public String getProvinceStateTerritory() {
		return provinceStateTerritory;
	}
	public void setProvinceStateTerritory(final String provinceStateTerritory) {
		this.provinceStateTerritory = provinceStateTerritory;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(final String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "Location [id=" + id + ", provinceStateTerritory="
				+ provinceStateTerritory + ", country=" + country
				+ ", getId()=" + getId() + ", getProvinceStateTerritory()="
				+ getProvinceStateTerritory() + ", getCountry()="
				+ getCountry() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
}	