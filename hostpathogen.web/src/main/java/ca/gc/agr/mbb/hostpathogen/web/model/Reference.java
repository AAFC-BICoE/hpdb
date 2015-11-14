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

// TODO: Auto-generated Javadoc
/**
 * The Class Reference.
 */
@Entity
@Table(name = "reference")
@Indexed
@XmlRootElement
public class Reference extends BaseObject implements Serializable {

	/* Columns from spreadsheet dump
	pk_reference_id	fk_ref_source_id	reference_authors	reference_year	
	chapter_article_title	volume	pages	data_source	verify
	 */
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4712260638120605606L;
	
	/** The id. */
	private Long id;
	
	/** The ref source id. */
	private Long refSourceId;
	
	/** The author. */
	private String authors;
	
	/** The year. */
	private String year;
	
	/** The chapter article title. */
	private String chapterArticleTitle;
	
	/** The volume. */
	private String volume;
	
	/** The pages. */
	private String pages;
	
	/** The data_source. */
	private String data_source;

    /**
     * Default constructor - creates a new instance with no values set.
     */
    public Reference() {
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
    @Column(length = 200)
    @Field
	public String getAuthors() {
		return authors;
	}

	/**
	 * Sets the author.
	 *
	 * @param author the new author
	 */
	public void setAuthors(String author) {
		this.authors = author;
	}

	/**
	 * @return the refSourceId
	 */
	public Long getRefSourceId() {
		return refSourceId;
	}

	/**
	 * @param refSourceId the refSourceId to set
	 */
	public void setRefSourceId(Long refSourceId) {
		this.refSourceId = refSourceId;
	}

	/**
	 * @return the year
	 */
    @Column(length = 200)
    @Field
	public String getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * @return the chapterArticleTitle
	 */
    @Column(length = 200)
    @Field
	public String getChapterArticleTitle() {
		return chapterArticleTitle;
	}

	/**
	 * @param chapterArticleTitle the chapterArticleTitle to set
	 */
	public void setChapterArticleTitle(String chapterArticleTitle) {
		this.chapterArticleTitle = chapterArticleTitle;
	}

	/**
	 * @return the volume
	 */
    @Column(length = 200)
    @Field
	public String getVolume() {
		return volume;
	}

	/**
	 * @param volume the volume to set
	 */
	public void setVolume(String volume) {
		this.volume = volume;
	}

	/**
	 * @return the pages
	 */
    @Column(length = 200)
    @Field
	public String getPages() {
		return pages;
	}

	/**
	 * @param pages the pages to set
	 */
	public void setPages(String pages) {
		this.pages = pages;
	}

	/**
	 * @return the data_source
	 */
    @Column(length = 200)
    @Field
	public String getData_source() {
		return data_source;
	}

	/**
	 * @param data_source the data_source to set
	 */
	public void setData_source(String data_source) {
		this.data_source = data_source;
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