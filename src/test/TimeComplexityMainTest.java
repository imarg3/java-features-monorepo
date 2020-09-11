package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import code.TimeComplexity;

@DisplayName("Time Complexity Test Cases")
class TimeComplexityTest {

	@ParameterizedTest(name = "Factorial of {0} is {1}")
	@DisplayName("Test factorial Values")
	@CsvSource(value = {"5, 120", "10, 3628800"})
	void testFactorial(int number, int factorial) {
		// Arrange Act Assert
		int result = TimeComplexity.factorial(number);
		
		assertEquals(factorial, result, "factorial of " + number + " is incorrect!");
	}
	
	@ParameterizedTest(name = "{0} is at index {1} in Array")
	@DisplayName("Test whether a value in an array exists or not using Linear Search")
	@CsvSource(value = {"20, 1", "50, 4", "70, -1"})
	void check_for_returning_index_in_array_using_linear_search(int value, int index) {
		// Arrange
		int[] numbers = { 10, 20, 30, 40, 50};
		
		// Act
		int return_index = TimeComplexity.linearSearch(numbers, value);
		
		// Assert
		assertEquals(return_index, index);
	}

}
