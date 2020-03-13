package Singleton;

;

/**
 * 
 * 
 * @author KeDong
 *
 */
public class Mgr05 {
	
	private static Mgr05 INSTANCE;
	
	private Mgr05() {
		
	}
	
	//
	public static   Mgr05 getInstance() {
		if(INSTANCE == null) {
			//妄图通过缩小代码块的方法 不可行
			synchronized (Mgr05.class) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				INSTANCE = new Mgr05();
				
			}
			
		}
		return INSTANCE; 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int  i = 0; i < 10; i++) {
			new Thread(()->
			{
				System.out.println(Mgr03.getInstance().hashCode());
			}).start(); 
		}

	}

}

