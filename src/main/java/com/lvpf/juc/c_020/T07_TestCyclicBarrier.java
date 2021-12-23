package com.lvpf.juc.c_020;


import java.util.concurrent.CyclicBarrier;

public class T07_TestCyclicBarrier {
	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(20,() -> System.out.println("manren"));
		for (int i = 0; i < 100; i ++){
			new Thread(()->{
				try{
					barrier.await();
				}catch (Exception e){
					e.printStackTrace();
				}
			}).start();
		}
	}
}
