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
 * The Class Host.
 */
@Entity
@Table(name = "host")
@Indexed
@XmlRootElement
public class Host extends BaseObject implements Serializable {

	/* Columns from spreadsheet dump
	pk_host_id	fk_higher_taxa_id	fk_host_id_accepted	
	host_genus	host_species	host_subspecific_taxa	host_author	
	cultivar	english_name	french_name	host_notes	verify	QD
	 */
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4712260638120605606L;
	
	/** The id. */
	private Long id;
	
	/** The higher taxa id. */
	private Long higherTaxaId;
	
	/** The id accepted. */
	private Long idAccepted;
	
	/** The genus. */
	private String genus;
	
	/** The species. */
	private String species;
	
	/** The sub specific taxa. */
	private String subSpecificTaxa;
	
	/** The author. */
	private String author;
	
	/** The cultivar. */
	private String cultivar;
	
	/** The en name. */
	private String enName;
	
	/** The fr name. */
	private String frName;
	
	/** The notes. */
	private String notes;
	
	/** The gbif id. */
	private Long gbifId;

    /**
     * Default constructor - creates a new instance with no values set.
     */
    public Host() {
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

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the higher taxa id.
	 *
	 * @return the higher taxa id
	 */
	public Long getHigherTaxaId() {
		return higherTaxaId;
	}

	/**
	 * Sets the higher taxa id.
	 *
	 * @param higherTaxaId the new higher taxa id
	 */
	public void setHigherTaxaId(Long higherTaxaId) {
		this.higherTaxaId = higherTaxaId;
	}

	/**
	 * Gets the id accepted.
	 *
	 * @return the id accepted
	 */
	public Long getIdAccepted() {
		return idAccepted;
	}

	/**
	 * Sets the id accepted.
	 *
	 * @param idAccepted the new id accepted
	 */
	public void setIdAccepted(Long idAccepted) {
		this.idAccepted = idAccepted;
	}

    /**
     * Gets the genus.
     *
     * @return the genus
     */
    @Column(length = 200)
    @Field
	public String getGenus() {
		return genus;
	}

	/**
	 * Sets the genus.
	 *
	 * @param genus the new genus
	 */
	public void setGenus(String genus) {
		this.genus = genus;
	}

    /**
     * Gets the species.
     *
     * @return the species
     */
    @Column(length = 200)
    @Field
	public String getSpecies() {
		return species;
	}

	/**
	 * Sets the species.
	 *
	 * @param species the new species
	 */
	public void setSpecies(String species) {
		this.species = species;
	}

    /**
     * Gets the sub specific taxa.
     *
     * @return the sub specific taxa
     */
    @Column(length = 200)
    @Field
	public String getSubSpecificTaxa() {
		return subSpecificTaxa;
	}

	/**
	 * Sets the sub specific taxa.
	 *
	 * @param subSpecificTaxa the new sub specific taxa
	 */
	public void setSubSpecificTaxa(String subSpecificTaxa) {
		this.subSpecificTaxa = subSpecificTaxa;
	}

    /**
     * Gets the author.
     *
     * @return the author
     */
    @Column(length = 200)
    @Field
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets the author.
	 *
	 * @param author the new author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

    /**
     * Gets the cultivar.
     *
     * @return the cultivar
     */
    @Column(length = 200)
    @Field
	public String getCultivar() {
		return cultivar;
	}

	/**
	 * Sets the cultivar.
	 *
	 * @param cultivar the new cultivar
	 */
	public void setCultivar(String cultivar) {
		this.cultivar = cultivar;
	}

    /**
     * Gets the en name.
     *
     * @return the en name
     */
    @Column(length = 200)
    @Field
	public String getEnName() {
		return enName;
	}

    /**
     * Sets the en name.
     *
     * @param enName the new en name
     */
    @Column(length = 200)
    @Field
	public void setEnName(String enName) {
		this.enName = enName;
	}

    /**
     * Gets the fr name.
     *
     * @return the fr name
     */
    @Column(length = 200)
    @Field
	public String getFrName() {
		return frName;
	}

    /**
     * Sets the fr name.
     *
     * @param frName the new fr name
     */
    @Column(length = 200)
    @Field
	public void setFrName(String frName) {
		this.frName = frName;
	}

    /**
     * Gets the notes.
     *
     * @return the notes
     */
    @Column(length = 200)
    @Field
	public String getNotes() {
		return notes;
	}

	/**
	 * Sets the notes.
	 *
	 * @param notes the new notes
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * Gets the gbif id.
	 *
	 * @return the gbif id
	 */
	public Long getGbifId() {
		return gbifId;
	}

	/**
	 * Sets the gbif id.
	 *
	 * @param gbifId the new gbif id
	 */
	public void setGbifId(Long gbifId) {
		this.gbifId = gbifId;
	}

	/* (non-Javadoc)
	 * @see ca.gc.agr.mbb.hostpathogen.web.model.BaseObject#toString()
	 */
	@Override
	public String toString() {
		return null;
	}

	/* (non-Javadoc)
	 * @see ca.gc.agr.mbb.hostpathogen.web.model.BaseObject#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		return false;
	}

	/* (non-Javadoc)
	 * @see ca.gc.agr.mbb.hostpathogen.web.model.BaseObject#hashCode()
	 */
	@Override
	public int hashCode() {
		return 0;
	}

}