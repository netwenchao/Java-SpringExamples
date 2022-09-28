package cn.dragon2.Thread;

class Resource
{
	private int num;
	//true 可以进行加法
	//false 可以进行减法
	private Boolean flag=false;
	
	public synchronized void add() throws InterruptedException {
		if(!this.flag) {
			System.out.println("需要减法操作，等待中...");
			super.wait();
		}
		
		Thread.sleep(100);
		
		this.num++;
		this.flag=false;//需进行减法操作
		System.out.println("加法操作-"+Thread.currentThread().getName()+"  "+this.num);
		super.notifyAll();
	}
	
	public synchronized void sub() throws InterruptedException {
		if(this.flag) {
			System.out.println("需要加法操作，等待中...");
			super.wait();
		}
		
		Thread.sleep(200);		
		
		this.num--;
		System.out.println("减法操作-"+Thread.currentThread().getName()+"  "+this.num);
		this.flag=true;
		super.notifyAll();
	}
}

class AddThread implements Runnable{
	Resource res;
	public AddThread(Resource r) {
		this.res=r;
	}
	
	@Override
	public void run() {
		for(int i=0;i<50;i++) {
			try {
				this.res.add();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

class SubThread implements Runnable{
	Resource res;
	public SubThread(Resource r) {
		this.res=r;
	}
	
	@Override
	public void run() {
		for(int i=0;i<50;i++) {
			try {
				this.res.sub();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}



public class ThreadPlusSubDemo {

	public static void main(String[] args) {
		Resource res=new Resource();
		AddThread at= new AddThread(res);
		new Thread(at,"加法线程-A").start();
		new Thread(at,"加法线程-B").start();
		
		SubThread st= new SubThread(res);
		new Thread(st,"加法线程-A").start();
		new Thread(st,"加法线程-B").start();
	}
}
