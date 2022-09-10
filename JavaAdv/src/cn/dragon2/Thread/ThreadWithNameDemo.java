package cn.dragon2.Thread;

class ThreadWithName implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
}

public class ThreadWithNameDemo {
	public static void main(String[] args) {
		ThreadWithName demoT=new ThreadWithName();
		new Thread(demoT,"Demo Thread").start();
		demoT.run();
	}
}