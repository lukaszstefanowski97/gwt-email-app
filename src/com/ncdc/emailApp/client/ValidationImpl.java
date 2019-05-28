package com.ncdc.emailApp.client;

public class ValidationImpl implements Validation{

	@Override
	public boolean validateNameOrSurname(String nameOrSurname) {
	     return nameOrSurname != null && 
	    		 nameOrSurname.matches(Messages.NAME_REGEX);
	}
	
	@Override
	public boolean validatePhone(String phone) {
		return phone != null && 
				phone.matches(Messages.PHONE_REGEX);
	}

	@Override
	public boolean validateEmail(String email) {
		System.out.println(email != null && email.matches(Messages.EMAIL_REGEX));
		return email != null && email.matches(Messages.EMAIL_REGEX);
	}

	@Override
	public boolean validate(String name, String surname, String phone, String email) {
		return validateNameOrSurname(name) && validateNameOrSurname(surname) && 
				validatePhone(phone) && validateEmail(email);
	}
}
