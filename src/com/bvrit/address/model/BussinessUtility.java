package com.bvrit.address.model;

public class BussinessUtility {
	public boolean validateUser(String user,String password) {
		boolean result = false;
		if(user.equals("bvrit") && password.equals("12345")) {
			result = true;
		}
		return result;
		
	}
}
