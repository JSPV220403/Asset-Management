package asset_management;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
	
	static List<Employee> employees= new ArrayList<>();
	static List<Vendor> vendors= new ArrayList<>();
	static List<Software> softwares = new ArrayList<>();
	static List<Device> devices= new ArrayList<>();
	static Scanner sc= new Scanner(System.in);
	
	public static Employee checkEmployeeAvailability(int id) {
		for(Employee e: employees) {
			if(e.id== id) {
				return e;
			}
		}
		return null;
	}
	public static Vendor checkVendorAvailability(int id) {
		for(Vendor v: vendors) {
			if(v.id== id) {
				return v;
			}
		}
		return null;
	}
	public static void main(String args[]) {
		int option;
		while(true) {
			System.out.println("1. Add Employee\n2. Add Vendor\n3. Add Device\n"
					+ "4.Add Software\n5. Install Software on Device\n6.Print Report\nEnter option: ");
			option= sc.nextInt();
			switch (option) {
			case 1:
				addEmployee();
				break;
			case 2:
				addVendor();
				break;
			case 3:
				addDevice();
				break;
			case 4:
				addSoftware();
				break;
			case 5:
				installSoftwareOnDevice();
				break;
			case 6:
				printReport();
				break;
			default:
				System.out.println("Invalid option!!!\nTry again!!\n");
				break;
			}
		}
	}
	public static void addEmployee() {
		
		System.out.println("Enter Employee name:");
		String name= sc.nextLine();
		Employee e= new Employee(name);
		System.out.println("Employee added successfully and Employee official ID is"+e.id);
		employees.add(e);
	}
	public static void addVendor() {
		String name;
		System.out.println("Enter Employee name:");
		sc.nextLine();// remove buffer value
		name= sc.nextLine();
		Vendor v= new Vendor(name);
		System.out.println("Vendor added successfully and vendor official ID is"+v.id);
		vendors.add(v);
	}
	public static void addDevice() {
		System.out.print("Enter employee id: ");
		int id= sc.nextInt();
		Employee e= checkEmployeeAvailability(id);
		if(e != null) {
			Device d= new Device(e);
			e.addDevice(d);
			devices.add(d);
			System.out.println("Device added successfully for that emplyee");
		}
		else {
			System.out.println("Entered invalid employee id!!!");
		}
	}
	public static void addSoftware() {
		System.out.println("Enter vendor id ");
		int id= sc.nextInt();
		Vendor v= checkVendorAvailability(id);
		if(v != null) {
			sc.nextLine();
			System.out.print("Entered Software Name: ");
			String softwareName= sc.nextLine();
			System.out.print("Entered Software price: ");
			double price= sc.nextDouble();
			System.out.print("Entered Software ExpiryDate: ");
			String d= sc.next();
			SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date date= sdf.parse(d);
				Software s= new Software(softwareName,v,date,price);
				softwares.add(s);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Entered invalid vendor id!!!");
		}
	}
	public static void installSoftwareOnDevice() {
		System.out.println("Enter employee id ");
		int id= sc.nextInt();
		Employee e= checkEmployeeAvailability(id);
		if(e != null) {
			sc.nextLine();
			System.out.print("Enter device id");
			int dId= sc.nextInt();
			Device divice= targetDevice(e,dId);
			if(divice!=null){
				System.out.print("Entered Software Name: ");
				String softwareName= sc.nextLine();
				Software s=checkSoftwareAvailability(softwareName);
				if(s!=null){
					System.out.print("Enter Installed date: ");
					String d= sc.next();
					SimpleDateFormat sdf= new SimpleDateFormat("dd/mm/yyyy");
					try {
						Date date= sdf.parse(d);
						Installations i= new Installations(s,date);
						divice.installation.add(i);
						
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				else {
					System.out.println("Entered invalid software name!!!");
				}
			}
			else {
				System.out.println("Entered invalid device id!!!");
			}
		}
		else {
			System.out.println("Entered invalid employee id!!!");
		}
	}
	private static Device targetDevice(Employee e, int dId) {
		// TODO Auto-generated method stub
		for(Device d: e.devices) {
			if(d.id==dId) {
				return d;
			}
		}
			
		return null;
	}
	private static Software checkSoftwareAvailability(String softwareName) {
		// TODO Auto-generated method stub
		for(Software s: softwares) {
			if(s.name.equals(softwareName)) {
				return s;
			}
		}
		return null;
	}
	
	public static void printReport() {
		System.out.println("             Employee Details");
		for(Employee e: employees) {
			System.out.println(e.id);
			System.out.println(e.name);
			System.out.println(String.valueOf(e.devices));
		}
		System.out.println("              Software Details");
		for(Software s: softwares) {
			System.out.println(s.name);
			System.out.println(s.price);
			System.out.println(s.expiryDate);
			System.out.println(s.vendorId);
		}
	}
}
