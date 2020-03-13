package c_000;

import java.util.concurrent.TimeUnit;

public class T01_WhatisThread{
	
	private static class T1 extends Thread{
		public void run() {
			for(int i = 0; i  < 10; i++) {
				try {
					TimeUnit.MICROSECONDS.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("T1");
			}
		}
	}
	
	public static void main(String[] args) {
//		new T1().run();
		//runһ��ִ��·����startһ���µ��߳�
		//�߳� һ���������治ͬ��ִ��·��
		new T1().start();
		for(int i = 0; i < 10; i++) {
			try {
				TimeUnit.MICROSECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("main");
		}
		
	}
}
