package asset_management;
import java.util.*;

public class Device {
	static int id_generator=0;
	int id;
	Employee owner;
	List<Installations> installation= new ArrayList<>();
	
	Device(Employee e){
		this.owner= e;
		this.id= ++id_generator;
	}
	
	public void installSoftwareOnDevice(Installations i) {
		installation.add(i);
	}
}
