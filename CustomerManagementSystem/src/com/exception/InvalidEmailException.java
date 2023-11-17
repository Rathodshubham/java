package com.exception;


public class InvalidEmailException extends Exception{
		public InvalidEmailException(String errMesg) {
			super(errMesg);
		}
}
