package c_018_AtomicXXX;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 无锁优化 自旋
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
 * ABA问题
 * A = 1
 * 操作变成2
 * 另一个线程先变成2 再变成1
 * 
 * int类型没关系
 * 其他类型加version,每次修改version+1
 * 加版本号的类 AutomicStampedReference 加一个时间戳
 * 
 * 
 * Unsafe类 使我们有了c++那样的操作内存的能力 cas是unsafe实现的
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
 * allocateInstance直接生成实例
 * 直接操作类或实例变量
 * objectfieldOffset
 * getInt
 * getObject
 * 
 * cas相关操作
 * compareAndSetObject int long
 * 新版本
 * weakCompareAndSetObject
 * 
 * @author KeDong
 *
 */
public class T01_AtomicInteger {
	
	//atomic开头的都是用cas实现的
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
