package Singleton;

public class Mgr06 {
	
	private static volatile Mgr06 INSTANCE;
	
	private Mgr06() {
		
	}
	
	
	public static Mgr06 getInstance() {
		if(INSTANCE == null) {
			//˫�ؼ��
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
					 * Ҫ��volatile
					 * newһ�������Ϊ����
					 * ��һ�������ڴ�
					 * �ڶ��������ʼ��
					 * ��������ֵ
					 * 
					 * ָ�������� ���ʼ�� ��ֵ
					 * 
					 * ���߲��� ���� ���
					 * 1000+1 = 1001
					 * ��������instanceֵ�Ѿ����ˣ��������� ��ʼ��Ϊ1
					 * �����1
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
