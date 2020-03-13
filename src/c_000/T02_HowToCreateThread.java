package c_000;

public class T02_HowToCreateThread {
	static class MyThrad extends Thread{
		public void run() {
			System.out.println("in Thread");
		}
	}
	
	static class MyRun implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("in run");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyThrad().start();
		new Thread(new MyRun()).start();
		
		new Thread(()-> {
			System.out.println("Hello, Lamda!");
		}) .start();

	}
	//�����̵߳����ַ�ʽ
	//1 Thread 2 Runnable  3ͨ���̳߳� Executors.newCachedThrad
	

}
