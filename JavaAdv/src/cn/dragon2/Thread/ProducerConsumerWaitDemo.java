package cn.dragon2.Thread;

class ProducerWait implements Runnable
{
	private MessageWait msg;
	
	public ProducerWait(MessageWait mw) {
		this.msg=mw;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}

class ConsumerWait implements Runnable
{
	private MessageWait msg;
	
	public ConsumerWait(MessageWait mw) {
		this.msg=mw;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}

class MessageWait{
	private String title;
	private String content;
	private Boolean flag;//True:有内容 False:无内容
	public synchronized void set(String title,String content) {
		if(flag) {
			try {
				super.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.title=title;
		this.content=content;
		this.flag=false;
	}
	
	public synchronized String get() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(!flag)
		{
			try {
				super.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return this.title+"-"+this.content;
		
	}
}


public class ProducerConsumerWaitDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
