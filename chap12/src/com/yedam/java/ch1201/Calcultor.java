package com.yedam.java.ch1201;

public class Calcultor {
	private int memory;
	
	public int getMemory() {
		return memory;
	}
	
	//synchronized붙이면 멀티스레드에서 2개의 스레드가 접근할 수 없게 해주는 것.
	public synchronized void setMemory(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {}
		
		Thread info = Thread.currentThread();
		System.out.println("현재 스레드 : "+info.getName()+", memory : "+this.memory);
	}
	
}
