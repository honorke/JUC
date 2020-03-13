package c_008;

import java.util.concurrent.TimeUnit;

public class Account {
	String name;
	double  balance;
	
	/**
	 * 
	 * @param name
	 * @param balance
	 * 脏读
	 */
	public synchronized void set(String name, double balance) {
		this.name = name;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.balance = balance;
	}
	
	public /*synchronized**/ double getBalance(String name) {
		return this.balance;
	}
	
	public static void main(String[] args) {
		Account a = new Account();
		new Thread(()->{
			a.set("张三", 100);
		}
		).start();
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(a.getBalance("张三"));
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(a.getBalance("张三"));
	
	}
}
