package D_001;

public class Test {
	public static void main(String[] args) {
		for(int i = 1; i <=5; i++) {
			new Thread(()->{
				T1 t = new T1();
				t.test();
				
			}
					).start();;
		}
	}

}
