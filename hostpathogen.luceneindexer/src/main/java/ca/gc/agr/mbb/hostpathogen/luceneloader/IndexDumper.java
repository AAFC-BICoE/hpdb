package ca.gc.agr.mbb.hostpathogen.luceneloader;

import java.io.File;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.index.DirectoryReader;



public class IndexDumper{

    public void count(final String indexDir){
	IndexReader reader = null;
	
	try{
	    reader = makeReader(indexDir);
	    System.out.println("Num records:" + reader.maxDoc());
	    System.out.println("####################");
	}
	catch(java.io.IOException e){
	    e.printStackTrace();
	}
	finally{
	    if(reader != null){
		try{
		    reader.close();
		}
		catch(java.io.IOException e){
		    e.printStackTrace();
		}
	    }
	}
    }
    
    public void dump(final String indexDir){
	IndexReader reader = null;
	try{
	    reader = makeReader(indexDir);
	    System.out.println("Num records:" + reader.maxDoc());
	    System.out.println("####################");
	    for ( int i = 0; i < reader.maxDoc(); i++ ) {
		try{
		    System.out.println(reader.document( i ));
		}catch(Exception e){
		    e.printStackTrace();
		    return;
		}
	    }
	}
	catch(java.io.IOException e){
	    e.printStackTrace();
	}
	finally{
	    if(reader != null){
		try{
		    reader.close();
		}
		catch(java.io.IOException e){
		    e.printStackTrace();
		}
		
	    }
	}
    }
    
    
    IndexReader makeReader(final String indexDir) throws java.io.IOException{
	return DirectoryReader.open(FSDirectory.open(new File(indexDir)));
    }

}//
