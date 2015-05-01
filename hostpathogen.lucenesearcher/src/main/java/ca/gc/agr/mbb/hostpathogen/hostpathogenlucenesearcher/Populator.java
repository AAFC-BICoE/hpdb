package ca.gc.agr.mbb.hostpathogen.hostpathogenlucenesearcher;

import java.util.Set;
import java.util.List;
import java.util.Map;
import org.apache.lucene.document.Document;

public interface Populator<T> extends LuceneFields{
    public T populate(Document d);

    public Class getProductClass();
    public String getRecordType();
    public String getPrimaryKeyField();

    public void addSearchFields(String... s);
    public boolean isValidSearchField(String s);
    public Set<String>getValidSearchFieldSet();

    public void addSortFields(String... s);
    public boolean isValidSortField(String s);
    public Set<String>getValidSortFieldSet();

    public void addDefaultSortFields(String... s);
    public List<String> getDefaultSortFields();

    public void addRelation(Class type, String field);
    public String getRelationField(Class type);
    public boolean isValidRelation(Class type);
    public Map<Class, String>getValidRelations();
}
