package ca.gc.agr.mbb.hostpathogen.ws.ws;

import java.util.List;
import java.util.Properties;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
import ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher.LuceneFields;
import ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher.SearcherDao;
import ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher.UtilLucene;
import ca.gc.agr.mbb.hostpathogen.nouns.Host;
import ca.gc.agr.mbb.hostpathogen.nouns.HostPathogen;
import ca.gc.agr.mbb.hostpathogen.ws.Nouns;
import ca.gc.agr.mbb.hostpathogen.ws.WSConstants;


@Path(Nouns.HOSTPATHOGENS)
@XmlRootElement
public class HostPathogenWS implements Nouns, WSConstants{
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetHostPathInit(
			@Context UriInfo uri,
			@DefaultValue(DEFAULT_PAGING_OFFSET_STRING) @QueryParam(PAGING_OFFSET_PARAMETER) Integer offset, 
			@DefaultValue(DEFAULT_PAGING_LIMIT_STRING) @QueryParam(PAGING_LIMIT_PARAMETER) Integer limit,
			@DefaultValue("") @QueryParam("locations") String locationsString, 
			@DefaultValue("") @QueryParam("countries") String countriesString,
			@DefaultValue("") @QueryParam("sortFields") List<String> sortFieldsString) throws JSONException, InitializationException, IllegalArgumentException, IndexFailureException, IllegalOffsetLimitException {

		System.out.println("GetALlHostPathogensWithOffsetLimit");
		System.out.println("[Offset=" + offset + ", limit=" + limit + "]");

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("offset", offset); 
		jsonObject.put("limit", limit);
		jsonObject.put("locations", locationsString); 
		jsonObject.put("countries", countriesString);
		jsonObject.put("Sort Fields", sortFieldsString);

		String result = "\n GET Host-Pathogens offset and limit: \n" + jsonObject;
		System.out.println(result);

		if (limit - offset > DEFAULT_PAGING_LIMIT){
			System.out.println("Your request exceded the limit of 50!");
			return Response.status(400).build();     
		}else{
			return Response.status(200).entity(result).build();
		}
	}

	@Path(Nouns.HOSTS)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetHostPathSearchByHost(
			@Context UriInfo uri,
			@DefaultValue(DEFAULT_PAGING_OFFSET_STRING) @QueryParam(PAGING_OFFSET_PARAMETER) Integer offset, 
			@DefaultValue(DEFAULT_PAGING_LIMIT_STRING) @QueryParam(PAGING_LIMIT_PARAMETER) Integer limit,
			@DefaultValue("") @QueryParam("genus") String genusString, 
			@DefaultValue("") @QueryParam("species") String speciesString,
			@DefaultValue("") @QueryParam("families") String familyString,
			@DefaultValue("true") @QueryParam("synonyms") String synonymsString,
			@DefaultValue("") @QueryParam("sortFields") List<String> sortFieldsString) throws JSONException {

		System.out.println("GetALlHostPathogensByHostSearch");
		System.out.println("[Offset=" + offset + ", limit=" + limit + "host [genus=" + genusString + ", species=" + speciesString + "]");

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("offset", offset); 
		jsonObject.put("limit", limit);
		jsonObject.put("hosts Genus", genusString); 
		jsonObject.put("hosts Species", speciesString);
		jsonObject.put("hosts families", familyString);
		jsonObject.put("synonyms", synonymsString);
		jsonObject.put("Sort Fields", sortFieldsString);

		String result = "\n GET Host-Pathogens by hosts search: \n" + jsonObject;
		System.out.println(result);
		if (limit - offset > DEFAULT_PAGING_LIMIT){
			System.out.println("Your request exceded the limit of 50!");
			return Response.status(400).build();     
		}else{
			return Response.status(200).entity(result).build();
		}
	}

	@Path(Nouns.PATHOGENS)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetHostPathSearchByPathogens(
			@Context UriInfo uri,
			@DefaultValue(DEFAULT_PAGING_OFFSET_STRING) @QueryParam(PAGING_OFFSET_PARAMETER) Integer offset, 
			@DefaultValue(DEFAULT_PAGING_LIMIT_STRING) @QueryParam(PAGING_LIMIT_PARAMETER) Integer limit,
			@DefaultValue("") @QueryParam("genus") String genusString, 
			@DefaultValue("") @QueryParam("species") String speciesString,
			@DefaultValue("") @QueryParam("virus") String virusString,
			@DefaultValue("true") @QueryParam("synonyms") String synonymsString,
			@DefaultValue("") @QueryParam("sortFields") List<String> sortFieldsString) throws JSONException {

		System.out.println("GetALlHostPathogensByHostSearch");
		System.out.println("[Offset=" + offset + ", limit=" + limit + "host [genus=" + genusString + ", species=" + speciesString + "]");

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("offset", offset); 
		jsonObject.put("limit", limit);
		jsonObject.put("hosts Genus", genusString); 
		jsonObject.put("hosts Species", speciesString);
		jsonObject.put("hosts families", virusString);
		jsonObject.put("synonyms", synonymsString);
		jsonObject.put("Sort Fields", sortFieldsString);

		String result = "\n GET Host-Pathogens by hosts search: \n" + jsonObject;
		System.out.println(result);
		if (limit - offset > DEFAULT_PAGING_LIMIT){
			System.out.println("Your request exceded the limit of 50!");
			return Response.status(400).build();     
		}else{
			return Response.status(200).entity(result).build();
		}
	}

	//===========GET HostPath by Id==============//
	@Path(WSConstants.ID_VALID)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetHostPathId(@PathParam(ID) String ID_VALID) throws JSONException {
		System.out.println("GetHostPathId");
		System.out.println("id=[" + ID_VALID + "]");

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Host-Pathogens ID", ID_VALID);  
		String result = "\n GET Host-Pathogens ID: \n" + jsonObject;
		System.out.println(result);
		return Response.status(200).entity(result).build();
	}

	//===========GET hostPath by pathogen Id==============//
	@Path(WSConstants.ID_VALID + Nouns.PATHOGENS)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetHostPathByPathogensId(@PathParam(ID) String ID_VALID) throws JSONException {
		System.out.println("GetHostPathogensByPathogensId");
		System.out.println("id=[" + ID_VALID + "]");

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Host ID", ID_VALID);  
		String result = "\n GET Host-Pathogens by Pathogens ID: \n" + jsonObject;
		System.out.println(result);
		return Response.status(200).entity(result).build();
	}

	//===========GET hostPath by host Id==============//
	@Path(WSConstants.ID_VALID + Nouns.HOSTS)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetHostPathByHostId(@PathParam(ID) String ID_VALID) throws JSONException {
		System.out.println("GetHostPathogensByPathogensId");
		System.out.println("id=[" + ID_VALID + "]");

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Host ID", ID_VALID);  
		String result = "\n GET Host-Pathogens by Host ID: \n" + jsonObject;
		System.out.println(result);
		return Response.status(200).entity(result).build();
	}

	//===========GET hostpath by Bad Id==============//
	@Path(WSConstants.ID_INVALID)
	@GET
	@Produces("application/json")
	public Response GetHostNOTId(@PathParam(ID) String ID_INVALID) throws JSONException {
		System.out.println("GetHostPathogensNOTId");
		System.out.println("id=[" + ID_INVALID + "]");

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("HostPathogens Bad ID", ID_INVALID); 

		System.out.println("\n GET Not Host-Pathogens ID: \n" + jsonObject);
		return Response.status(400).build();
	}

	//===========GET hostpath by pathogen Bad Id==============//
	@Path(WSConstants.ID_INVALID + Nouns.PATHOGENS)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetHostPathByPathogensBadId(@PathParam(ID) String ID_INVALID) throws JSONException {
		System.out.println("GetHostPathogensByPathogensBadId");
		System.out.println("id=[" + ID_INVALID + "]");

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("HostPathogens Invalid ID", ID_INVALID); 
		String result = "\n GET Host-Pathogens where Pathogens Bad ID: \n" + jsonObject;
		System.out.println(result);
		return Response.status(400).entity(result).build();
	}

	//===========GET hostpath by host Bad Id==============//
	@Path(WSConstants.ID_INVALID + Nouns.HOSTS )
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetHostPathByHostBadId(@PathParam(ID) String ID_INVALID) throws JSONException {
		System.out.println("GetHostPathogensByPathogensBadId");
		System.out.println("id=[" + ID_INVALID + "]");

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Host Invalid ID", ID_INVALID); 
		String result = "\n GET Host-Pathogens where Host Bad ID: \n" + jsonObject;
		System.out.println(result);
		return Response.status(400).entity(result).build();
	}
}