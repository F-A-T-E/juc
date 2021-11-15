package com.lvpf.juc.c_000;
import java.util.concurrent.TimeUnit;

public class T01_WhiteThread {
	private static class T1 extends Thread{
		@Override
		public void run(){
			for (int i = 0; i < 10; i++) {
				try{
					TimeUnit.MILLISECONDS.sleep(1);
				} catch (InterruptedException e){
					e.printStackTrace();
				}
				System.out.println("T1");
			}
		}
		public static void main(String[] args) {
//			new T1().run();
			new T1().start();
			for (int i = 0; i < 10; i++) {
				try{
					TimeUnit.MILLISECONDS.sleep(1);
				}catch (InterruptedException e){
					e.printStackTrace();
				}
				System.out.println("main");
			}
		}
	}
}
