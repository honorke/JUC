package c_000;
/**
 * 
 * @author KeDong
 * netty interupt jdk 锁 interupt
 * 不要用interupt控制业务逻辑
 * 除非起来非常长的，想stop,interupt然后catch interupt异常
 *getState得到状态
 */
public class T03_Sleep_Yield_Join {
	
	//sleep完回到就绪
	static void testSleep() {
		new Thread( () -> {
			for(int j = 0; j < 100; j++) {
				System.out.println("A"+j);
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		).start();
	}
	
	//yield等待队列，让出一下cpu,返回就绪状态
	static void testYield() {
		new Thread( ()->{
			for(int i = 0; i < 100; i++) {
				System.out.println("---B"+i);
				
				if(i%10 == 0) Thread.yield();
			}
			
			
		}
				).start();
	}
	//运行着呢，把线程让给别人，等别人完成继续运行
	static void testJoin() {
		Thread t1 = new Thread( ()->{
			for(int i = 0; i < 100; i++) {
				System.out.println("A"+i);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
				);
		
		Thread t2 = new Thread(
				()->{
					
					try {
						Thread.sleep(10);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("before");
					try {
						t1.join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("after");
				}
				);
		
		t1.start();
		t2.start();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		testJoin();

	}

}
