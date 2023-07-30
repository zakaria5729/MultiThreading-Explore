package com.zakaria.jstack;

import java.util.concurrent.TimeUnit;

import com.zakaria.utils.Utils;

public class ThreadLifeCycle {
	
	/**
	 * 1. Creation State
	 * 2. Runnable State
	 * 3. Blocked State
	 * 4. Waiting State
	 * 5. Timed Waiting State
	 * 6. Terminated State
	 */

	public static void main(String[] args) {

		Thread t1 = new Thread(() -> {
			Utils.sleep(TimeUnit.MINUTES, 10);
		});

		t1.setName("My Thread # 1");
		
		Thread t2 = new Thread(() -> {
			while(!Thread.interrupted()) {
				System.out.println("Running");
			}
		});
		
		t2.setName("My Thread # 2");
		
		Utils.joinThreads(t1, t2);
		
		// Let's put main thread to sleep as well
		Utils.sleep(TimeUnit.SECONDS, 30);
		
		t2.interrupt();
	}
}
