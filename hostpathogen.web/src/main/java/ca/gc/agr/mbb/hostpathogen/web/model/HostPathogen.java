package ca.gc.agr.mbb.hostpathogen.web.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

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
	
	/** The host. */
	private Host host;
	
	/** The pathogen. */
	private Pathogen pathogen;
	
	/** The reference. */
	private Reference reference;
	
	/** The family. */
	private String hostFamily;
	
	/** The host genus. */
	private String hostGenus;
	
	/** The host species. */
	private String hostSpecies;
	
	/** The host sub specific taxa. */
	private String hostSubSpecificTaxa;
	
	/** The pathogen genus. */
	private String pathogenGenus;
	
	/** The pathogen species. */
	private String pathogenSpecies;
	
	/** The pathogen sub specific taxa. */
	private String pathogenSubSpecificTaxa;
	
	/** The country. */
	private String country;
	
	/** The Locality. */
	private String locality;
		
	/** The rust state. */
	private String rustState;
	
	/** The plant part. */
	private String plantPart;
	
	/** The symptom. */
	private String symptom;
	
	/** The notes. */
	private String notes;
	
//	/** The locations. */
//	private Set<Location> locations = new HashSet<Location>();
	
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
	 * @param host the new host
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
	 * @param pathogen the new pathogen
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
	 * Gets the hostFamily.
	 *
	 * @return the hostFamily
	 */
    @Column(length = 200)
    @Field
	public String getHostFamily() {
		return hostFamily;
	}

	/**
	 * Sets the family.
	 *
	 * @param hostFamily the family to set
	 */
	public void setHostFamily(String hostFamily) {
		this.hostFamily = hostFamily;
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
	 * Gets the country.
	 *
	 * @return the country
	 */
    @Column(length = 200)
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
	 * @return the hostGenus
	 */
    @Column(length = 200)
    @Field
	public String getHostGenus() {
		return hostGenus;
	}

	/**
	 * @param hostGenus the hostGenus to set
	 */
	public void setHostGenus(String hostGenus) {
		this.hostGenus = hostGenus;
	}

	/**
	 * @return the hostSpecies
	 */
    @Column(length = 200)
    @Field
	public String getHostSpecies() {
		return hostSpecies;
	}

	/**
	 * @param hostSpecies the hostSpecies to set
	 */
	public void setHostSpecies(String hostSpecies) {
		this.hostSpecies = hostSpecies;
	}

	/**
	 * @return the hostSubSpecificTaxa
	 */
    @Column(length = 200)
    @Field
	public String getHostSubSpecificTaxa() {
		return hostSubSpecificTaxa;
	}

	/**
	 * @param hostSubSpecificTaxa the hostSubSpecificTaxa to set
	 */
	public void setHostSubSpecificTaxa(String hostSubSpecificTaxa) {
		this.hostSubSpecificTaxa = hostSubSpecificTaxa;
	}

	/**
	 * @return the pathogenGenus
	 */
    @Column(length = 200)
    @Field
	public String getPathogenGenus() {
		return pathogenGenus;
	}

	/**
	 * @param pathogenGenus the pathogenGenus to set
	 */
	public void setPathogenGenus(String pathogenGenus) {
		this.pathogenGenus = pathogenGenus;
	}

	/**
	 * @return the pathogenSpecies
	 */
    @Column(length = 200)
    @Field
	public String getPathogenSpecies() {
		return pathogenSpecies;
	}

	/**
	 * @param pathogenSpecies the pathogenSpecies to set
	 */
	public void setPathogenSpecies(String pathogenSpecies) {
		this.pathogenSpecies = pathogenSpecies;
	}

	/**
	 * @return the pathogenSubSpecificTaxa
	 */
    @Column(length = 200)
    @Field
	public String getPathogenSubSpecificTaxa() {
		return pathogenSubSpecificTaxa;
	}

	/**
	 * @param pathogenSubSpecificTaxa the pathogenSubSpecificTaxa to set
	 */
	public void setPathogenSubSpecificTaxa(String pathogenSubSpecificTaxa) {
		this.pathogenSubSpecificTaxa = pathogenSubSpecificTaxa;
	}

	/**
	 * @return the locality
	 */
    @Column(length = 200)
    @Field
	public String getLocality() {
		return locality;
	}

	/**
	 * @param locality the locality to set
	 */
	public void setLocality(String locality) {
		this.locality = locality;
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
    
//	/**
//	 * @return the locations
//	 */
//    @Embedded
//    @IndexedEmbedded	
//    @ManyToMany(fetch = FetchType.EAGER)
//    @Fetch(FetchMode.SELECT)
//    @JoinTable(
//            name = "hp_location_link",
//            joinColumns = { @JoinColumn(name = "hp_id") },
//            inverseJoinColumns = @JoinColumn(name = "location_id")
//    )    
//	public Set<Location> getLocations() {
//		return locations;
//	}
//    
//    /**
//     * Convert user roles to LabelValue objects for convenience.
//     *
//     * @return a list of LabelValue objects with role information
//     */
//    @Transient
//    public List<Location> getLocationList() {
//        List<Location> returnLocations = new ArrayList<Location>();
//
//        if (this.locations != null) {
//            for (Location location : locations) {
//                // convert the user's roles to LabelValue Objects
//                returnLocations.add(location);
//            }
//        }
//
//        return returnLocations;
//    }
//    
//    /**
//     * Adds a location for the user
//     *
//     * @param location the fully instantiated role
//     */
//    public void addLocation(Location location) {
//        getLocations().add(location);
//    }
//    
//    
//
//	/**
//	 * @param locations the locations to set
//	 */
//	public void setLocations(Set<Location> locations) {
//		this.locations = locations;
//	}

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