package com.zakaria.synchronization;

import com.zakaria.utils.Utils;

public class Main {

	public static void main(String[] args) {

		System.out.println("Counter thread starting...");
		final Counter counter = new Counter();

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 300; i++) {
				counter.increment();
				Utils.sleep(10);
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 300; i++) {
				counter.decrement();
				Utils.sleep(10);
			}
		});

		long startTime1 = System.nanoTime();

		Utils.startThreads(t1, t2);
		Utils.joinThreads(t1, t2);

		long endTime1 = System.nanoTime();
		long totalDuration1 = endTime1 - startTime1;

		System.out.println("Counter: " + counter.getCounter());
		System.out.println("Counter Duration: " + totalDuration1 + " nano second");

		
		
		// Synchronized
		System.out.println("\nSynchronized counter thread starting...");
		final SynchronizedCounter synchronizedCounter = new SynchronizedCounter();

		Thread t3 = new Thread(() -> {
			for (int i = 0; i < 300; i++) {
				synchronizedCounter.increment();
				Utils.sleep(10);
			}
		});

		Thread t4 = new Thread(() -> {
			for (int i = 0; i < 300; i++) {
				synchronizedCounter.decrement();
				Utils.sleep(10);
			}
		});

		long startTime2 = System.nanoTime();

		Utils.startThreads(t3, t4);
		Utils.joinThreads(t3, t4);

		long endTime2 = System.nanoTime();
		long totalDuration2 = endTime2 - startTime2;

		System.out.println("SynchronizedCounter: " + synchronizedCounter.getCounter());
		System.out.println("SynchronizedCounter Duration: " + totalDuration2 + " nano second");
		System.out.println("Difference of synchronized duration: " + (totalDuration2 - totalDuration1) + " nano second");

		
		
		// Synchronized Lock
		System.out.println("\nSynchronizedLock counter thread starting...");
		final SynchronizedLockCounter synchronizedLockCounter = new SynchronizedLockCounter();

		Thread t5 = new Thread(() -> {
			for (int i = 0; i < 300; i++) {
				synchronizedLockCounter.increment();
				Utils.sleep(10);
			}
		});

		Thread t6 = new Thread(() -> {
			for (int i = 0; i < 300; i++) {
				synchronizedLockCounter.decrement();
				Utils.sleep(10);
			}
		});

		long startTime3 = System.nanoTime();

		Utils.startThreads(t5, t6);
		Utils.joinThreads(t5, t6);

		long endTime3 = System.nanoTime();
		long totalDuration3 = endTime3 - startTime3;

		System.out.println("SynchronizedLockCounter: " + synchronizedLockCounter.getCounter());
		System.out.println("SynchronizedLockCounter Duration: " + totalDuration3 + " nano second");
		System.out.println("Difference of synchronizedLock duration: " + (totalDuration3 - totalDuration1) + " nano second");
	
		
		
		// ReentrantLock
		System.out.println("\nReentrantLock counter thread starting...");
		final ReentrantLockCounter reentrantLockCounter = new ReentrantLockCounter();

		Thread t7 = new Thread(() -> {
			for (int i = 0; i < 300; i++) {
				reentrantLockCounter.increment();
				Utils.sleep(10);
			}
		});

		Thread t8 = new Thread(() -> {
			for (int i = 0; i < 300; i++) {
				reentrantLockCounter.decrement();
				Utils.sleep(10);
			}
		});

		long startTime4 = System.nanoTime();

		Utils.startThreads(t7, t8);
		Utils.joinThreads(t7, t8);

		long endTime4 = System.nanoTime();
		long totalDuration4 = endTime4 - startTime4;

		System.out.println("ReentrantLockCounter: " + synchronizedLockCounter.getCounter());
		System.out.println("ReentrantLock Duration: " + totalDuration4 + " nano second");
		System.out.println("Difference of reentrantLock duration: " + (totalDuration4 - totalDuration1) + " nano second");

	}
}
