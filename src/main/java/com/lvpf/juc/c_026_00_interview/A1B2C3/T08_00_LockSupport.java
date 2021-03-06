package com.lvpf.juc.c_026_00_interview.A1B2C3;

import java.util.concurrent.locks.LockSupport;

public class T08_00_LockSupport {
	static Thread t1 = null,t2 = null;
	public static void main(String[] args) throws Exception{
		char[] aI = "1234567".toCharArray();
		char[] aC = "ABCDEFG".toCharArray();
		t1 = new Thread(() ->{
			for (char c: aI) {
				System.out.printf(c + " - ");
				LockSupport.unpark(t2);//叫醒t2
				LockSupport.park();//T1阻塞
			}
		},"t1");
		t2 = new Thread(() -> {
			for (char c : aC) {
				LockSupport.park();//t2阻塞
				System.out.println(c + " - ");
				LockSupport.unpark(t1); //叫醒t1
			}
		},"t2");
		t1.start();
		t2.start();
	}
}
