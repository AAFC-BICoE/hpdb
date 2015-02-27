package ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher;

import java.util.List;
import java.util.Arrays;

abstract public class BaseNoun{
    static final String IMPOSSIBLE_STRING = "ab8jd93jdkk";

    static Long validIds[] = null;
    static Long invalidIds[] = null;

    static String validSortFields[] = null;
    static String invalidSortFields[] = null;

    static String validGenus = null;
    static String invalidGenus = IMPOSSIBLE_STRING;

    static String validSpecies = null;
    static String invalidSpecies = IMPOSSIBLE_STRING;

    public List<Long> validIds(){
	return Arrays.asList(validIds);
    }

    public List<Long> invalidIds(){
	return Arrays.asList(invalidIds);
    }

    public List<String> validSortFields(){
	return Arrays.asList(validSortFields);
    }

    public List<String> invalidSortFields(){
	return Arrays.asList(invalidSortFields);
    }

    public String validGenus(){
	return validGenus;
    }

    public String invalidGenus(){
	return invalidGenus;
    }


    public String validSpecies(){
	return validSpecies;
    }

    public String invalidSpecies(){
	return invalidSpecies;
    }


    

}
