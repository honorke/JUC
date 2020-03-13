package D_001;

public class T1 {
	
	public /*synchronized*/ void test() {
		synchronized (this) {
			System.out.println(Thread.currentThread().getName() + " start");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			System.out.println(Thread.currentThread().getName()+ " end");
			
		}
	}
	
	

}
