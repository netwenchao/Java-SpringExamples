package cn.dragon2.Thread;

class Producer implements Runnable{
	private Message ms;
	public Producer(Message msg) {
		this.ms=msg;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(this.ms.getTitle()+"---"+this.ms.getMessage());
		}
	}	
}

class Consumer implements Runnable{
	private Message ms;
	public Consumer(Message msg) {
		this.ms=msg;
	}

	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i%2==0) {
				this.ms.setTitle("A");
				this.ms.setMessage("A:"+i);
			}else {
				this.ms.setTitle("B:"+i);
				this.ms.setMessage("B:"+i);
			}
		}
	}	
}

class Message{
	private String title;
	private String message;
	public String getTitle() {
		return title;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
}

public class ProducerConsumerDemo {

	public static void main(String[] args) {
		Message msg=new Message();
		new Thread(new Producer(msg)).start();
		new Thread(new Consumer(msg)).start();

	}

}
