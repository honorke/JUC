package c_001;

//synchorized一把锁，由我占有才运行 想锁谁锁谁，比如目前锁的o这个对象
//对象头64位 markword 01代表锁类型 两位
//锁升级
public class T {
	private int count = 10;
	private Object o = new Object();
	
	public synchronized void m() {
//		synchronized (o) 
		//synchorized(this)等于synchorized这个方法
		//synchorized(T.class)锁定T的对象
		{
			count--;
			System.out.println(Thread.currentThread().getName() + "  count = " + count);
		}
	}
	public static void main(String[] args) {
		T t = new T();
		
		new Thread(()->{
			for(int i = 1; i < 10; i++) {
				t.m();
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
				).start();
		new Thread( ()->{
			for(int i = 0; i < 10; i++) {
				t.m();
				try {
					Thread.sleep(7);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
				).start();
	}

}
