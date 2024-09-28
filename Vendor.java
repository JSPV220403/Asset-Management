package asset_management;

public class Vendor {
	static int id_generator=0;
	int id;
	String name;
	
	Vendor(String name){
		this.id= ++id_generator;
		this.name= name;
	}
	
	public int getVendorId() {
		return id;
	}
	
	public String getVendorName() {
		return name;
	}
	
}
