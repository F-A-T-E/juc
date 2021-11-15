/**
 * 弱引用遭遇到gc就会回收
 */


package com.lvpf.juc.c_022_RefTypeAndThreadLocal;

import java.lang.ref.WeakReference;

public class T03_WeakReference {
	public static void main(String[] args) {
		WeakReference<M> m = new WeakReference<>(new M());
//容器    weakhashMap源码  AQS handlerlock的源码
		System.out.println(m.get());
		System.gc();
		System.out.println(m.get());
		ThreadLocal<M> tl = new ThreadLocal<>();
		tl.set(new M());
		tl.remove();
	}
}
