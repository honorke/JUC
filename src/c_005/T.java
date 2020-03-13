package c_005;

public class T implements Runnable {
	
	private int count = 100;
	//synchronized既保证了原子性，又保证了可见性
	@Override
	public synchronized void  run() {
		// TODO Auto-generated method stub
		count--;
		System.out.println(Thread.currentThread().getName()+" count = "+count);

	}
	public static void main(String[] args) {
		T t = new T();
		for(int i = 0; i < 100; i++) {
			new Thread(t,"THread"+i).start();
		}
	}

}
