package c_001;

//synchorizedһ����������ռ�в����� ����˭��˭������Ŀǰ����o�������
//����ͷ64λ markword 01���������� ��λ
//������
public class T {
	private int count = 10;
	private Object o = new Object();
	
	public synchronized void m() {
//		synchronized (o) 
		//synchorized(this)����synchorized�������
		//synchorized(T.class)����T�Ķ���
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
