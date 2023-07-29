package com.zakaria.synchronization;

public class SynchronizedLockCounter {
	
	private final Object lock = new Object();
	
	private int counter;

	public void increment() {
		synchronized (lock) {
			counter++;
		}
	}
	
	public void decrement() {
		synchronized (lock) {
			counter--;
		}
	}
	
	public int getCounter() {
		return counter;
	}
}
