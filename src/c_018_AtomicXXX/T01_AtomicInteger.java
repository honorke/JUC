package c_018_AtomicXXX;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * �����Ż� ����
 * cas compare and set
 * cas(v, expected, newvalue)
 * {
 * 		if v == E
 *         v = new
 *      otherwise try again or fail
 * 
 * }
 * 
 * 
 * ABA����
 * A = 1
 * �������2
 * ��һ���߳��ȱ��2 �ٱ��1
 * 
 * int����û��ϵ
 * �������ͼ�version,ÿ���޸�version+1
 * �Ӱ汾�ŵ��� AutomicStampedReference ��һ��ʱ���
 * 
 * 
 * Unsafe�� ʹ��������c++�����Ĳ����ڴ������ cas��unsafeʵ�ֵ�
 * private unsafe();
 * private static final Unsafe theUnsafe = new Unsafe();
 * 
 * public static Unsafe getUnsaft(){
 * return  theUnsafe;
 * }
 * 
 * public long allocateMemory(Long bytes){
 * allocateMemoryCheck(bytes)
 * 
 * }
 * 
 * allocateInstanceֱ������ʵ��
 * ֱ�Ӳ������ʵ������
 * objectfieldOffset
 * getInt
 * getObject
 * 
 * cas��ز���
 * compareAndSetObject int long
 * �°汾
 * weakCompareAndSetObject
 * 
 * @author KeDong
 *
 */
public class T01_AtomicInteger {
	
	//atomic��ͷ�Ķ�����casʵ�ֵ�
	AtomicInteger count = new AtomicInteger(0);
	
	void m() {
		for(int i = 0; i < 1000; i++) {
			count.incrementAndGet();//count++
		}
	}
	
	
	public static void main(String[] args) {
		T01_AtomicInteger t = new T01_AtomicInteger();
		List<Thread> threads = new ArrayList<>();
		
		for(int i = 0; i < 10; i++) {
			threads.add(new Thread(t::m, "thread-"+i));
		}
		
		threads.forEach((o)->o.start());
		
		threads.forEach((o)-> {
			try {
				o.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		System.out.println(t.count);
	}

}
