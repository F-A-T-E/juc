package com.lvpf.juc.c_021_02_AQS;

import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {

	private static volatile int i = 0;

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();


		try {
			lock.lock();
		} catch (Exception e) {
			e.printStackTrace();
		}

		i++;

		lock.unlock();
	}

}
