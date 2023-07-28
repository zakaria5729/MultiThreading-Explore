package com.zakaria.runnable;

import java.util.concurrent.TimeUnit;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		WatchRunnable watchRunnable = new WatchRunnable();
		
		Thread watchThread = new Thread(watchRunnable);
		watchThread.setName("Watch-Runnable-Thread");
		watchThread.start();
		
		WatchRunnable watchRunnable2 = new WatchRunnable();
		
		Thread watchThread2 = new Thread(watchRunnable2);
		watchThread2.setName("Watch-Runnable-Thread2");
		watchThread2.start();
		
		Thread.sleep(TimeUnit.SECONDS.toMillis(5));
		watchRunnable.shutdown();
		watchRunnable2.shutdown();
	}
}
