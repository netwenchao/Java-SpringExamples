package cn.dragon2.Thread;

class ThreadTicketSyncMethod implements Runnable{
	private int ticketCount=100;
	
	public synchronized boolean sale() 
	{
		if(ticketCount>0)
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"卖票"+ticketCount--);
			return false;
		}
		else
		{
			System.out.println("票卖完了...");
			return true;
		}
	}
	
	@Override
	public void run() {
		while(!this.sale()) {
		}
	}
}

public class ThreadMultiDemoSyncMethod {

	public static void main(String[] args) {
		ThreadTicketSyncMethod t=new ThreadTicketSyncMethod();
		new Thread(t,"A").start();
		new Thread(t,"B").start();
		new Thread(t,"C").start();
	}

}
