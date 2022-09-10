package cn.dragon2.Thread;

public class ThreadYieldDemo {

	public static void main(String[] args) {
		new Thread(()->{
			for(int i=0;i<100;i++) {
				if(i%3==0) {
					Thread.yield();
					System.out.println(Thread.currentThread().getName()+"yield.");
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"i="+i);
			}
		},"Low").start();

		for(int i=0;i<50;i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Main"+"i="+i);
		}

	}

}
