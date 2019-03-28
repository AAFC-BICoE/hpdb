package ca.gc.agr.mbb.hostpathogen.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
 * @author bilkhus
 */
@Entity
@Table(name = "hostPathogen")
@Indexed
@XmlRootElement
public class HostPathogen extends BaseObject implements Serializable {

	/* Columns from spreadsheet dump
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
	
	/** The pathogen virus names. */
	private String pathogenVirusNames;
	
	/** The rust state. */
	private String rustState;
	
	/** The plant part. */
	private String plantPart;
	
	/** The symptom. */
	private String symptom;
	
	/** The notes. */
	private String notes;
	
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
    @Column(length = 255)
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
    @Column(length = 255)
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
    @Column(length = 255)
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
    @Column(length = 255)
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
	 * Gets the host genus.
	 *
	 * @return the hostGenus
	 */
    @Column(length = 255)
    @Field
	public String getHostGenus() {
		return hostGenus;
	}

	/**
	 * Sets the host genus.
	 *
	 * @param hostGenus the hostGenus to set
	 */
	public void setHostGenus(String hostGenus) {
		this.hostGenus = hostGenus;
	}

	/**
	 * Gets the host species.
	 *
	 * @return the hostSpecies
	 */
    @Column(length = 255)
    @Field
	public String getHostSpecies() {
		return hostSpecies;
	}

	/**
	 * Sets the host species.
	 *
	 * @param hostSpecies the hostSpecies to set
	 */
	public void setHostSpecies(String hostSpecies) {
		this.hostSpecies = hostSpecies;
	}

	/**
	 * Gets the host sub specific taxa.
	 *
	 * @return the hostSubSpecificTaxa
	 */
    @Column(length = 255)
    @Field
	public String getHostSubSpecificTaxa() {
		return hostSubSpecificTaxa;
	}

	/**
	 * Sets the host sub specific taxa.
	 *
	 * @param hostSubSpecificTaxa the hostSubSpecificTaxa to set
	 */
	public void setHostSubSpecificTaxa(String hostSubSpecificTaxa) {
		this.hostSubSpecificTaxa = hostSubSpecificTaxa;
	}

	/**
	 * Gets the pathogen genus.
	 *
	 * @return the pathogenGenus
	 */
    @Column(length = 255)
    @Field
	public String getPathogenGenus() {
		return pathogenGenus;
	}

	/**
	 * Sets the pathogen genus.
	 *
	 * @param pathogenGenus the pathogenGenus to set
	 */
	public void setPathogenGenus(String pathogenGenus) {
		this.pathogenGenus = pathogenGenus;
	}

	/**
	 * Gets the pathogen species.
	 *
	 * @return the pathogenSpecies
	 */
    @Column(length = 255)
    @Field
	public String getPathogenSpecies() {
		return pathogenSpecies;
	}

	/**
	 * Sets the pathogen species.
	 *
	 * @param pathogenSpecies the pathogenSpecies to set
	 */
	public void setPathogenSpecies(String pathogenSpecies) {
		this.pathogenSpecies = pathogenSpecies;
	}

	/**
	 * Gets the pathogen sub specific taxa.
	 *
	 * @return the pathogenSubSpecificTaxa
	 */
    @Column(length = 255)
    @Field
	public String getPathogenSubSpecificTaxa() {
		return pathogenSubSpecificTaxa;
	}

	/**
	 * Sets the pathogen sub specific taxa.
	 *
	 * @param pathogenSubSpecificTaxa the pathogenSubSpecificTaxa to set
	 */
	public void setPathogenSubSpecificTaxa(String pathogenSubSpecificTaxa) {
		this.pathogenSubSpecificTaxa = pathogenSubSpecificTaxa;
	}
	
	

	/**
	 * @return the pathogenVirusNames
	 */
    @Column(length = 500)
    @Field
	public String getPathogenVirusNames() {
		return pathogenVirusNames;
	}

	/**
	 * @param pathogenVirusNames the pathogenVirusNames to set
	 */
	public void setPathogenVirusNames(String pathogenVirusNames) {
		this.pathogenVirusNames = pathogenVirusNames;
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
    @Column(length = 255)
    @Field
	public String getNotes() {
		return notes;
	}
    
	/**
	 * Gets the locations.
	 *
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
    
    private class InterpretationComparator implements Comparator<Location> {
		@Override
		public int compare(Location o1, Location o2) {
			return o1.getInterpretation().compareTo(o2.getInterpretation());
		}
    }
    
    @Transient
    public String getLocationString() {
        StringBuilder locStr = new StringBuilder();

        int idx = 0;
        if (this.locations != null) {
        	ArrayList<Location> tmpLocations = new ArrayList<Location>();	
        	for (Location location : locations) {
        		tmpLocations.add(location);
        	}
        	
        	Collections.sort(tmpLocations, new InterpretationComparator());
        	
            for (Location location : tmpLocations) {
            	if(location.getCountry()!=null && location.getCountry().length()>0) {
            		locStr.append(location.getInterpretation()).append(" [").append(location.getCountry()).append("]");
            	}
                idx++;
                if(idx<tmpLocations.size()) {
                	locStr.append(", ");
                }
            }
        }

        return locStr.toString();
    }
    
    /**
     * Adds a location for the user.
     *
     * @param location the fully instantiated role
     */
    public void addLocation(Location location) {
        getLocations().add(location);
    }
    
    

	/**
	 * Sets the locations.
	 *
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