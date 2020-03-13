package c_000;
/**
 * 
 * @author KeDong
 * netty interupt jdk �� interupt
 * ��Ҫ��interupt����ҵ���߼�
 * ���������ǳ����ģ���stop,interuptȻ��catch interupt�쳣
 *getState�õ�״̬
 */
public class T03_Sleep_Yield_Join {
	
	//sleep��ص�����
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
	
	//yield�ȴ����У��ó�һ��cpu,���ؾ���״̬
	static void testYield() {
		new Thread( ()->{
			for(int i = 0; i < 100; i++) {
				System.out.println("---B"+i);
				
				if(i%10 == 0) Thread.yield();
			}
			
			
		}
				).start();
	}
	//�������أ����߳��ø����ˣ��ȱ�����ɼ�������
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
