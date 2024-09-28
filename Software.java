package asset_management;
import java.util.*;

public class Software {
	String name;
	Vendor vendorId;
	double price;
	Date expiryDate;
	
	Software(String name, Vendor v, Date d, Double price){
		this.name= name;
		this.vendorId= v;
	}
	
	public String getSoftwareName() {
		return name;
	}
	
	public int getVendorId() {
		return vendorId.id;
	}
	
	public double getPrice() {
		return price;
	}
	
	public Date getExpiryDate() {
		return expiryDate;
	}
}
