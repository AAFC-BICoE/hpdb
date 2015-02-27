package ca.gc.agr.mbb.hostpathogen.ws.loader;

import java.util.Properties;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.UUID;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Calendar;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.json.JSONException;

import ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher.HPSearcher;
import ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher.IllegalOffsetLimitException;
import ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher.IndexFailureException;
import ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher.InitializationException;
import ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher.LuceneConfig;
import ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher.SearcherDao;
import ca.gc.agr.mbb.hostpathogen.ws.Load;


public class Host extends Load{

	static LuceneConfig hostConfig;
	static LuceneConfig pathogenConfig;
	static LuceneConfig hostPathogenConfig;

	public static long id = 1;

	public static Host getId() throws InitializationException, IllegalArgumentException, IndexFailureException, IllegalOffsetLimitException{
		SearcherDao<Host> hps = new HPSearcher<Host>(Host.class);
		hps.init(hostConfig);
		List<Long> all = hps.getAll(1,10);
		Host host = hps.get(all.get(0));
		System.out.println(host);
		return host;
	}

	/*
	 * 
	 * 	static LuceneConfig hostConfig;
	static LuceneConfig pathogenConfig;
	static LuceneConfig hostPathogenConfig;

	@Context
	UriInfo uriInfo;
	@Path(WSConstants.ID_VALID)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Host getHostId(@PathParam(ID) final Long ID_VALID) throws JSONException, InitializationException, IllegalArgumentException, IndexFailureException {
		String genus = null;
		String species = null;
		String author = null;
		String subSpecificTaxa = null;

		SearcherDao<Host> hps = new HPSearcher<Host>(Host.class);
		hps.init(hostConfig);
		Host host = hps.get(ID_VALID);

		host.setId(ID_VALID);
		host.setGenus(genus);
		host.setSpecies(species);
		host.setSubSpecificTaxa(subSpecificTaxa);
		host.setAuthor(author);
		System.out.println(host);
		return host;
		}
}
	 */

}
