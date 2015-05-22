package ca.gc.agr.mbb.hostpathogen.ws;

import java.util.Properties;

import ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher.InitializationException;
import ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher.LuceneConfig;
import ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher.LuceneFields;
import ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher.SearcherDao;
import ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher.UtilLucene;

public class Load {
	//Search into Lucene Searcher to call the object return as Json// 
	protected static final String GOOD_LUCENE_DIR="./luceneIndexes";

	static final String TMP_DIR="./testDir_" + System.nanoTime();
	static final String TMP_FILE="./testFile_" + System.nanoTime();

	protected static final String GOOD_HOST_GENUS="Abies";
	protected static final String BAD_HOST_GENUS="ABCDEFGHIJK555";
	protected static final String GOOD_PATHOGEN_GENUS="Basidiodendron";
	protected static final long GOOD_HP_HOST_FK = 1698;
	protected static final long GOOD_HP_PATHOGEN_FK = 74462;
	protected static final long GOOD_HP_REFERENCE_FK = 2111;
	protected static final String A_STAR_WILDCARD="a*";

	static LuceneConfig hostConfig;
	static LuceneConfig pathogenConfig;
	static LuceneConfig hostPathogenConfig;

	static Properties goodProperties = new Properties();

	static{
		goodProperties.put(SearcherDao.LUCENE_INDICES_BASE_DIR, GOOD_LUCENE_DIR);
	}

	static{
		try{
			hostConfig = UtilLucene.luceneConfig(LuceneFields.HOST_TYPE, goodProperties);
			pathogenConfig = UtilLucene.luceneConfig(LuceneFields.PATHOGEN_TYPE, goodProperties);
			hostPathogenConfig = UtilLucene.luceneConfig(LuceneFields.HOST_PATHOGEN_TYPE, goodProperties);
		}catch(InitializationException e){
			e.printStackTrace();
		}
	}
}
