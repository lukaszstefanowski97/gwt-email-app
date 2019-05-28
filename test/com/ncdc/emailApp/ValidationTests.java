package com.ncdc.emailApp;

import org.junit.Test;

import com.ncdc.emailApp.client.Validation;
import com.ncdc.emailApp.client.ValidationImpl;

import static org.junit.Assert.*;

public class ValidationTests {

	Validation validation = new ValidationImpl();
	
	@Test
	public void isNameCorrect() {
		
		boolean result1 = validation.validateNameOrSurname("John");
		boolean result2 = validation.validateNameOrSurname("fjkdg./g");
		boolean result3 = validation.validateNameOrSurname(null);
		boolean result4 = validation.validateNameOrSurname("");
		boolean result5 = validation.validateNameOrSurname("aaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		
		assertEquals(true, result1);
        assertEquals(false, result2);
        assertEquals(false, result3);
        assertEquals(false, result4);
        assertEquals(false, result5);
	}
}
