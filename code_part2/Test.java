public class Test {

	public static void main(String[] args) {
		Address address1 = new Address("Queen", 48, "K1P1N2");
		Address[] addresses = new Address[5];
		addresses[0] = address1;
		Employee o1 = new Employee("Falco", 40, 15.50, addresses);
		addresses[1] = new Address("King Edward", 800, "K1N6N5");

	}

}
