package com.lvpf.juc.c_020;

import java.util.concurrent.CountDownLatch;

public class T06_TestCountDownLatch {
	public static void main(String[] args) {
		System.out.println((Math.random()+"").substring(2,8));
		System.out.println((Math.random()*9+1)*Math.pow(10,5));
	}

	private static void usingJoin(){
		Thread[] threads = new Thread[100];
		for (int i = 0; i < threads.length; i ++){
			threads[i] = new Thread(()->{
				int result = 0;
				for (int j = 0; j < 10000; j ++) {
					result += j;
				}
			});
		}
		for (int i = 0; i < threads.length; i ++){
			threads[i].start();
		}
		for (int i = 0; i < threads.length; i ++){
			try{
				threads[i].join();
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		}
		System.out.println("end join");
	}


	private static void usingCountDownLatch(){
		Thread[] threads = new Thread[100];
		CountDownLatch latch = new CountDownLatch(threads.length);
		for (int i = 0; i <threads.length;i++){
			threads[i] = new Thread(()->{
				int result = 0;
				for (int j = 0;j < 10000;j++) {
					result += j;
				}
				latch.countDown();
			});
		}
		for (int i = 0; i < threads.length; i ++){
			threads[i].start();
		}
		try{
			latch.await();
		}catch (InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("end latch");
	}

}
