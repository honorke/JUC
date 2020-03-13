package c_012;

import java.util.concurrent.TimeUnit;

//看设计模式 坦克
public class T {
	//加了volatile就能停止
	//volatile可见的
	/***
	 * 保证线程可见性
	 * 禁止指令重排序
	 *   DCL
	 *   Double Check  Lock
	 *   Mgr06.java
	 *   
	 *   
	 *   保证线程可见性
	 *   对running的更改 不知道什么时候while中的running改变
	 *   加了volatile之后 一个线程的改变会被另一个线程知道
	 *   MESI 缓冲一致性协议
	 *   
	 *   cpu流水线式执行 指令对指令重新排顺序
	 *   
	 */
	volatile boolean running = true;
	void m() {
		System.out.println("m start");
		
		//模拟服务器
		while(running) {
			
		}
		
		System.out.println("m end");
	}
	
	public static void main(String[] args) {
		T t = new T();
		
		new Thread(t::m, "t1").start();
		//lambda表达式 new Thread(new Runnable(run(){m()}))
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t.running = false;
	}

}
