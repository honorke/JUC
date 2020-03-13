package c_013;

import java.util.ArrayList;
import java.util.List;

/**
 * volatile�����ܱ�֤����̹߳�ͬ�޸�running����ʱ�����Ĳ�һ������
 * Ҳ����˵volatile�������synchronized
 * @author KeDong
 *
 */
public class T {
	volatile int count = 0;
	synchronized void m() {
		for(int i = 0; i < 10000; i ++) {
			count++;
		}
	}
	
	public static void main(String[] args) {
		T t = new T();
		
		List<Thread> threads = new ArrayList<>();
		
		for(int i = 0; i < 10; i++) {
			threads.add(new Thread(t::m, "thread-"+i));
		}
		
		threads.forEach((o)->o.start());
		
		threads.forEach(
				(o)->{
					try {
						o.join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				);
		
		System.out.println(t.count);
		
	}
	

}
