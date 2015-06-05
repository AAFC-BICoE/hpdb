package ca.gc.agr.mbb.hostpathogen.ws;

import java.util.ArrayList;
import java.util.List;

public class PagingPayload extends CountPayload{
    public Integer limit = 100;
    public String baseUrl;
    public Long offset = 0l;
    public String nextPageUrl;
    public Integer count = 0;

    public List<ServiceUrl> urls = new ArrayList<ServiceUrl>(WSConstants.DEFAULT_PAGING_LIMIT);

    public PagingPayload(final String baseUrl, final long offset, final int limit, final String[] pathFragments, final boolean dataIsOffset){
	init(baseUrl, offset, limit);
	System.err.println("pathFragments.length=" + pathFragments.length
			   + " offset=" + offset
			   + "  limit=" + limit);

	long internalOffset = offset;
	if(dataIsOffset){
	    internalOffset = 0;
	}
	if(pathFragments != null 
	   && (int)internalOffset< pathFragments.length){
	    int max = (int)(internalOffset+limit);
	    if(max > pathFragments.length){
		max = pathFragments.length;
	    }
	    for(int i=(int)internalOffset; i<max; i++){
		this.urls.add(new ServiceUrl(baseUrl, pathFragments[i]));
	    }
	    if(internalOffset + limit > max){
		this.limit = max - (int)offset;
	    }
	}
	this.count = urls.size();

	this.total = (long)pathFragments.length;

	if(offset+limit < total-1){
	    this.nextPageUrl = baseUrl + "?" 
		+ WSConstants.PAGING_OFFSET_PARAMETER + "=" + (offset+limit)
		+ "&"
		+ WSConstants.PAGING_LIMIT_PARAMETER + "=" + limit;
	}

	if(this.count == 0){
	    urls = null;
	}
    }

    public PagingPayload(final String baseUrl, final long offset, final int limit, final Long[] pathFragments, final boolean dataIsOffset ){
	this(baseUrl, offset, limit, longArrayToStringArray(pathFragments), dataIsOffset);
    }


    private void init(final String baseUrl, final long offset, final int limit){
	this.baseUrl = baseUrl;
	this.offset = offset;
	this.limit = limit;
    }

    static String[] longArrayToStringArray(Long[] la){
	String[] sa;
	if(la == null){
	    sa = new String[0];
	}else{
	    sa = new String[la.length];
	    for(int i=0; i<la.length; i++){
		sa[i] = la[i].toString();
	    }
	}
	return sa;
    }
}