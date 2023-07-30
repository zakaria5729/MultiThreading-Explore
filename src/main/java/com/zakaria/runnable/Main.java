package com.zakaria.runnable;

import java.util.concurrent.TimeUnit;

import com.zakaria.utils.Utils;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		WatchRunnable watchRunnable = new WatchRunnable();
		Thread watchThread = new Thread(watchRunnable);
		watchThread.setName("Watch-Runnable-Thread");
		
		WatchRunnable watchRunnable2 = new WatchRunnable();
		Thread watchThread2 = new Thread(watchRunnable2);
		watchThread2.setName("Watch-Runnable-Thread2");
		
		Utils.joinThreads(watchThread, watchThread2);
		
		Thread.sleep(TimeUnit.SECONDS.toMillis(5));
		watchRunnable.shutdown();
		watchRunnable2.shutdown();
	}
}
