package cn.dragon2.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class CompAnsThread implements Callable<String> {
	private Boolean flag = false;

	@Override
	public String call() throws Exception {
		synchronized (this) {
			if (flag) {
				return "抢答失败!" + Thread.currentThread().getName();
			} else {
				this.flag = true;
				return "抢答成功." + Thread.currentThread().getName();
			}
		}
	}
}

public class ThreadCompeteAnswerDemo {

	public static void main(String[] args) {
		CompAnsThread cat = new CompAnsThread();
		FutureTask<String> taskC = new FutureTask<>(cat);
		FutureTask<String> taskA = new FutureTask<>(cat);
		FutureTask<String> taskB = new FutureTask<>(cat);
		
		new Thread(taskA,"A").start();
		new Thread(taskB,"B").start();
		new Thread(taskC,"C").start();
		
		try {
			System.out.println(taskA.get());
			System.out.println(taskB.get());
			System.out.println(taskC.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
