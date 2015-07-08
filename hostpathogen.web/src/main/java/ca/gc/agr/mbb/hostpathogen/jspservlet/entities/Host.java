package ca.gc.agr.mbb.hostpathogen.jspservlet.entities;

public class Host {
	private Long id;
	private String hgenus;
	private String hspecies;
	private String hfamily;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHgenus() {
		return hgenus;
	}
	public void setHgenus(String hgenus) {
		this.hgenus = hgenus;
	}
	public String getHspecies() {
		return hspecies;
	}
	public void setHspecies(String hspecies) {
		this.hspecies = hspecies;
	}
	public String getHfamily() {
		return hfamily;
	}
	public void setHfamily(String hfamily) {
		this.hfamily = hfamily;
	}

}
