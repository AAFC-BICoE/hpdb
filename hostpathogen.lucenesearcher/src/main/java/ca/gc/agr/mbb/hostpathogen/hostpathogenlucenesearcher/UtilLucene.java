package ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField.Type;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.apache.lucene.document.Field;
import ca.gc.agr.mbb.hostpathogen.nouns.Pathogen;

public class UtilLucene implements LuceneFields{
    private final static Logger log = Logger.getLogger(UtilLucene.class.getName()); 

    public static final String makeLuceneQueryPair(final String key, final String value){
	return key 
	    + ":" 
	    + value.toLowerCase() + " ";
    }

    public static final Map<String, List<String>> makeIdQueryMap(final String fieldName, final Long id){
	List<Long>ids = new ArrayList<Long>(1);
	ids.add(id);
	return makeIdsQueryMap(fieldName, ids);
    }

    public static final Map<String, List<String>> makeIdsQueryMap(final String fieldName, final List<Long> ids){
	Map<String, List<String>> queryMap = new HashMap<String, List<String>>();
	List<String> values = new ArrayList<String>();
	for(Long id: ids){
	    values.add(id.toString());
	}
	queryMap.put(fieldName, values);
	return queryMap;
    }


    public static final List<Long> topDocsToIds(final TopDocs td, final IndexSearcher searcher, 
						final String primaryKeyField, final long offset, final int limit) throws IndexFailureException{
	List<Long> ids = new ArrayList<Long>();
	ScoreDoc[] scoreDocs = td.scoreDocs;
	if (offset <= scoreDocs.length){
	    for(int i=(int)offset; i<limit && i<scoreDocs.length; i++){
		Document doc = null;
		try{
		    doc  = searcher.doc(scoreDocs[i].doc);
		}catch(IOException e){
		    e.printStackTrace();
		    throw new IndexFailureException(e);
		}
		ids.add(new Long(doc.getValues(storedName(primaryKeyField))[0]));
	    }
	}
	return ids;
    }

    public static final String storedName(String name){
	return name + LuceneFields.STORED_SUFFIX;
    }


    protected final static TopDocs all(final String recordType, final List<String> sortFields, final Analyzer analyzer, final IndexSearcher searcher) throws IndexFailureException{
	return runQuery(recordTypeFilter(recordType), sortFields, analyzer,searcher);
    }

    protected final static String buildQuery(final Map<String,List<String>>queryParameters, String recordType, boolean allRequired){
	if (recordType == null || recordType.length() == 0){
	    throw new NullPointerException("record type cannot be null");
	}
	if(queryParameters == null || queryParameters.size() == 0){
	    return recordTypeFilter(recordType);
	}
	
	StringBuilder sb = new StringBuilder();
	
	if (!allRequired){
	    sb.append("(");
	}
	boolean first = true;
	for(String key:queryParameters.keySet()){
	    if(key.equals(LuceneFields.SORT_FIELD)){
		continue;
	    }

	    if (first){
		first = false;
	    }else{
		if (allRequired){
		    sb.append("AND ");
		}
	    }
	    List<String>values = queryParameters.get(key);

	    for(String value: values){
		sb.append(UtilLucene.makeLuceneQueryPair(key, value));
		sb.append(" ");
	    }
	}

	if (!allRequired){
	    sb.append(")");
	}
	sb.append("AND ");
	sb.append(recordTypeFilter(recordType));
	log.info("Lucene Query: " + sb.toString());
	return sb.toString();
    }

    protected final static TopDocs runQuery(final Query query, final List<String> sortFields, final IndexSearcher searcher) throws IndexFailureException{
	Sort sort = null;
	if (sortFields != null && sortFields.size() > 0){
	    sort = new Sort();
	    SortField[] sFields =new SortField[sortFields.size()];
	    
	    for(int i=0; i<sortFields.size(); i++){
		sFields[i] = new SortField(sortFields.get(i), SortField.Type.STRING_VAL);
	    }
	    sort.setSort(sFields);
	}
	try{
	    log.info("Lucene query run: " + query);
	    if (sort == null){
		    return searcher.search(query, Integer.MAX_VALUE);
		}else{
		return searcher.search(query, Integer.MAX_VALUE, sort);
	    }
	}catch(IOException e){
	    e.printStackTrace();
	    throw new IndexFailureException(e);
	}
    }

    // Allow leadingWildCard by default
    protected final static TopDocs runQuery(final String queryString, final List<String> sortFields, final Analyzer analyzer, final IndexSearcher searcher) throws IndexFailureException{
	return runQuery(queryString, sortFields, analyzer, searcher, true);
    }
    
    protected final static TopDocs runQuery(final String queryString, final List<String> sortFields, final Analyzer analyzer, final IndexSearcher searcher, boolean allowLeadingWildcard) throws IndexFailureException{
	QueryParser queryParser = new QueryParser("tmp", analyzer); // not thread safe// "tmp" as there should be no unattached-to-field queries...
	queryParser.setAllowLeadingWildcard(allowLeadingWildcard);

	// see https://stackoverflow.com/questions/5527868/exact-phrase-search-using-lucene
	//queryParser.setDefaultOperator(QueryParser.Operator.AND);
	//queryParser.setPhraseSlop(0);
	Query query = null;
	try{
	    query = queryParser.parse(queryString);
	}catch(org.apache.lucene.queryparser.classic.ParseException e){
	    e.printStackTrace();
	    throw new IndexFailureException(e);
	}
	return runQuery(query, sortFields, searcher);
    }

    
    public static final IndexSearcher makeIndexSearcher(String dir) throws IOException{
	IndexReader reader = DirectoryReader.open(FSDirectory.open(new File(dir)));
	log.info("Num docs in " + dir + "=" + reader.maxDoc());
	return new IndexSearcher(reader);
    }

    public static final Analyzer makeAnalyzer(){
	return new StandardAnalyzer(luceneVersion()); // thread safe
    }

    public static final Version luceneVersion(){
	return Version.LUCENE_4_10_0;
    }

    public static final IndexWriter makeIndexWriter(final String indexDir, final Analyzer analyzer) throws IOException{
	log.info("Opening Lucene index: " + indexDir);
	Directory dir = FSDirectory.open(new File(indexDir));
	IndexWriterConfig iwc = new IndexWriterConfig(UtilLucene.luceneVersion(), analyzer);

	iwc.setOpenMode(OpenMode.CREATE);

	IndexWriter writer = new IndexWriter(dir, iwc);
	log.info("Success opening Lucene index: " + indexDir);
	return writer;
    }

    public static final void openAndWriteLuceneIndex(String dir) throws IOException{
	IndexWriter writer = makeIndexWriter(dir, UtilLucene.makeAnalyzer());

	Document doc = new Document();
	doc.add(new StringField("testFieldName", "test field", Field.Store.YES));
	writer.addDocument(doc);
	try{
	    System.err.println("Closing index ");
	    writer.close();
	}catch(Exception e){
	    e.printStackTrace();
	}
	
    }

    public static final String recordTypeFilter(final String recordType){
	return LuceneFields.RECORD_TYPE + ":" + recordType;
    }

    public static final LuceneConfig luceneConfig(final String noun, final Properties prop) throws InitializationException, IllegalArgumentException{
	Util.isNullOrZero(noun);
	Util.isNull(prop);
	String luceneDir = prop.getProperty(SearcherDao.LUCENE_INDICES_BASE_DIR);
	
	if(luceneDir == null){
	    throw new IllegalArgumentException("luceneDir is null: LUCENE_INDICES_BASE_DIR is not set in properties?");
	}
	log.info("Opening Lucene index for directory: " + luceneDir);

	// FIXX analyzer and indexSearcher need to be singletons
	LuceneConfig lc = new LuceneConfig();
	lc.noun = noun;
	try{
	    lc.searcher = UtilLucene.makeIndexSearcher(luceneDir);
	    lc.analyzer = UtilLucene.makeAnalyzer();
	}catch(Throwable t){
	    throw new InitializationException(t);
	}
	switch(noun){

	case PATHOGEN_TYPE:
	    lc.populator = new PathogenPopulator<Pathogen>();
	    break;

	case HOST_TYPE:
	    lc.populator = new HostPopulator();
	    break;


	case HOST_PATHOGEN_TYPE:
	    lc.populator = new HostPathogenPopulator();
	    break;

	case HIGHER_TAXA_TYPE:
	    lc.populator = new HigherTaxaPopulator();
	    break;

	case REFERENCE_TYPE:
	    lc.populator = new ReferencePopulator();
	    break;

	case REF_SOURCES_TYPE:
	    lc.populator = new RefSourcesPopulator();
	    break;

	case LOCALITY_TYPE:
	    lc.populator = new LocationPopulator();
	    break;


	case HP_LOCALITY_JOIN_TYPE:
	case AUTHOR_TYPE:
	default:
	    throw new InitializationException("Unimplemented Populator for: " + noun);
	}
	if (lc.populator.getProductClass() == null){
	    throw new InitializationException("Populator.productClass is null");
	}

	return lc;
    }

    public static final List<Long> runQueryForIds(final Map<String,List<String>>queryParameters, long offset, int limit, LuceneConfig lc, boolean allRequired) throws IllegalArgumentException, IndexFailureException{
	String query = buildQuery(queryParameters, lc.populator.getRecordType(), allRequired);
	TopDocs td = runQuery(query, lc.populator.getDefaultSortFields(), lc.analyzer, lc.searcher);
	List<Long> resultIds = topDocsToIds(td, lc.searcher, lc.populator.getPrimaryKeyField(), offset, limit);
	log.info("Query results #=" + resultIds.size() + "  [" + query + "]" + "  offset=" + offset + "  limit=" + limit);

	return resultIds;
	
    }
}
