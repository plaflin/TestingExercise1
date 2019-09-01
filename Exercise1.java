package exercise;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

// Q. Write a method named isNumeric(String s) that returns true if the given string argument is an integer, otherwise return false;
// And write tests for it.  For example: isNumeric("123") should return true;
//
// --implement isNumeric(String s)
// --write test methods (use data provider)
// --identify test inputs
public class Exercise1 {
	
	boolean isNumeric(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	@DataProvider(name = "data")
	Object[][] data() {
		// +ve tests
		return new Object[][] {
			{"123"},
			{"-123"},
			{"-2147483648"}, // integer minimum boundary test
			{"2147483647"} // integer maximum boundary test
		};
	}
	
	@DataProvider(name = "invalidData")
	Object[][] invalidData() {
		// -ve tests
		return new Object[][] {
			{"abc"},
			{"abc123"},
			{""},
			{null},
			{"-2147483649"}, // integer minimum minus one test
			{"2147483648"}, // integer maximum plus one test
			{"123.456"}
		};
	}
	
	@Test(dataProvider = "data")
	void isNumericTest(String input) {
		Assert.assertTrue(isNumeric(input));
	}
	
	@Test(dataProvider = "invalidData")
	void isNumericTestWithInvalidData(String input) {
		Assert.assertFalse(isNumeric(input));
	}
}
