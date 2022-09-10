package cn.dragon2.Thread;

class ThreadTicketSync implements Runnable{
	private int ticketCount=100;
	
	@Override
	public void run() {
		while(true) {
			synchronized (this) {
				if(ticketCount>0)
				{
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"卖票"+ticketCount--);
				}
				else
				{
					System.out.println("票卖完了...");
					break;
				}
				
			}
		}
	}
}

public class ThreadMultiDemoSync {

	public static void main(String[] args) {
		ThreadTicketSync t=new ThreadTicketSync();
		new Thread(t,"A").start();
		new Thread(t,"B").start();
		new Thread(t,"C").start();
	}

}
