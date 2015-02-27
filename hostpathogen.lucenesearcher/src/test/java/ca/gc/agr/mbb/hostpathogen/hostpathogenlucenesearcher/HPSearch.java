package ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher;

public interface HPSearch{
     static final String GOOD_LUCENE_DIR="./luceneIndexes";
     static final String BAD_LUCENE_DIR="/88888/444/bhgjrueww/../22/%^$";
     static final String TMP_DIR="./testDir_" + System.nanoTime();
     static final String TMP_FILE="./testFile_" + System.nanoTime();

    static final String GOOD_HOST_GENUS="Abies";
     static final String BAD_HOST_GENUS="ABCDEFGHIJK555";
     static final String GOOD_PATHOGEN_GENUS="Basidiodendron";
     static final long GOOD_HP_HOST_FK = 1698;
     static final long GOOD_HP_PATHOGEN_FK = 74462;
     static final long GOOD_HP_REFERENCE_FK = 2111;

     static final String A_STAR_WILDCARD="a*";

     static final Long HUGE_ID = new Long(99999999999999l);


}
