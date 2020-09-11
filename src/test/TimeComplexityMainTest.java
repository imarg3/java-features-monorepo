package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import code.TimeComplexityMain;

@DisplayName("Time Complexity Test Cases")
class TimeComplexityMainTest {

	@ParameterizedTest(name = "Factorial of {0} is {1}")
	@DisplayName("Test factorial Values")
	@CsvSource(value = {"5, 120", "10, 3628800"})
	void testFactorial(int number, int factorial) {
		// Arrange Act Assert
		int result = TimeComplexityMain.factorial(number);
		
		assertEquals(factorial, result, "factorial of " + number + " is incorrect!");
	}
}
