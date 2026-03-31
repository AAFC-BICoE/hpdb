import java.io.FileInputStream;
import java.util.Properties;

public class Test {

	public static void main(String[] args) throws Exception{
		Properties xx = new Properties();
		xx.load(new FileInputStream("/home/xilu/unpack/hpdb/src/main/resources/ApplicationResources_fr.properties"));

	}

}
