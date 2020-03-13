package Singleton;

/**
 * 饿汉式
 * 类加载到内存后就实例化一个单例，JVM保证线程安全
 * 简单实用
 * 缺点:不管用到与否，类加载时完成实例化
 * Class.forName("")
 * @author KeDong
 *
 */

public class Mgr01 {
	
	private static final Mgr01 INSTANCE = new Mgr01();
	
	private Mgr01() {}; //别人new不了
	
	public static Mgr01 getInstance() {
		return INSTANCE;
	}
	
	public void m() {
		System.out.println("m");
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mgr01 m1 = Mgr01.getInstance();
		Mgr01 m2 = Mgr01.getInstance();
		
		System.out.println(m1 == m2);

	}

}
