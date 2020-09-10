package code;

public class TimeComplexityMain {
	
	public static void main(String[] args) {
		
		int result;
		result = TimeComplexity.factorial(5);
		System.out.println("5! = " + result);
		System.out.println("----------------------");
		
		TimeComplexity.prime(100);
		System.out.println("----------------------");
		
		TimeComplexity.decimalToBinary(10);
		System.out.println("----------------------");
		
		TimeComplexity.printTable(28);
		System.out.println("----------------------");
		
		int numbers[] = {21, 53, 45, 98, 35, 14, 67, 54, 32, 16};
		int valueToSearch = 45;
		int indexOfValue = TimeComplexity.linearSearch(numbers, valueToSearch);
		System.out.println(indexOfValue);
	}
}
