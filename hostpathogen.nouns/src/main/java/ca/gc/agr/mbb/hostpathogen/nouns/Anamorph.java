package ca.gc.agr.mbb.hostpathogen.nouns;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Anamorph extends HasIdImpl {
	private long anamorphId;
	private long synanamorphId;
	private long synanamorphId2;
	

	public long getAnamorphId() {
		return anamorphId;
	}
	public void setAnamorphId(final long anamorphId) {
		this.anamorphId = anamorphId;
	}
	public long getSynanamorphId() {
		return synanamorphId;
	}
	public void setSynanamorphId(final long synanamorphId) {
		this.synanamorphId = synanamorphId;
	}
	public long getSynanamorphId2() {
		return synanamorphId2;
	}
	public void setSynanamorphId2(final long synanamorphId2) {
		this.synanamorphId2 = synanamorphId2;
	}
	
	@Override
	public String toString() {
		return "Anamorph [id=" + id + ", anamorphId=" + anamorphId
				+ ", synanamorphId=" + synanamorphId + ", synanamorphId2="
				+ synanamorphId2 + ", getId()=" + getId()
				+ ", getAnamorphId()=" + getAnamorphId()
				+ ", getSynanamorphId()=" + getSynanamorphId()
				+ ", getSynanamorphId2()=" + getSynanamorphId2()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
