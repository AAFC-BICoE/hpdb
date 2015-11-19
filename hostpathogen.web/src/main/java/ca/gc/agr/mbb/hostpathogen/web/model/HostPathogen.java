package ca.gc.agr.mbb.hostpathogen.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

/**
 * The Class hostPathogen.
 */
@Entity
@Table(name = "hostPathogen")
@Indexed
@XmlRootElement
public class HostPathogen extends BaseObject implements Serializable {

	/* Columns from spreadsheet dump
	pk_host_pathogen_id	fk_reference_id	fk_host_id	fk_pathogen_id	
	rust_state	plant_part	symptom	notes	
	questionable_data	credibility_rating	verify	
	inserted_on	inserted_by	updated_on	updated_by
	 */
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2561031657343635571L;

	/** The id. */
	private Long id;
	
	/** The reference. */
	private Reference reference;
	
	/** The host. */
	private Host host;
	
	/** The pathogen. */
	private Pathogen pathogen;
		
	/** The rust state. */
	private String rustState;
	
	/** The plant part. */
	private String plantPart;
	
	/** The symptom. */
	private String symptom;
	
	/** The notes. */
	private String notes;
	
	/** The questionable data. */
	private String questionableData;
	
	/** The credibility rating. */
	private String credibilityRating;
	
	/** The locations. */
	private Set<Location> locations = new HashSet<Location>();
	
    /**
     * Default constructor - creates a new instance with no values set.
     */
    public HostPathogen() {
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
     * Gets the reference.
     *
     * @return the reference
     */
    @Embedded
    @IndexedEmbedded	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="reference")
	public Reference getReference() {
		return reference;
	}

	/**
	 * Sets the reference id.
	 *
	 * @param reference the reference to set
	 */
	public void setReference(Reference reference) {
		this.reference = reference;
	}

	/**
	 * Gets the host.
	 *
	 * @return the hostId
	 */
    @Embedded
    @IndexedEmbedded	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="host")
	public Host getHost() {
		return host;
	}

	/**
	 * Sets the host.
	 *
	 * @param hostId the hostId to set
	 */
	public void setHost(Host host) {
		this.host = host;
	}

	/**
	 * Gets the pathogen.
	 *
	 * @return the pathogenId
	 */
    @Embedded
    @IndexedEmbedded	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="pathogen")	
	public Pathogen getPathogen() {
		return pathogen;
	}

	/**
	 * Sets the pathogen.
	 *
	 * @param pathogenId the pathogenId to set
	 */
	public void setPathogen(Pathogen pathogen) {
		this.pathogen = pathogen;
	}

	/**
	 * Gets the rust state.
	 *
	 * @return the rustState
	 */
    @Column(length = 200)
    @Field
	public String getRustState() {
		return rustState;
	}

	/**
	 * Sets the rust state.
	 *
	 * @param rustState the rustState to set
	 */
	public void setRustState(String rustState) {
		this.rustState = rustState;
	}

	/**
	 * Gets the plant part.
	 *
	 * @return the plantPart
	 */
    @Column(length = 200)
    @Field
	public String getPlantPart() {
		return plantPart;
	}

	/**
	 * Sets the plant part.
	 *
	 * @param plantPart the plantPart to set
	 */
	public void setPlantPart(String plantPart) {
		this.plantPart = plantPart;
	}

	/**
	 * Gets the symptom.
	 *
	 * @return the symptom
	 */
    @Column(length = 200)
    @Field
	public String getSymptom() {
		return symptom;
	}

	/**
	 * Sets the symptom.
	 *
	 * @param symptom the symptom to set
	 */
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	/**
	 * Gets the questionable data.
	 *
	 * @return the questionableData
	 */
    @Column(length = 200)
    @Field
	public String getQuestionableData() {
		return questionableData;
	}

	/**
	 * Sets the questionable data.
	 *
	 * @param questionableData the questionableData to set
	 */
	public void setQuestionableData(String questionableData) {
		this.questionableData = questionableData;
	}

	/**
	 * Gets the credibility rating.
	 *
	 * @return the credibilityRating
	 */
    @Column(length = 200)
    @Field
	public String getCredibilityRating() {
		return credibilityRating;
	}

	/**
	 * Sets the credibility rating.
	 *
	 * @param credibilityRating the credibilityRating to set
	 */
	public void setCredibilityRating(String credibilityRating) {
		this.credibilityRating = credibilityRating;
	}

	/**
	 * Sets the notes.
	 *
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
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
	 * @return the locations
	 */
    @Embedded
    @IndexedEmbedded	
    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinTable(
            name = "hp_location_link",
            joinColumns = { @JoinColumn(name = "hp_id") },
            inverseJoinColumns = @JoinColumn(name = "location_id")
    )    
	public Set<Location> getLocations() {
		return locations;
	}
    
    /**
     * Convert user roles to LabelValue objects for convenience.
     *
     * @return a list of LabelValue objects with role information
     */
    @Transient
    public List<Location> getLocationList() {
        List<Location> returnLocations = new ArrayList<Location>();

        if (this.locations != null) {
            for (Location location : locations) {
                // convert the user's roles to LabelValue Objects
                returnLocations.add(location);
            }
        }

        return returnLocations;
    }
    
    /**
     * Adds a location for the user
     *
     * @param location the fully instantiated role
     */
    public void addLocation(Location location) {
        getLocations().add(location);
    }
    
    

	/**
	 * @param locations the locations to set
	 */
	public void setLocations(Set<Location> locations) {
		this.locations = locations;
	}

	/* (non-Javadoc)
	 * @see ca.gc.agr.mbb.hostPathogenpathogen.web.model.BaseObject#toString()
	 */
	@Override
	public String toString() {
		return null;
	}

	/* (non-Javadoc)
	 * @see ca.gc.agr.mbb.hostPathogenpathogen.web.model.BaseObject#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		return false;
	}

	/* (non-Javadoc)
	 * @see ca.gc.agr.mbb.hostPathogenpathogen.web.model.BaseObject#hashCode()
	 */
	@Override
	public int hashCode() {
		return 0;
	}

}