package com.zakaria.thread_local;

public class ThreadLocalSharedObject {

    private ThreadLocal<Integer> number = new ThreadLocal<>();

    public void setNumber(Integer value) {
    	number.set(value);
    }

    public Integer getNumber() {
        return number.get();
    }
    
//    public void setARandomNumber() {
//    	int randomNumber = (int) Math.random() * 100;
//    	number.setNumber(randomNumber);
//    	
//    	Utils.sleep(TimeUnit.SECONDS, 1);
//    	
//    	System.out.println("Thread: " + Thread.currentThread().getName());
//    	System.out.println("Value: " + sharedObject.getNumber());
//    }
}
