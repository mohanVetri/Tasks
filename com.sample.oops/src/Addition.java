public class Addition {
	int number;

	Addition(int input) {
		number = input;
	}

	public int add(int number, int number2) {
		return this.number + number + number2;
	}

	public int add(int number1, int number2, int number3) { // method overloading
		return number + number1 + number2 + number3;
	}

}
