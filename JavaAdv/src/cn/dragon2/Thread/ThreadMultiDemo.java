package cn.dragon2.Thread;


class ThreadTicket implements Runnable{
	private int ticketCount=5;
	
	@Override
	public void run() {
		while(true) {
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

public class ThreadMultiDemo {
	public static void main(String[] args) {
		ThreadTicket t=new ThreadTicket();
		new Thread(t,"A").start();
		new Thread(t,"B").start();
		new Thread(t,"C").start();
	}
}
