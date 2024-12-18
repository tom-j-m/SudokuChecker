import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

//implement tests to test Sudokuverifier with boundary values.  Use templates from Task 1 to derive and document test cases.
	
// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891
String c = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
String i = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
SudokuVerifier v = new SudokuVerifier();

	@Test
	public void testCorrectString() {
		int a = v.verify(c);
		assertEquals("correct string", a, 0);
	}

	@Test
	public void testIncorrectString() {
		int a = v.verify(i);
		assertEquals("incorrect string", a, -2);
		
	}
	
	@Test
	public void testEmptyString() {
		//create a verifier and try verifying an empty string
		SudokuVerifier v = new SudokuVerifier();
		int a = v.verify("");
		assertEquals("Empty String", a, -1);
	}
	
	@Test
	public void testLessThan81String() {
		//create a verifier and try verifying a too SHORT sequence
		SudokuVerifier v = new SudokuVerifier();
		String input = "123456789";
		int a = v.verify(input);
		assertEquals("Srting has less than 81 characters", a, -1);
	}
	
	@Test
	public void testMoreThan81String() {
		//create a verifier and try verifying a too LONG sequence
		SudokuVerifier v = new SudokuVerifier();
		String input = "4173698256321589479587243168254371697915864323469127582896435715732916841648752935";
		int a = v.verify(input);
		assertEquals("Srting has less than 81 characters", a, -1);
	}
	
	@Test
	public void testStringWithNonDigits() {
		//create a verifier and try verifying a sequence containing a letter
		SudokuVerifier v = new SudokuVerifier();
		String input = "4173698256321589479587243168254371697915864323469127582896A3571573291684164875293";
		int a = v.verify(input);
		assertEquals("String has non-digit characters", a, 1);
	}
	
	@Test
	public void testStringWithUnicodes() {
		//create a verifier and try verifying a sequence containing a unicode special character
		SudokuVerifier v = new SudokuVerifier();
		String input = "417369825632158947958724316825437169791586/u3042432346912758289643571573291684164"; //Hiragana letter A
		int a = v.verify(input);
		assertEquals("String with Unicode characters", a, 1);
	}
	
	@Test
	public void testRepeatColumnDigits() {
		//create a verifier and try verifying a sequence with a repeating number at a column
		//tried several different inputs, but could not fail the test succesfully
		SudokuVerifier v = new SudokuVerifier();
		String input = "417369825632158947958724316825437169791586432346912758289643571573291684134875296"; //number 6 repeats on column 9
		int a = v.verify(input);
		assertEquals("Number repeated in a column", a, -3);
	}
	
}
