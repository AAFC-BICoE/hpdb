package ca.gc.agr.mbb.hostpathogen.ws;

public interface WSConstants{
	public static final String BASEPATH="v1/";

	public static final String ID="id";
	public static final String ID_VALID="/{" + ID + ": [\\d\\,\\/]+}";
	public static final String ID_INVALID="/{" + ID + ":.*[^0-9\\,\\/].*}";

	public static final String COUNTER = "counter";
	public static final String COUNTER_VALID="/{" + COUNTER + ": \\d+}";
	public static final String COUNTER_INVALID="/{" + COUNTER + ":.*[^0-9].*}";


	public static final int DEFAULT_PAGING_OFFSET = 0;
	public static final String DEFAULT_PAGING_OFFSET_STRING = "0";

	public static final int DEFAULT_PAGING_LIMIT = 51;
	public static final String DEFAULT_PAGING_LIMIT_STRING = "49";

	public static final int MAX_PAGING_LIMIT = DEFAULT_PAGING_LIMIT * 5;

	// Parameter names
	public static final String PAGING_OFFSET_PARAMETER = "offset";
	public static final String PAGING_LIMIT_PARAMETER = "limit";
    // http headers
    public static String CONTENT_LOCATION = "Content-Location";
    public static final String DEBUG_PATH = "DEBUG";

	public enum METHOD {
		GET, 
		HEAD, 
		OPTIONS,
	}

}