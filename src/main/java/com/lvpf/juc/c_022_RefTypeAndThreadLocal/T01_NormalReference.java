package com.lvpf.juc.c_022_RefTypeAndThreadLocal;

import java.io.IOException;
import java.lang.ref.WeakReference;

public class T01_NormalReference {
	public static void main(String[] args)  throws IOException {
		M m = new M();
		m = null;
		System.gc(); //DisableExplicitGC
		System.in.read();
	}
}
