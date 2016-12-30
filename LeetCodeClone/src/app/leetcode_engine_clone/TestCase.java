package app.leetcode_engine_clone;

import static org.junit.Assert.*;

import org.junit.Test;

//Problem: Write a function that takes a string as input and returns the string reversed.
//Example:
//Given s = "hello", return "olleh".

// defined by problem admin
public class TestCase extends TestCaseBase{

	//SolutionDemo solution = new SolutionDemo();
	SolutionInterface solution;
	
	public TestCase() {
		this.solution = super.getSolution();
	}
	
	@Test
	public void testNullInput() {
		String inputString = null;
		String expectedResult = null;
		String outputString = solution.reverseString(inputString);
		assertEquals(outputString, expectedResult);
	}
	
	@Test
	public void testAllChar() {
		String inputString = "hello";
		String expectedResult = "olleh";
		String outputString = solution.reverseString(inputString);
		assertEquals(outputString, expectedResult);
	}

	@Test
	public void testAllDigit() {
		String inputString = "123456";
		String expectedResult = "654321";
		String outputString = solution.reverseString(inputString);
		assertEquals(outputString, expectedResult);
	}
	
	@Test
	public void testSpecialChar() {
		String inputString = "1s9k jn)";
		String expectedResult = ")nj k9s1";
		String outputString = solution.reverseString(inputString);
		assertEquals(outputString, expectedResult);
	}
}
