package cn.dragon2.Thread;

class ProducerSync implements Runnable{
	private MessageSync ms;
	public ProducerSync(MessageSync msg) {
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
			System.out.println(this.ms.get());
		}
	}	
}

class ConsumerSync implements Runnable{
	private MessageSync ms;
	public ConsumerSync(MessageSync msg) {
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
				this.ms.set("A","A");
			}else {
				this.ms.set("B","B");
			}
		}
	}	
}

class MessageSync{
	private String title;
	private String message;
	public synchronized String get() {
		return this.title+"--"+this.message;
	}
	
	public synchronized void set(String message,String title) {
		this.message = message;
		this.title = title;
	}
}

public class ProducerConsumerSyncDemo {

	public static void main(String[] args) {
		MessageSync msg=new MessageSync();
		new Thread(new ProducerSync(msg)).start();
		new Thread(new ConsumerSync(msg)).start();
	}

}
