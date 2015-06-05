package ca.gc.agr.mbb.hostpathogen.ws.ws;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.DefaultValue;
import javax.xml.bind.annotation.XmlRootElement;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher.HPSearcher;
import ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher.IllegalOffsetLimitException;
import ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher.IndexFailureException;
import ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher.InitializationException;
import ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher.LuceneConfig;
import ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher.SearcherDao;
import ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher.HPSearcher;
import ca.gc.agr.mbb.hostpathogen.nouns.Host;
import ca.gc.agr.mbb.hostpathogen.ws.Nouns;
import ca.gc.agr.mbb.hostpathogen.ws.WSConstants;

@Path(Nouns.HOSTS)
@XmlRootElement
public class HostWS implements Nouns, WSConstants{	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetHostsInit(
			@Context UriInfo uri,
			@DefaultValue(DEFAULT_PAGING_OFFSET_STRING) @QueryParam(PAGING_OFFSET_PARAMETER) Integer offset, 
			@DefaultValue(DEFAULT_PAGING_LIMIT_STRING) @QueryParam(PAGING_LIMIT_PARAMETER) Integer limit,
			@DefaultValue("") @QueryParam("families") String familyString,
			@DefaultValue("") @QueryParam("genus") String genusString, 
			@DefaultValue("") @QueryParam("species") String speciesString,
			@DefaultValue("") @QueryParam("countries") String countryString,
			@DefaultValue("true") @QueryParam("synonyms") String synonymString,
			@DefaultValue("") @QueryParam("sortFields") List<String> sortFieldString) throws JSONException, IllegalArgumentException, IllegalOffsetLimitException, IndexFailureException, InitializationException {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("offset", offset); 
		jsonObject.put("limit", limit);
		jsonObject.put("genus", genusString); 
		jsonObject.put("species", speciesString);
		jsonObject.put("families", familyString);
		jsonObject.put("countries", countryString);
		jsonObject.put("synonyms", synonymString);
		jsonObject.put("SortFields", sortFieldString);

		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		String pretJson = prettyGson.toJson(jsonObject);

		System.out.println(pretJson);

		//Testing cache control for 1 day
		CacheControl cc = new CacheControl();
		cc.setMaxAge(86400); 
		cc.setPrivate(true);

		if (limit - offset > DEFAULT_PAGING_LIMIT){
			System.out.println("Your request exceded the limit of 50!");
			return Response.status(400).build();    
			// }else if (){
			//return Response.status(304).header("If-Modified-Since", getTimeStamp())
		}else{
			return Response.status(200).entity(pretJson).cacheControl(cc).build();
		}
	}

	public static String TimeStamp(){
		return Calendar.getInstance().getTime().toString();
	}

	//======================Count for Search=============//
	@Path(Nouns.COUNT)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetCountHostsSearchQuery(
			@Context UriInfo uri,
			@DefaultValue(DEFAULT_PAGING_OFFSET_STRING) @QueryParam(PAGING_OFFSET_PARAMETER) Integer offset, 
			@DefaultValue(DEFAULT_PAGING_LIMIT_STRING) @QueryParam(PAGING_LIMIT_PARAMETER) Integer limit,
			@DefaultValue("") @QueryParam("families") String familyString,
			@DefaultValue("") @QueryParam("genus") String genusString, 
			@DefaultValue("") @QueryParam("species") String speciesString,
			@DefaultValue("") @QueryParam("sortFields") List<String> sortFieldString) throws JSONException {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("offset", offset); 
		jsonObject.put("limit", limit);
		jsonObject.put("Pathogens Genus", genusString); 
		jsonObject.put("Pathogens Species", speciesString);
		jsonObject.put("Pathogens Family", familyString);
		jsonObject.put("SortFields", sortFieldString);


		String result = "\n GET Hosts counts query: \n" + jsonObject;
		System.out.println(result);
		return Response.status(200).entity(result).build();
	}

	//===========GET host by Id==============//
	@Path(WSConstants.ID_VALID)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetHostsId(@PathParam(ID) final Long ID_VALID) throws JSONException, InitializationException, IllegalArgumentException, IndexFailureException {	
		/*@SuppressWarnings("rawtypes")
		SearcherDao sdao = new SearcherDao.getId(long id);
		HPSearcher<Host> host = new HPSearcher<Host>();*/

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", ID_VALID);  
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		String pretJson = prettyGson.toJson(jsonObject);
		System.out.println(pretJson);

		//Testing cache control for 1 day
		CacheControl cc = new CacheControl();
		cc.setMaxAge(86400); 
		cc.setPrivate(true);

		return Response.status(200).entity(pretJson).header("Access-Control-Allow-Headers", "X-extra-header")
				.allow("OPTIONS").build();
	}

	//===========GET host by Bad Id==============//
	@Path(WSConstants.ID_INVALID)
	@GET
	@Produces("application/json")
	public Response GetHostsNOTId(@PathParam(ID) String ID_INVALID) throws JSONException {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Hosts Bad ID", ID_INVALID); 

		System.out.println("\n GET Not HostsID: \n" + jsonObject);
		return Response.status(400).build();
	}

	//===========GET host by pathogen Id==============//
	@Path(WSConstants.ID_VALID + Nouns.PATHOGENS)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetHostsByPathogenId(@PathParam(ID) final String ID_VALID) throws JSONException {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("PathogenID", ID_VALID);  
		String result = "\n GET Hosts by PathogenID: \n" + jsonObject;
		System.out.println(result);
		return Response.status(200).entity(result).build();
	}

	//===========GET host by pathogen Bad Id==============//
	@Path(WSConstants.ID_INVALID + Nouns.PATHOGENS)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetHostsByPathogenBadId(@PathParam(ID) String ID_INVALID) throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Hosts Invalid ID", ID_INVALID); 
		String result = "\n GET Hosts Not PathogenID: \n" + jsonObject;
		System.out.println(result);
		return Response.status(400).entity(result).build();
	}
}