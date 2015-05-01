package ca.gc.agr.mbb.hostpathogen.nouns;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Author extends HasIdImpl {
	private String authorLookup;

	public String getAuthorLookup() {
		return authorLookup;
	}

	public void setAuthorLookup(final String authorLookup) {
		this.authorLookup = authorLookup;
	}

	@Override
	public String toString() {
		return "Author [authorLookup=" + authorLookup + ", id=" + id
				+ ", getAuthorLookup()=" + getAuthorLookup() + ", getId()="
				+ getId() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
	
	

}
