package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import org.code.SearchingMain;

class SearchingMainTest {

	@ParameterizedTest(name = "{0} is at index {1} in Array")
	@DisplayName("Test whether a value in an array exists or not using Linear Search")
	@CsvSource(value = {"20, 1", "50, 4", "70, -1"})
	void check_for_returning_index_in_array_using_linear_search(int value, int index) {
		// Arrange
		int[] numbers = { 10, 20, 30, 40, 50};
		
		// Act
		int return_index = SearchingMain.linearSearch(numbers, value);
		
		// Assert
		assertEquals(return_index, index);
	}
}
