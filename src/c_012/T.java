package c_012;

import java.util.concurrent.TimeUnit;

//�����ģʽ ̹��
public class T {
	//����volatile����ֹͣ
	//volatile�ɼ���
	/***
	 * ��֤�߳̿ɼ���
	 * ��ָֹ��������
	 *   DCL
	 *   Double Check  Lock
	 *   Mgr06.java
	 *   
	 *   
	 *   ��֤�߳̿ɼ���
	 *   ��running�ĸ��� ��֪��ʲôʱ��while�е�running�ı�
	 *   ����volatile֮�� һ���̵߳ĸı�ᱻ��һ���߳�֪��
	 *   MESI ����һ����Э��
	 *   
	 *   cpu��ˮ��ʽִ�� ָ���ָ��������˳��
	 *   
	 */
	volatile boolean running = true;
	void m() {
		System.out.println("m start");
		
		//ģ�������
		while(running) {
			
		}
		
		System.out.println("m end");
	}
	
	public static void main(String[] args) {
		T t = new T();
		
		new Thread(t::m, "t1").start();
		//lambda���ʽ new Thread(new Runnable(run(){m()}))
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t.running = false;
	}

}
