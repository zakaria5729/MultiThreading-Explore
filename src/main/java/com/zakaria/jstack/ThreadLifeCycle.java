package com.zakaria.jstack;

import java.util.concurrent.TimeUnit;

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

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					TimeUnit.MINUTES.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		
		t1.setName("My Thread # 1");
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				while(!Thread.interrupted()) {
					System.out.println("Running");
				}
			}
		});
		
		t2.setName("My Thread # 2");
		t2.start();
		
		
		// Let's put main thread to sleep as well
		try {
			TimeUnit.SECONDS.sleep(30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t2.interrupt();
	}
}
