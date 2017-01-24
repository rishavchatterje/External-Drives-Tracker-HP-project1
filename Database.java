package com.hpes.cjmay1;

public interface Database {
	
	boolean checkAuth(String uid,String pass);
	String signUp(String uid,String pass);
	boolean check(String uid,String pass1,String pass2);
	

}
