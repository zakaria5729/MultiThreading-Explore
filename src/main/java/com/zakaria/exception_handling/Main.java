package com.zakaria.exception_handling;

import java.util.concurrent.TimeUnit;

import com.zakaria.utils.Utils;

public class Main {
	
	public static void main(String[] args) {
		
		Thread thread = new Thread(() -> {
			Utils.sleep(TimeUnit.SECONDS, 3);
			throw new RuntimeException("Welcome to exception world");
		});
		
		thread.setUncaughtExceptionHandler(new CustomUncaughtExceptionHandler());
		thread.start();

	}
}
