package com.zakaria.synchronization;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCounter {
	
    private final ReentrantLock reentrantLock = new ReentrantLock();
	
	private int counter;

	public void increment() {
		reentrantLock.lock();
		counter++;
		reentrantLock.unlock();
	}
	
	public void decrement() {
		reentrantLock.lock();
		counter--;
		reentrantLock.unlock();
	}
	
	public int getCounter() {
		return counter;
	}
}
