package cn.dragon2.Thread;

public class ThreadPriorityDemo {

	public static void main(String[] args) {
		Runnable r=()->{
			for(int i=0;i<100;i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+Thread.currentThread().getPriority()+" i= "+i);
			}
		};
		
		Thread th = new Thread(r,"Hig->");
		th.setPriority(Thread.MAX_PRIORITY);
		th.start();
		
		Thread tnor = new Thread(r,"Nor->");
		tnor.setPriority(Thread.MIN_PRIORITY);
		tnor.start();
		
		Thread tmin = new Thread(r,"Min->");
		tmin.setPriority(Thread.MIN_PRIORITY);
		tmin.start();
		
		System.out.println(Thread.currentThread().getPriority());
	}
}
