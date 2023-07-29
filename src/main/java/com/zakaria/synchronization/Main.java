package com.zakaria.synchronization;

public class Main {

	public static void main(String[] args) {

		System.out.println("Counter thread starting...");
		final Counter counter = new Counter();

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 300; i++) {
					counter.increment();
					sleep();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 300; i++) {
					counter.decrement();
					sleep();
				}
			}
		});

		long startTime1 = System.nanoTime();

		startThreads(t1, t2);
		joinThreads(t1, t2);

		long endTime1 = System.nanoTime();
		long totalDuration1 = endTime1 - startTime1;

		System.out.println("Counter: " + counter.getCounter());
		System.out.println("Counter Duration: " + totalDuration1 + " nano second");

		
		
		// Synchronized
		System.out.println("\nSynchronized counter thread starting...");
		final SynchronizedCounter synchronizedCounter = new SynchronizedCounter();

		Thread t3 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 300; i++) {
					synchronizedCounter.increment();
					sleep();
				}
			}
		});

		Thread t4 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 300; i++) {
					synchronizedCounter.decrement();
					sleep();
				}
			}
		});

		long startTime2 = System.nanoTime();

		startThreads(t3, t4);
		joinThreads(t3, t4);

		long endTime2 = System.nanoTime();
		long totalDuration2 = endTime2 - startTime2;

		System.out.println("SynchronizedCounter: " + synchronizedCounter.getCounter());
		System.out.println("SynchronizedCounter Duration: " + totalDuration2 + " nano second");
		System.out.println("Difference of synchronized duration: " + (totalDuration2 - totalDuration1) + " nano second");

		
		
		// Synchronized Lock
		System.out.println("\nSynchronizedLock counter thread starting...");
		final SynchronizedLockCounter synchronizedLockCounter = new SynchronizedLockCounter();

		Thread t5 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 300; i++) {
					synchronizedLockCounter.increment();
					sleep();
				}
			}
		});

		Thread t6 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 300; i++) {
					synchronizedLockCounter.decrement();
					sleep();
				}
			}
		});

		long startTime3 = System.nanoTime();

		startThreads(t5, t6);
		joinThreads(t5, t6);

		long endTime3 = System.nanoTime();
		long totalDuration3 = endTime3 - startTime3;

		System.out.println("SynchronizedLockCounter: " + synchronizedLockCounter.getCounter());
		System.out.println("SynchronizedLockCounter Duration: " + totalDuration3 + " nano second");
		System.out.println("Difference of synchronizedLock duration: " + (totalDuration3 - totalDuration1) + " nano second");
	
		
		
		// ReentrantLock
		System.out.println("\nReentrantLock counter thread starting...");
		final ReentrantLockCounter reentrantLockCounter = new ReentrantLockCounter();

		Thread t7 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 300; i++) {
					reentrantLockCounter.increment();
					sleep();
				}
			}
		});

		Thread t8 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 300; i++) {
					reentrantLockCounter.decrement();
					sleep();
				}
			}
		});

		long startTime4 = System.nanoTime();

		startThreads(t7, t8);
		joinThreads(t7, t8);

		long endTime4 = System.nanoTime();
		long totalDuration4 = endTime4 - startTime4;

		System.out.println("ReentrantLockCounter: " + synchronizedLockCounter.getCounter());
		System.out.println("ReentrantLock Duration: " + totalDuration4 + " nano second");
		System.out.println("Difference of reentrantLock duration: " + (totalDuration4 - totalDuration1) + " nano second");

	}

	private static void startThreads(Thread... threads) {
		for (Thread thread : threads) {
			thread.start();
		}
	}

	private static void joinThreads(Thread... threads) {
		try {
			for (Thread thread : threads) {
				thread.join();
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			throw new AssertionError(e);
		}
	}

	private static void sleep() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			throw new AssertionError(e);
		}
	}
}
