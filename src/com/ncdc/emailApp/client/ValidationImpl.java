package com.ncdc.emailApp.client;

public class ValidationImpl implements Validation{

	@Override
	public boolean validateNameOrSurname(String nameOrSurname) {
		if (nameOrSurname == null || nameOrSurname.length() < 2) {
	         return false;
	     }
	     for (int i = 0; i < nameOrSurname.length(); i++) {
	    	 if ((Character.isLetter(nameOrSurname.charAt(i)) == false)) {
	            return false;
	         }
	     }
	     return true;
	}
	
	@Override
	public boolean validatePhone(String phone) {
		if (phone == null || phone.length() < 3 || phone.length() > 10) {
	         return false;
	     }
		for (int i = 0; i < phone.length(); i++) {
	    	 if ((Character.isDigit(phone.charAt(i))) == false) {
	            return false;
	         }
	    }
		return true;
	}

	@Override
	public boolean validateEmail(String email) {
		if (email == null || email.length() < 5 || !email.contains("@")) {
	         return false;
	    }
		int apeCounter = 0;
		for (int i = 0; i < email.length(); i++) {
	    	 if (email.charAt(i) == '@') {
	            ++apeCounter;
	         }
	    }
	    if (apeCounter > 1) {
	    	return false;
	    }
		return true;
	}
}
