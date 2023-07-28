package com.zakaria.runnable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class WatchRunnable implements Runnable {
	
	private volatile boolean running = true; // used volatile to avoid thread visibility issue
	
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:s a");

	public void run() {
		while(running) {
			printCurrentTime();
			sleepOneSecond();
		}
	}
	
	private void printCurrentTime() {
		String formattedCurrentTime = LocalDateTime.now().format(formatter);
		System.out.println(Thread.currentThread().getName() + ": " + formattedCurrentTime);
	}
	
	private void sleepOneSecond() {
		try {
			Thread.sleep(TimeUnit.SECONDS.toMillis(1));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void shutdown() {
		this.running = false;
	}
}
