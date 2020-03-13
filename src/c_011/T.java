package c_011;

import java.util.concurrent.TimeUnit;

/**
 * ����֮�г����쳣��Ĭ����������ᱻ�ͷ�
 * ���ԣ��ڲ�����������У����쳣Ҫ���С�ģ���Ȼ���ܻᷢ����һ�µ����
 * ���磬��һ��web app��������У����servlet�̹߳�ͬ����һ����Դ����������쳣��������
 * �ڵ�һ���߳����׳��쳣 �����̻߳����ͬ�������� �п��ܻ���ʵ��쳣����ʱ������
 * ��˷ǳ�С��ͬ����������߼�
 * @author KeDong
 *
 */

public class T {
	int count = 0;
	synchronized void m() {
		System.out.println(Thread.currentThread().getName()+" start ");
		while(true) {
			count++;
			System.out.println(Thread.currentThread().getName() + " count = " + count);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(count == 5) {
				int i = 1 / 0; //�˴��׳��쳣�����ᱻ�ͷţ�������뱻�ͷţ����׳��쳣��Ȼ��ѭ������
				System.out.println(i);
			}
			System.out.println("i");
		}
		
	}
	public static void main(String[] args) {
		T t = new T();
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				t.m();
			}
			
			
		};
		
		new Thread(r, "t1").start();
		
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Thread(r, "t2").start();
		
		
	}

}
