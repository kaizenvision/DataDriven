package com.myexceptin;

public class UserNotFoundException extends Exception {
	
	public UserNotFoundException() {
		super(" user not registered whith system....");
	}

}
