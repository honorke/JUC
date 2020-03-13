package c_011;

import java.util.concurrent.TimeUnit;

/**
 * 程序之中出现异常，默认情况下锁会被释放
 * 所以，在并发处理过程中，有异常要多加小心，不然可能会发生不一致的情况
 * 比如，在一个web app处理过程中，多个servlet线程共同访问一个资源，这是如果异常处理不合适
 * 在第一个线程中抛出异常 其他线程会进入同步代码区 有可能会访问到异常产生时的数据
 * 因此非常小心同步事务处理的逻辑
 * @author KeDong
 *
 */

public class T {
	int count = 0;
	synchronized void m() {
		System.out.println(Thread.currentThread().getName()+" start ");
		while(true) {
			count++;
			System.out.println(Thread.currentThread().getName() + " count = " + count);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(count == 5) {
				int i = 1 / 0; //此处抛出异常，锁会被释放，如果不想被释放，可抛出异常，然后循环继续
				System.out.println(i);
			}
			System.out.println("i");
		}
		
	}
	public static void main(String[] args) {
		T t = new T();
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				t.m();
			}
			
			
		};
		
		new Thread(r, "t1").start();
		
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Thread(r, "t2").start();
		
		
	}

}
