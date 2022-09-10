package cn.dragon2.Thread;

public class ThreadInterruptDemo {

	public static void main(String[] args) throws InterruptedException {
		Thread t=new Thread(()->{
			System.out.println("Begin to sleep 30 s.");
			try {
				Thread.sleep(30000);
				System.out.println("End of sleep 130 s.");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Sleep is interrupted.");
			}			
		},"");
		
		t.start();
		Thread.sleep(1000);
		if(!t.isInterrupted()) {
			t.interrupt();
		}
	}

}
