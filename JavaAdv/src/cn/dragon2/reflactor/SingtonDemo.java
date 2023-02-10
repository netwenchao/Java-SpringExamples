package cn.dragon2.reflactor;

class SingletonDemo {
	private SingletonDemo() {
	}

	private static SingletonDemo instance = null;

	public static SingletonDemo getInstance() {
		if (instance == null) {
			synchronized (SingletonDemo.class) {
				if (instance == null) {
					instance = new SingletonDemo();
					System.out.println("Created...");
				}
			}
		}
		return instance;
	}
	
	public void print() {
		System.out.println("SingletonDemo...");
	}
}

public class SingtonDemo {
	public static void main(String[] args) {
		new Thread(()->{
			SingletonDemo.getInstance().print();
		}).start();
		
		new Thread(()->{
			SingletonDemo.getInstance().print();
		}).start();
		
		new Thread(()->{
			SingletonDemo.getInstance().print();
		}).start();
		
		new Thread(()->{
			SingletonDemo.getInstance().print();
		}).start();
	}
}
