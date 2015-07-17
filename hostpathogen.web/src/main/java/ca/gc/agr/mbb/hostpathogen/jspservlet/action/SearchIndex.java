package ca.gc.agr.mbb.hostpathogen.jspservlet.action;

import javax.jws.WebService;

import org.apache.log4j.Logger;

@WebService()
public class SearchIndex {
	private static final Logger logger = Logger.getLogger(SearchIndex.class);
 /*
    @WebMethod(operationName = "searchLucene")
    public int[] searchLucene(
                            @WebParam(name="clientId")int clientId,
                            @WebParam(name="keywordId")int keywordId,
                            @WebParam(name="searchStr")String searchStr,
                            @WebParam(name="startLimit")int startLimit,
                            @WebParam(name="hitPerPage")int hitPerPage) throws IOException, ParseException{
 
        SearchUtil su = new SearchUtil();
        int[] searchIds = su.search(clientId, keywordId, searchStr, startLimit, hitPerPage);
 
        return searchIds;
    }*/
}