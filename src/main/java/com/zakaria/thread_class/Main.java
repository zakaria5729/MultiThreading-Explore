package com.zakaria.thread_class;

import java.util.concurrent.TimeUnit;

import com.zakaria.utils.Utils;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		WatchThread watchThread = new WatchThread();
		watchThread.setName("Watch-Thread");
		
		WatchThread watchThread2 = new WatchThread();
		watchThread2.setName("Watch-Thread2");
		
		Utils.joinThreads(watchThread, watchThread2);
		
		Thread.sleep(TimeUnit.SECONDS.toMillis(5));
		watchThread.shutdown();
		watchThread2.shutdown();
	}
}
