package cn.dragon2.Thread;

class Computer
{
	private static int count;
	private String name;
	private double price;
	
	public Computer(String name,double pr) {
		this.name=name;
		this.price=pr;
		count++;
	}
	
	public String toString() {
		return "第"+count+"台电脑"+this.name+" 价格 "+this.price;
	}
}

class ComputerRes
{
	//false:需要生成
	//true:需要搬运
	private Boolean flag=false;
	private Computer com=null;
	
	public synchronized void make() throws InterruptedException {
		if(this.flag) {
			System.out.println("需要搬运");
			super.wait();
		}
		this.com=new Computer("电脑",33);
		this.flag=true;
		super.notifyAll();
	}
	
	public synchronized void get() throws InterruptedException {
		if(!this.flag) {
			System.out.println("需要生产");
			super.wait();
		}
		System.out.println(this.com.toString());
		this.com=null;
		this.flag=false;
		super.notifyAll();
	}
}

class ProducerComp implements Runnable{
	ComputerRes res;
	
	public ProducerComp(ComputerRes r) {
		this.res=r;
	}
	
	@Override
	public void run() {
		for(int i=0;i<50;i++) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				this.res.make();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class ConsumerComp implements Runnable{
	ComputerRes res;
	
	public ConsumerComp(ComputerRes r) {
		this.res=r;
	}
	
	@Override
	public void run() {
		for(int i=0;i<50;i++) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				this.res.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


public class ThreadProdCompDemo {

	public static void main(String[] args) {
		ComputerRes res=new ComputerRes();
		new Thread(new ProducerComp(res)).start();
		new Thread(new ConsumerComp(res)).start();
	}

}
