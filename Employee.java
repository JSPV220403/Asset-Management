package asset_management;
import java.util.*;

public class Employee {
	static int id_generator=0;
	int id;
	String name;
	List<Device> devices= new ArrayList<>();
	
	Employee(String name){
		this.id= ++id_generator;
		this.name= name;
	}
	
	public void addDevice(Device d) {
		devices.add(d);
	}
}
