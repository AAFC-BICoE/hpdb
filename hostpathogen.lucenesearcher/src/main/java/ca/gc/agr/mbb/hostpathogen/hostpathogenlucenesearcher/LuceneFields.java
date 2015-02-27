package ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher;



public interface LuceneFields{
    public static final String INDEX_PATHOGEN = "luceneIndex.pathogens";
    public static final String INDEX_HOST = "luceneIndex.hosts";
    public static final String INDEX_REFERENCE = "luceneIndex.references";
    public static final String INDEX_HOST_PATHOGEN = "luceneIndex.host_pathogens";


    public static final String SORT_FIELD = "sortField";

    public static final String ID_SUFFIX= "_ID";

    public static final String STORED_SUFFIX= "_stored";


    public static final String TIMESTAMP_TYPE = "time_stamp";
    public static final String TIMESTAMP_FIELD = TIMESTAMP_TYPE;
    public static final String TIMESTAMP_FIELD_IN_MILLIS = TIMESTAMP_FIELD + "_millis";
    public static final String TIMESTAMP_FORMAT = "yyyy.MM.dd  HH:mm:ss z";

    // NOUNS
    //     TYPES
    public static final String AUTHOR_TYPE = "author";
    public static final String ANAMORPH_TYPE = "anamorph";
    public static final String HIGHER_TAXA_TYPE = "higher_taxa";
    public static final String HOST_PATHOGEN_TYPE = "host_pathogen";
    public static final String HOST_TYPE = "host";
    public static final String HP_LOCALITY_JOIN_TYPE = "hp_locality_join";
    public static final String LOCALITY_TYPE = "locality";
    public static final String PATHOGEN_TYPE = "pathogen";
    public static final String REFERENCE_TYPE = "reference";
    public static final String REF_SOURCES_TYPE = "ref_sources";

    public static final String HOST_PATHOGEN_SEARCH_TYPE = "host_pathogen_search";
    //     FIELDS
    public static final String RECORD_TYPE = "record_type";
    public static final String BOOK_AUTHOR="book_author";
    public static final String BOOK_EDITOR="book_editor";
    public static final String BOOK_PAGES="book_pages";
    public static final String BOOK_PUBLISHER="book_publisher";
    public static final String BOOK_PUBLISHER_PLACE="book_publisher_place";
    public static final String BOOK_TITLE="book_title";
    public static final String BOOK_YEAR="book_year";
    public static final String CHAPTER_ARTICLE_TITLE = "chapter_article_title";
    public static final String CULTIVAR="cultivar";
    public static final String DATA_SOURCE = "data_source";
    public static final String FK_ANAMORPH_ID = "fk_anamorph_id";

    public static final String FK_LOCATION_ID = "fk_location_id";

    public static final String FK_PATHOGEN_ID_ANA = "fk_pathogen_id_ana";
    public static final String FK_PATHOGEN_ID_SYN = "fk_pathogen_id_syn";
    public static final String FK_PATHOGEN_ID_SYN2 = "fk_pathogen_id_syn2";

    public static final String FK_HIGHER_TAXA_ID = "fk_higher_taxa_id";
    public static final String FK_HOST_ID = "fk_host_id";
    public static final String FK_HOST_ID_ACCEPTED = "fk_host_id_accepted";
    public static final String FK_PATHOGEN_ID = "fk_pathogen_id";
    public static final String FK_HOST_PATHOGEN_ID = "fk_host_pathogen_id";
    public static final String FK_PATHOGEN_ID_ACCEPTED = "fk_pathogen_id_accepted";
    public static final String FK_REFERENCE_ID="fk_reference_id";
    public static final String FK_REF_SOURCE_ID = "fk_ref_source_id";
    public static final String FUNGAL_STATE = "fungal_state";
    public static final String HOST_AUTHOR = "host_author";
    public static final String HOST_GENUS = "host_genus";
    public static final String HOST_ID = "host_id";
    public static final String HOST_ID_ACCEPTED = "host_id_accepted";
    public static final String HOST_SPECIES = "host_species";
    public static final String HOST_SUBSPECIFIC_TAXA = "host_subspecific_taxa";

    
    public static final String INTERPRETATION = "interpretation";
    public static final String JOURNAL_ABBREVIATION="journal_abbreviation";
    public static final String JOURNAL_TITLE="journal_title";
    public static final String LOOKUP_AUTHOR="lookup_author";
    public static final String NOTES="notes";
    public static final String PAGES = "pages";
    public static final String PATHOGEN_AUTHOR = "pathogen_author";
    public static final String PATHOGEN_GENUS = "pathogen_genus";
    public static final String PATHOGEN_SPECIES = "pathogen_species";
    public static final String PATHOGEN_SUBSPECIFIC_TAXA = "pathogen_subspecific_taxa";
    public static final String PK_AUTHOR_LOOKUP_ID="pk_author_lookup_id";
    public static final String PK_ANAMORPH_ID = "pk_anamorph_id";
    public static final String PK_HOST_ID = "pk_host_id";
    public static final String PK_HOST_PATHOGEN_ID = "pk_host_pathogen_id";
    public static final String PK_LOCATION_ID = "pk_location_id";
    public static final String PK_PATHOGEN_ID = "pk_pathogen_id";
    public static final String PK_REFERENCE_ID = "pk_reference_id";
    public static final String PK_REF_SOURCE_ID = "pk_ref_source_id";
    public static final String PLANT_PART="plant_part";
    public static final String REFERENCE_AUTHORS = "reference_authors";
    public static final String REFERENCE_YEAR = "reference_year";
    public static final String RUST_STATE="rust_state";
    public static final String SYMPTOM="symptom";
    public static final String VIRUS_MPLO_NAMES = "virus_MPLO_names";
    public static final String VOLUME = "volume";

    public static final String PK = "ID";
    
    public static final String PK_HIGHER_TAXA_ID = "pk_higher_taxa_id";
    public static final String KINGDOM = "kingdom";
    public static final String DIVISION = "division";
    public static final String CLASS = "class";
    public static final String ORDER = "order";
    public static final String FAMILY = "family";


    public static final String PROVINCE_STATE_TERRITORY_ABBREVIATION= "geographical_abbreviation";
    public static final String PROVINCE_STATE_TERRITORY = "interpretation";
    public static final String COUNTRY = "country";
}
