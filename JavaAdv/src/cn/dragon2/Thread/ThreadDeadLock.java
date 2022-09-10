package cn.dragon2.Thread;

class Thiref{
	public synchronized void say(Person p) {
		System.out.println("Money!!");
		p.get();
	}
	
	public synchronized void get() {
		System.out.println("Can Pass!");
	}
}
class Person{
	public synchronized void say(Thiref t) {
		System.out.println("Pass!!");
		t.get();
	}
	
	public synchronized void get() {
		System.out.println("Give Money!");
	}
}

class DeadLock implements Runnable{
	Thiref t=new Thiref();
	Person p =new Person();
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}


public class ThreadDeadLock {

	public static void main(String[] args) {
		
	}

}
