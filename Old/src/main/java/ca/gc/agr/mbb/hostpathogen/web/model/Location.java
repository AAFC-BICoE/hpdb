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
 * The Class Location.
 */
@Entity
@Table(name = "location")
@Indexed
@XmlRootElement
public class Location extends BaseObject implements Serializable {

	/* Columns from spreadsheet dump
		pk_location_id	geographical_abbreviation	interpretation	country	verify
	 */
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4598605539049397756L;

	/** The id. */
	private Long id;
	
	/** The geographical abbreviation. */
	private String geographicalAbbreviation;
	
	/** The interpretation. */
	private String interpretation;
	
	/** The country. */
	private String country;
	
    /**
     * Default constructor - creates a new instance with no values set.
     */
    public Location() {
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
     * Gets the geographical abbreviation.
     *
     * @return the geographicalAbbreviation
     */
    @Column(length = 10)
    @Field
	public String getGeographicalAbbreviation() {
		return geographicalAbbreviation;
	}

	/**
	 * Sets the geographical abbreviation.
	 *
	 * @param geographicalAbbreviation the geographicalAbbreviation to set
	 */
	public void setGeographicalAbbreviation(String geographicalAbbreviation) {
		this.geographicalAbbreviation = geographicalAbbreviation;
	}

	/**
	 * Gets the interpretation.
	 *
	 * @return the interpretation
	 */
    @Column(length = 255)
    @Field
	public String getInterpretation() {
		return interpretation;
	}

	/**
	 * Sets the interpretation.
	 *
	 * @param interpretation the interpretation to set
	 */
	public void setInterpretation(String interpretation) {
		this.interpretation = interpretation;
	}

	/**
	 * Gets the country.
	 *
	 * @return the country
	 */
    @Column(length = 255)
    @Field
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 *
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}


    /* (non-Javadoc)
	 * @see ca.gc.agr.mbb.locationpathogen.web.model.BaseObject#toString()
	 */
	@Override
	public String toString() {
		return null;
	}

	/* (non-Javadoc)
	 * @see ca.gc.agr.mbb.locationpathogen.web.model.BaseObject#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		return false;
	}

	/* (non-Javadoc)
	 * @see ca.gc.agr.mbb.locationpathogen.web.model.BaseObject#hashCode()
	 */
	@Override
	public int hashCode() {
		return 0;
	}

}