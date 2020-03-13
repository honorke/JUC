package Singleton;

/**
 * ����ʽ
 * �����ʼ���������̰߳�ȫ����
 * @author KeDong
 *
 */
public class Mgr03 {
	
	private static Mgr03 INSTANCE;
	
	private Mgr03() {
		
	}
	
	//
	public static  synchronized Mgr03 getInstance() {
		if(INSTANCE == null) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			INSTANCE = new Mgr03();
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
