package cn.dragon2.Thread;
import java.util.concurrent.*;

class CallableStr implements Callable<String>{

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		for(var i=0;i<10;i++) {
			System.out.println(i);
		}
		return "完成";
	}
	
}

public class ThreadCallable {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<String> task=new FutureTask<String>(new CallableStr());
		new Thread(task).start();
		System.out.println("线程结果"+task.get());
	}
}
