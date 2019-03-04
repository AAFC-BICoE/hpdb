package ca.gc.agr.mbb.hostpathogen.web.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

/**
 * The Class RefSource.
 */
@Entity
@Table(name = "refSource")
@Indexed
@XmlRootElement
public class RefSource extends BaseObject implements Serializable {

	/* Columns from spreadsheet dump
	pk_ref_source_id	journal_abbreviation	journal_title	book_editor	book_author	book_year	
	book_title	book_publisher	book_publisher_place	book_pages	verify

	 */
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1328290516770469912L;

	/** The id. */
	private Long id;
	
	/** The journal. */
	private String journal;
	
	/** The book_title. */
	private String bookTitle;
	
	/** The book_author. */
	private String bookAuthor;
	
	/** The book_pages. */
	private String bookPages;
	

    /**
     * Default constructor - creates a new instance with no values set.
     */
    public RefSource() {
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @DocumentId
    public Long getId() {
        return id;
    }

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

    /**
     * Gets the author.
     *
     * @return the author
     */
    @Column(length = 255)
    @Field
	public String getJournal() {
		return journal;
	}

	/**
	 * Sets the author.
	 *
	 * @param author the new author
	 */
	public void setJournal(String journal) {
		this.journal = journal;
	}


	/**
	 * @return the chapterArticleTitle
	 */
    @Column(length = 255)
    @Field
	public String getBookTitle() {
		return bookTitle;
	}

	/**
	 * @param chapterArticleTitle the chapterArticleTitle to set
	 */
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	/**
	 * @return the volume
	 */
    @Column(length = 255)
    @Field
	public String getBookAuthor() {
		return bookAuthor;
	}

	/**
	 * @param volume the volume to set
	 */
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	/**
	 * @return the pages
	 */
    @Column(length = 255)
    @Field
	public String getBookPages() {
		return bookPages;
	}

	/**
	 * @param pages the pages to set
	 */
	public void setBookPages(String bookPages) {
		this.bookPages = bookPages;
	}

	/* (non-Javadoc)
	 * @see ca.gc.agr.mbb.referencepathogen.web.model.BaseObject#toString()
	 */
	@Override
	public String toString() {
		return null;
	}

	/* (non-Javadoc)
	 * @see ca.gc.agr.mbb.referencepathogen.web.model.BaseObject#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		return false;
	}

	/* (non-Javadoc)
	 * @see ca.gc.agr.mbb.referencepathogen.web.model.BaseObject#hashCode()
	 */
	@Override
	public int hashCode() {
		return 0;
	}

}