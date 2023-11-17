package com.exception;

public class InvalidPasswordException extends Exception {
	public InvalidPasswordException(String errMesg) {
		super(errMesg);
	}
}
