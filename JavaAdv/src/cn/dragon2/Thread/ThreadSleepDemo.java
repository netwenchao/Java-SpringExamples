package cn.dragon2.Thread;

public class ThreadSleepDemo {
	public static void main(String[] args) {
		new Thread(()->{
			for(int i=0;i<10;i++) {
				System.out.println(Thread.currentThread().getName()+"i="+i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"线程A").start();
		
		Runnable r=()->{
			for(int i=0;i<10;i++) {
				System.out.println(Thread.currentThread().getName()+"i="+i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		
		new Thread(r,"A").start();
		new Thread(r,"B").start();
		new Thread(r,"C").start();
		new Thread(r,"D").start();
		
	}
}
