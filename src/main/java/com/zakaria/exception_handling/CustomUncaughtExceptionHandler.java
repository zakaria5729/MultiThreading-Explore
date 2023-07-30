package com.zakaria.exception_handling;

public class CustomUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

	public void uncaughtException(Thread thread, Throwable throwable) {
		System.out.println("Exception has been thrown from: " + thread.getName());
		System.out.println("Exception message: " + throwable.getMessage());
	}

}
