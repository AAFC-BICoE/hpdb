package ca.gc.agr.mbb.hostpathogen.web.actions;

import com.opensymphony.xwork2.Action;
import java.io.Serializable;

public class HpdbAction implements Serializable{  
	private int id;  
	private String hostfamily;  
	private String hostgenus;  
	private String hostspecies;  
	private String hostsynonym;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHostfamily() {
		return hostfamily;
	}

	public void setHostfamily(String hostfamily) {
		this.hostfamily = hostfamily;
	}

	public String getHostgenus() {
		return hostgenus;
	}

	public void setHostgenus(String hostgenus) {
		this.hostgenus = hostgenus;
	}

	public String getHostspecies() {
		return hostspecies;
	}

	public void setHostspecies(String hostspecies) {
		this.hostspecies = hostspecies;
	}

	public String getHostsynonym() {
		return hostsynonym;
	}

	public void setHostsynonym(String hostsynonym) {
		this.hostsynonym = hostsynonym;
	}

	public String execute() {  
		return "SUCCESS";  
	}  

	public String getHost(){  
		return "SUCCESS"; 
	}
	public String getDetails(){  
		return "SUCCESS"; 
	}
	
	public String getHosts(){
		return "SUCCESS"; 
	} 
}
