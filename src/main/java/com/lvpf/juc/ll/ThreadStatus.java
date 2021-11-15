package com.lvpf.juc.ll;

import java.util.concurrent.locks.LockSupport;

public class ThreadStatus {
	public static void main(String[] args) {
		Object o = new Object();
//		0
			new Thread(()->{
				synchronized (o){
				System.out.println(Thread.currentThread().getName() + "------" +System.currentTimeMillis());
					try {
						o.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + "-------" +System.currentTimeMillis());
			}).start();
//		1
			new Thread(()->{
				System.out.println(Thread.currentThread().getName() + "------" +System.currentTimeMillis());
				synchronized (o){
					o.notify();
				}
				/**
				 *执行完synchronized语句块始放o的对象锁
				 *
				 */
				System.out.println(Thread.currentThread().getName() + "-------" +System.currentTimeMillis());
			}).start();
//      2
			new Thread(()->{
				System.out.println(Thread.currentThread().getName() + "-------" +System.currentTimeMillis());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "-------" +System.currentTimeMillis());
			}).start();

//         3
		Thread a = new Thread(()->{
			System.out.println(Thread.currentThread().getName() + "-------" +System.currentTimeMillis());
			LockSupport.park();
			System.out.println(Thread.currentThread().getName() + "----444444---" +System.currentTimeMillis());
		});
		a.start();

//		    4
		new Thread(()->{
			System.out.println(Thread.currentThread().getName() + "-------" +System.currentTimeMillis());
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			LockSupport.unpark(a);
			System.out.println(Thread.currentThread().getName() + "-------" +System.currentTimeMillis());
		}).start();


		/**
		 * 从 Runnable 状态进入到 Blocked 状态只有一种途径，那么就是当进入到 synchronized 代码块中时未能获得相应的 monitor 锁
		 * 或者  线程的wait()被notify()、notifyAll()后的语句块还未完成、（！完成后，对象锁可能属于其他的wait）原语句块未获取到对象锁时
		 * 线程处于阻塞状态
		 */
	}
}
