package ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.search.IndexSearcher;

public class LuceneConfig{
    public IndexSearcher searcher = null;
    public  Analyzer analyzer = null;
    public Populator populator = null;
    public String noun = null;
}
