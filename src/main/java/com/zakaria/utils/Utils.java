package com.zakaria.utils;

import java.util.concurrent.TimeUnit;

public final class Utils {
	
	private Utils() {}
	
	public static void startThreads(Thread... threads) {
		for (Thread thread : threads) {
			thread.start();
		}
	}

	public static void joinThreads(Thread... threads) {
		try {
			for (Thread thread : threads) {
				thread.join();
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			throw new AssertionError(e);
		}
	}

	public static void sleep(long miliseconds) {
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			System.err.println("Thread interrupted due to: " + e.getMessage());
			Thread.currentThread().interrupt();
			throw new AssertionError(e);
		}
	}
	
	public static void sleep(TimeUnit timeUnit, int value) {
		try {
			timeUnit.sleep(value);;
		} catch (InterruptedException e) {
			System.err.println("Thread interrupted due to: " + e.getMessage());
			Thread.currentThread().interrupt();
			throw new AssertionError(e);
		}
	}
}
