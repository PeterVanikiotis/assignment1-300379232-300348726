public class Employee {
	String name;
	int hours;
	double rate;
	Address[] address;
	
	public Employee(String name, int hours, double rate, Address[] addresses) {
		this.name = name;
		this.hours = hours;
		this.rate = rate;
		this.address = new Address[5];
	}
}
