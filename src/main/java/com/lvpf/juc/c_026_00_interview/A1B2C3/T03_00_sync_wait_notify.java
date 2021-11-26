package com.lvpf.juc.c_026_00_interview.A1B2C3;

import java.util.concurrent.CountDownLatch;

public class T03_00_sync_wait_notify {
	private static volatile boolean t2Started = false;

	public static void main(String[] args) {
		final Object o = new Object();

		char[] aI = "1234567".toCharArray();
		char[] aC = "ABCDEFG".toCharArray();

		new Thread(()->{
//			latch.await();
			synchronized (o){

				while(!t2Started){
					try{
						o.wait();
					}catch (InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		},"t1").start();

		new Thread(()->{
			synchronized (o){

				for (char c : aC){
					System.out.print(c);
					//latch
					t2Started = true;
					try{
						o.notify();
						o.wait();
					}catch (InterruptedException e){
						e.printStackTrace();
					}
				}
				o.notify();
			}
		},"t2").start();

	}

}
