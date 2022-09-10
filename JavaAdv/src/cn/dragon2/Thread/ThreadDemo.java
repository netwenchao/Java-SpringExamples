package cn.dragon2.Thread;

class MyThread extends Thread {
	private String title;

	public void setTitle(String str) {
		this.title = str;
	}

	@Override
	public void run() {
		for (int x = 0; x < 10; x++) {
			System.out.println(title + x);
		}
	}

}

public class ThreadDemo {
	public static void main(String[] args) {
		MyThread ta = new MyThread();
		ta.setTitle("A");

		MyThread tb = new MyThread();
		tb.setTitle("B");
		
		MyThread tc = new MyThread();
		tc.setTitle("C");

		ta.start();
		tb.start();
		tc.start();
	}
}
