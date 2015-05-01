package ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher;


import ca.gc.agr.mbb.hostpathogen.nouns.Pathogen;
import ca.gc.agr.mbb.hostpathogen.nouns.Host;
import ca.gc.agr.mbb.hostpathogen.nouns.HostPathogen;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Date;

public interface SearcherDao<T>{
     /**
     * Initialize the Searcher. Must be run before any other methods.
     *
     * @param p Initialization properties (like Search.MOCK_PROPERTY)
     * @return Searcher
     * @throws InitializationException <<Description>>
     */

    public void init(LuceneConfig lc) throws InitializationException;

    public List<Long>getAll(final long offset, final int limit) throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException;

    public List<Long>search(Map<String,List<String>>queryParameters, List<String> sortFields, final long offset, final int limit) throws IllegalOffsetLimitException, IllegalArgumentException, IndexFailureException, InitializationException;

    public List<T>get(final List<Long> ids) throws IllegalArgumentException, IndexFailureException, InitializationException;

    public T get(final Long id) throws IllegalArgumentException, IndexFailureException, InitializationException;

    public long getAllCount() throws IndexFailureException, InitializationException;

    public long searchCount(Map<String,List<String>>queryParameters) throws IllegalArgumentException, IndexFailureException, InitializationException;

    // 1:many
    public List<Long> getBy(Class type, long foreignKeyId, final long offset, final int limit) throws IllegalArgumentException, IndexFailureException, IllegalOffsetLimitException,InitializationException;

    // many:many
    //public List<Long> getBy(long thisId, Class joinType, Class otherType, long thatId, final long offset, final int limit) throws IllegalArgumentException, IndexFailureException, IllegalOffsetLimitException,InitializationException;

    public Date getTimeStamp() throws IndexFailureException, InitializationException;



    public static final String LUCENE_INDICES_BASE_DIR = "lucene_indices_base_dir";
    public static final int MAX_REQUESTED_IDS = 100;
    public static final int MAX_REQUESTED_OBJECTS = 20;
}
