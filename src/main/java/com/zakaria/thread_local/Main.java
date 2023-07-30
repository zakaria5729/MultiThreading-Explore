package com.zakaria.thread_local;

import java.util.concurrent.TimeUnit;

import com.zakaria.utils.Utils;

public class Main {
	
	public static void main(String[] args) {
		
		ThreadLocalSharedObject sharedObject = new ThreadLocalSharedObject();
		sharedObject.setNumber(10);
		
		Thread t1 = new Thread(() -> {
			sharedObject.setNumber(20);
			
			Utils.sleep(TimeUnit.SECONDS, 1);
	    	System.out.println(Thread.currentThread().getName() + ": " + sharedObject.getNumber());
		});
		
		Thread t2 = new Thread(() -> {
			sharedObject.setNumber(30);
			
			Utils.sleep(TimeUnit.SECONDS, 1);
	    	System.out.println(Thread.currentThread().getName() + ": " + sharedObject.getNumber());
		});
		
		t1.setName("Thread-1");
		t2.setName("Thread-2");
		
		Utils.startThreads(t1, t2);
		Utils.joinThreads(t1, t2);
		
    	System.out.println("Thread " + Thread.currentThread().getName() + ": " + sharedObject.getNumber());

	}
}
