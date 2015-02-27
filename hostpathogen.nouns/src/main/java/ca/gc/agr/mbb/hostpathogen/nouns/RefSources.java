package ca.gc.agr.mbb.hostpathogen.nouns;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RefSources extends HasIdImpl {
	private long referenceId;
	private String journal;
	private String title;
	private String journalTitleAbbreviation;
	private String editor;
	private String author;
	private String year;
	private String journalTitle;
	private String publisher;
	private String publisherPlace;
	private String pages;


	public long getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(final long referenceId) {
		this.referenceId = referenceId;
	}
	public String getJournal() {
		return journal;
	}
	public void setJournal(final String journal) {
		this.journal = journal;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(final String title) {
		this.title = title;
	}
	public String getJournalTitleAbbreviation() {
		return journalTitleAbbreviation;
	}
	public void setJournalTitleAbbreviation(final String journalTitleAbbreviation) {
		this.journalTitleAbbreviation = journalTitleAbbreviation;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(final String editor) {
		this.editor = editor;
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
	public String getJournalTitle() {
		return journalTitle;
	}
	public void setJournalTitle(final String journalTitle) {
		this.journalTitle = journalTitle;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(final String publisher) {
		this.publisher = publisher;
	}
	public String getPublisherPlace() {
		return publisherPlace;
	}
	public void setPublisherPlace(final String publisherPlace) {
		this.publisherPlace = publisherPlace;
	}
	public String getPages() {
		return pages;
	}
	public void setPages(final String pages) {
		this.pages = pages;
	}
	
	@Override
	public String toString() {
		return "RefSources [referenceId=" + referenceId + ", journal="
				+ journal + ", title=" + title + ", journalTitleAbbreviation="
				+ journalTitleAbbreviation + ", editor=" + editor + ", author="
				+ author + ", year=" + year + ", journalTitle=" + journalTitle
				+ ", publisher=" + publisher + ", publisherPlace="
				+ publisherPlace + ", pages=" + pages + ", id=" + id
				+ ", getReferenceId()=" + getReferenceId() + ", getJournal()="
				+ getJournal() + ", getTitle()=" + getTitle()
				+ ", getJournalTitleAbbreviation()="
				+ getJournalTitleAbbreviation() + ", getEditor()="
				+ getEditor() + ", getAuthor()=" + getAuthor() + ", getYear()="
				+ getYear() + ", getJournalTitle()=" + getJournalTitle()
				+ ", getPublisher()=" + getPublisher()
				+ ", getPublisherPlace()=" + getPublisherPlace()
				+ ", getPages()=" + getPages() + ", getId()=" + getId()
				+ ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}
}