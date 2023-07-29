package com.zakaria.synchronization;

public class SynchronizedCounter {
	
	private int counter;

	public synchronized void increment() {
		counter++;
	}
	
	public synchronized void decrement() {
		counter--;
	}
	
	public int getCounter() {
		return counter;
	}
}
