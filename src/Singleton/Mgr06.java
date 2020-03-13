package Singleton;

public class Mgr06 {
	
	private static volatile Mgr06 INSTANCE;
	
	private Mgr06() {
		
	}
	
	
	public static Mgr06 getInstance() {
		if(INSTANCE == null) {
			//双重检查
			synchronized (Mgr06.class) {
				if(INSTANCE == null) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					INSTANCE = new Mgr06();
					/**
					 * 要加volatile
					 * new一个对象分为三部
					 * 第一步申请内存
					 * 第二部对象初始化
					 * 第三步赋值
					 * 
					 * 指令重排序 半初始化 赋值
					 * 
					 * 超高并发 订单 库存
					 * 1000+1 = 1001
					 * 单例看见instance值已经有了，不进入锁 初始化为1
					 * 则成立1
					 * 
					 */
				}
				
			}
		}
		return INSTANCE;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			
			new Thread(  ()->{
				System.out.println(Mgr06.getInstance().hashCode());
			}
					).start();
			
		}
	}

}
