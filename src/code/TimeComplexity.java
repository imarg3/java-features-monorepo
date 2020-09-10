package code;

public class TimeComplexity {
	public static int factorial(int n) {
		int res = 1;
		for(int i=1; i<=n; i++)
			res = res * i;
		return res;
	}
	
	public static void prime(int n) {
		for (int num = 0; num <= n; num++) {
			int i;
			for (i = 2; i < num; i++) {
				if(num % i == 0)
					break;
			}
			if(i == num)
				System.out.println(num);
		}
	}
	
	public static void printTable(int n) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(n * i);
		}
	}
	
	public static void decimalToBinary(int num) {
		while(num > 0) {
			System.out.print(num % 2);
			num = num / 2;
		}
		System.out.println();
	}
	
	public static int linearSearch(int[] numbers, int value) {
		
		for(int index = 0; index < numbers.length; index++) {
			if(numbers[index] == value)
				return index;
		}
		
		return -1;
	}
}
