package com.zakaria.thread_class;

import java.util.concurrent.TimeUnit;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		WatchThread watchThread = new WatchThread();
		watchThread.setName("Watch-Thread");
		watchThread.start();
		
		WatchThread watchThread2 = new WatchThread();
		watchThread2.setName("Watch-Thread2");
		watchThread2.start();
		
		Thread.sleep(TimeUnit.SECONDS.toMillis(5));
		watchThread.shutdown();
		watchThread2.shutdown();
	}
}
