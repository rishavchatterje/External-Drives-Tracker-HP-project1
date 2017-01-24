
package com.hpes.cjmay1;

public class ImplementationClass implements Database {
	String[] usrid = new String[20];
	String[] passwd = new String[20];

	@Override
	public boolean checkAuth(String uid, String pass) {
		boolean b = false;
		for (int i = 0; i < usrid.length; i++) {
			if (usrid[i].equalsIgnoreCase(uid) && passwd.equals(pass)) {
				b = true;
				break;
			}
		}
		return b;
	}

	@Override
	public String signUp(String uid, String pass) {
		int i = usrid.length - 1;
		usrid[i] = uid;
		passwd[i] = pass;

		return "Sign up Sucessfull";
	}

	@Override
	public boolean check(String uid, String pass1, String pass2) {
		boolean b=true;
		if(!pass1.equals(pass2))
			return !b;
		
		for(int i=0;i<usrid.length;i++){
			if(usrid[i].equalsIgnoreCase(uid)){
				b= false;
				break;
			}
		}
		return b;
	}

}
