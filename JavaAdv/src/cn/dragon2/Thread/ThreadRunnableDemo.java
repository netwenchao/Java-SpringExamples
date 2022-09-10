package cn.dragon2.Thread;

class ThreadRunnable implements Runnable {
	private String title;

	public ThreadRunnable(String title) {
		this.title = title;
	}

	@Override
	public void run() {
		for (int x = 0; x < 10; x++) {
			System.out.println(title + x);
		}
	}
}

public class ThreadRunnableDemo {
	public static void main(String[] args) {
		new Thread(new ThreadRunnable("A")).start();
		new Thread(new ThreadRunnable("B")).start();
		new Thread(new ThreadRunnable("C")).start();
		
		//使用lamada实现线程定义
		Runnable t=()->{
			for(var i=0;i<10;i++) {
				System.out.println(i);
			}
		};		
		new Thread(t).start();
		
		new Thread(()->{
			for(var i=0;i<10;i++) {
				System.out.println(i);
			}
		}).start();
	}
}
