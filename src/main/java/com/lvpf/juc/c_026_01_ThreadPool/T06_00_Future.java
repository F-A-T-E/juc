package com.lvpf.juc.c_026_01_ThreadPool;

import java.util.concurrent.*;

public class T06_00_Future {
	public static void main(String[] args) throws ExecutionException, InterruptedException {

		FutureTask<Integer> task = new FutureTask<>(() -> {
			TimeUnit.MILLISECONDS.sleep(500);
			return 1000;
		});
		// new Callable(){Integer call();}

		new Thread(task).start();

		System.out.println(task.get());//阻塞

		//***************************
		ExecutorService service = Executors.newFixedThreadPool(5);
		Future<Integer> f = service.submit(() -> {
			TimeUnit.MILLISECONDS.sleep(500);
			return 1;
		});
		System.out.println(f.get());
		System.out.println(f.isDone());
	}
}
