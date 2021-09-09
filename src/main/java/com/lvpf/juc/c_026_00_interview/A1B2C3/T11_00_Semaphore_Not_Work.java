package com.lvpf.juc.c_026_00_interview.A1B2C3;

import java.util.concurrent.Semaphore;

public class T11_00_Semaphore_Not_Work {
	public static void main(String[] args) {
		char[] aI = "1234567".toCharArray();
		char[] aC = "ABCDEFG".toCharArray();
		Semaphore semaphore = new Semaphore(1,true);
//限流
		new Thread(() -> {

			for (char c : aI){
				try{
					semaphore.acquire();
				}catch (InterruptedException e){
					e.printStackTrace();
				}
				System.out.print(c);
				semaphore.release();
			}
		},"t1").start();
	}
}
