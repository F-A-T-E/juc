package com.lvpf.juc.c_026_01_ThreadPool;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class T09_FixedThreadPool {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		getPrime(1,200000);
		long end = System.currentTimeMillis();
		System.out.println(end - start);

		final int cpuCoreNum = 4;

		ExecutorService service = Executors.newFixedThreadPool(cpuCoreNum);

		MyTask t1 = new MyTask(1,80000);
		MyTask t2 = new MyTask(80000,130000);
		MyTask t3 = new MyTask(130001,170000);
		MyTask t4 = new MyTask(170001,200000);


		Future<List<Integer>> f1 = service.submit(t1);
		Future<List<Integer>> f2 = service.submit(t2);
		Future<List<Integer>> f3 = service.submit(t3);
		Future<List<Integer>> f4 = service.submit(t4);

		start = System.currentTimeMillis();
		System.out.println(end - start);
	}
	static class MyTask implements Callable<List<Integer>>{
		int startPos, endPos;

		@Override
		public List<Integer> call() throws Exception {
			return null;
		}
	}

}
