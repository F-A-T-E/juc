package com.lvpf.juc.c_000;

public class T03_Sleep_Yield_Join {
	public static void main(String[] args) {
			testSleep();
	}
	static void testSleep(){
		new Thread(()->{
			for (int i=0; i<100; i++){
				System.out.println("A" + i);
				try{
					Thread.sleep(500);
				}catch (InterruptedException e){
					e.printStackTrace();
				}
			}
		}).start();
	}

	static void testYield(){
		new Thread(()->{
			for (int i = 0; i < 100; i++) {
				System.out.println("A" + i);
			}
		}).start();
	}
}
