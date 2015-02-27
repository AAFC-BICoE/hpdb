package ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher;


public class HPLocalityJoin{
    public static String PK_LOCALITY_LINK_ID = "pk_locality_link_id";
    public static String FK_HOST_PATHOGEN_ID = "fk_host_pathogen_id";
    public static String FK_LOCATION_ID = "fk_location_id";

    private String hostPathogenId;
    private String locationId;

    public final String getHostPathogenId() {
	return hostPathogenId;
    }

    public final void setHostPathogenId(final String hostPathogenId) {
	this.hostPathogenId = hostPathogenId;
    }

    public final String getLocationId() {
	return locationId;
    }

    public final void setLocationId(final String locationId) {
	this.locationId = locationId;
    }

}
