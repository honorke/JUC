package c_009;

import java.util.concurrent.TimeUnit;

/**
 * һ��ͬ���������Ե�����һ��ͬ��������һ���߳��Ѿ�ӵ��ĳ������������ٴ�����
 * ��ʱ����Ȼ��õ��ö��������Ҳ����˵synchronized��õ����ǿ������
 * @author KeDong
 *
 */

public class T {
	synchronized void m1() {
		System.out.println("m1 start");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m2();
		System.out.println("m2 end");
	}

	synchronized void m2() {
		// TODO Auto-generated method stub
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
