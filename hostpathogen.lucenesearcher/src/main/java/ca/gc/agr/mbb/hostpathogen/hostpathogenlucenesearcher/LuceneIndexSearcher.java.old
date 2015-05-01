package ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher;



import ca.gc.agr.mbb.hostpathogen.nouns.Pathogen;
import java.io.File;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.NumericRangeQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.util.NumericUtils;


public class LuceneIndexSearcher<T> implements LuceneFields{


    private final static Logger LOG = Logger.getLogger(LuceneIndexSearcher.class.getName()); 
    public final static int MAX_IDS = 50;

    private Class<T> type;

    private IndexSearcher searcher = null;
    private Analyzer analyzer = null;
    private Populator populator = null;

    private LuceneIndexSearcher(){

    }

    public LuceneIndexSearcher(final Class<T> type){
	if (type == null){
	    throw new NullPointerException("Type cannot be null");
	}
	this.type = type;
    }

    public T newInstance() throws InstantiationException, IllegalAccessException{
      return type.newInstance();
    }

    public void init(final IndexSearcher searcher, final Analyzer analyzer, final Populator populator) throws InitializationException{
	try{
	    //LOG.info(getClass().getGenericSuperclass().getActualTypeArguments()[0]).toString())
	    Util.isNull(searcher);
	    Util.isNull(analyzer);
	    Util.isNull(populator);
	}catch(IllegalArgumentException e){
	    throw new InitializationException(e);
	}

	if(populator.getDefaultSortFields() == null || populator.getDefaultSortFields().size() == 0){
	    throw new InitializationException("Populator (" + populator.getClass().getName() + ") has null or zero length default sort field");
	}

	if(populator.getValidSortFieldSet() == null || populator.getValidSortFieldSet().size() == 0){
	    throw new InitializationException("Populator has null or zero length default sort field map");
	}

	if(!Util.listInSet(populator.getDefaultSortFields(), populator.getValidSortFieldSet())){
	    throw new InitializationException("Default sort fields not in valid sort fields");
	}

	this.populator = populator;
	this.searcher = searcher;
	this.analyzer = analyzer;
    }


    public void checkSortFields(final List<String> sf) throws IllegalArgumentException{
	if(sf == null || sf.size() == 0){
	    return;
	}
	StringBuilder sb = new StringBuilder("");
	for(String sortField: sf){
	    if(!populator.isValidSortField(sortField)){
		sb.append(sortField);
		sb.append(",");
	    }
	}
	if(sb.length() != 0){
	    throw new IllegalArgumentException("Illegal sort fields: " + sb.toString());
	}
    }

    public List<T>get(final List<Long> ids)throws TooManyIdsException, IllegalArgumentException, IndexFailureException{
	Util.checkIds(ids);
	if(ids.size() > MAX_IDS){
	    throw new TooManyIdsException("Too many ids: " + ids.size() +"; larger than max=" + MAX_IDS);
	}

	String queryString = UtilLucene.buildQuery(UtilLucene.makeIdsQueryMap(populator.getPrimaryKeyField(), ids), populator.getRecordType());
	LOG.info("**** query=" + queryString);
	List<T>pathogens = null;
	try{
	    TopDocs td = UtilLucene.runQuery(queryString, populator.getDefaultSortFields(), analyzer, searcher, false);
	    LOG.info("**** Totalhits=" + td.totalHits);
	    pathogens = new ArrayList<T>(td.totalHits);
	    for(ScoreDoc sd: td.scoreDocs){
		Document doc = searcher.doc(sd.doc);
		pathogens.add((T)populator.populate(doc));
		LOG.info(sd.doc + ":" + doc);
	    }
	}catch(Exception e){
	    e.printStackTrace();
	    throw new IndexFailureException(e);
	}
	return pathogens;
    }



    public List<Long>getAll(final long offset, final int limit) throws IndexFailureException{
	return UtilLucene.topDocsToIds(UtilLucene.all(populator.getRecordType(), populator.getDefaultSortFields(), analyzer, searcher), searcher, populator.getPrimaryKeyField(), offset, limit);
    }


    public long countAll()throws IndexFailureException{
	return (long)UtilLucene.all(populator.getRecordType(), populator.getDefaultSortFields(), analyzer, searcher).scoreDocs.length;
    }

    public long countSearch(final Map<String,List<String>>queryParameters) throws IndexFailureException{
	Util.checkQueryParameters(queryParameters, populator.getValidSearchFieldSet());
	//return (long)all().totalHits;
	return UtilLucene.runQuery(UtilLucene.buildQuery(queryParameters, populator.getRecordType()), populator.getDefaultSortFields(), analyzer, searcher).totalHits;
    }


    public List<Long> search(final Map<String,List<String>>queryParameters, final long offset, final int limit) throws IndexFailureException, IllegalOffsetLimitException, IllegalArgumentException{
	Util.checkOffsetAndLimit(offset, limit);
	Util.checkQueryParameters(queryParameters, populator.getValidSearchFieldSet());
	
	List<String> recordType = new ArrayList<String>(1);
	recordType.add(populator.getRecordType());

	return UtilLucene.topDocsToIds(UtilLucene.runQuery(UtilLucene.buildQuery(queryParameters, populator.getRecordType()), populator.getDefaultSortFields(), analyzer, searcher), searcher, populator.getPrimaryKeyField(), offset, limit);
    }

    public Populator getPopulator(){
	return populator;
    }


}




