package ca.gc.agr.mbb.hostpathogen.nouns;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Reference extends HasIdImpl {
	private long sourceId;
	private long refSourcesId;
	private long higherTaxaId;
	private String author;
	private String year;
	private String title;
	private String volume;
	private String page;
	private String dataSource;

	public long getSourceId() {
		return sourceId;
	}
	public void setSourceId(final long sourceId) {
		this.sourceId = sourceId;
	}
	public long getRefSourcesId() {
		return refSourcesId;
	}
	public void setRefSourcesId(final long refSourcesId) {
		this.refSourcesId = refSourcesId;
	}
	public long getHigherTaxaId() {
		return higherTaxaId;
	}
	public void setHigherTaxaId(final long higherTaxaId) {
		this.higherTaxaId = higherTaxaId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(final String author) {
		this.author = author;
	}
	public String getYear() {
		return year;
	}
	public void setYear(final String year) {
		this.year = year;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(final String title) {
		this.title = title;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(final String volume) {
		this.volume = volume;
	}
	public String getPage() {
		return page;
	}
	public void setPage(final String page) {
		this.page = page;
	}
	public String getDataSource() {
		return dataSource;
	}
	public void setDataSource(final String dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public String toString() {
		return "Reference [id=" + id + ", sourceId=" + sourceId
				+ ", refSourcesId=" + refSourcesId + ", higherTaxaId="
				+ higherTaxaId + ", author=" + author + ", year=" + year
				+ ", title=" + title + ", volume=" + volume + ", page=" + page
				+ ", dataSource=" + dataSource + ", getId()=" + getId()
				+ ", getSourceId()=" + getSourceId() + ", getRefSourcesId()="
				+ getRefSourcesId() + ", getHigherTaxaId()="
				+ getHigherTaxaId() + ", getAuthor()=" + getAuthor()
				+ ", getYear()=" + getYear() + ", getTitle()=" + getTitle()
				+ ", getVolume()=" + getVolume() + ", getPage()=" + getPage()
				+ ", getDataSource()=" + getDataSource() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
}
