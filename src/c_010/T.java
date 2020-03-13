package c_010;

import java.util.concurrent.TimeUnit;

public class T {
	
	/**
	 * 锁的是同一个对象
	 */
	synchronized void m() {
		System.out.println("m start");
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("m end");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new TT().m();

	}

}
class TT extends T{
	synchronized void m() {
		System.out.println("child m start");
		super.m();
		System.out.println("child m end");
	}
}
