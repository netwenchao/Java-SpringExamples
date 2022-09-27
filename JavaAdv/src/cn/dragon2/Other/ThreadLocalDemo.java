package cn.dragon2.Other;

public class ThreadLocalDemo {

	public static void main(String[] args) {
		/*
		 * Send Message C-Test B Send Message B-Test B Send Message A-Test B
		 */

		new Thread(() -> {
			(new TDChannel().setMsg(new TDMessage("Test A"))).send();
		}, "A").start();

		new Thread(() -> {
			(new TDChannel().setMsg(new TDMessage("Test B"))).send();
		}, "B").start();

		new Thread(() -> {
			(new TDChannel().setMsg(new TDMessage("Test C"))).send();
		}, "C").start();
		
		//Using TheadLocal
		/*
		Send Message E-Test E
		Send Message D-Test D 
		Send Message F-Test F
		 */
		new Thread(() -> {
			(new TDChannel().setMsg(new TDMessage("Test D"))).send();
		}, "D").start();

		new Thread(() -> {
			(new TDChannel().setMsg(new TDMessage("Test E"))).send();
		}, "E").start();

		new Thread(() -> {
			(new TDChannel().setMsg(new TDMessage("Test F"))).send();
		}, "F").start();

	}
}

class TLChannel {
	// 多实例供用，使用ThreadLocal避免多线程数据错乱
	private static ThreadLocal<TDMessage> message;

	public TLChannel setMsg(TDMessage msg) {
		//使用ThreadLocal.set()设置实例
		message.set(msg);
		return this;
	}

	public void send() {
		//使用ThreadLocal.get()获取实例
		System.out.println("Send Message " + Thread.currentThread().getName() + "-" + message.get().getMsg());
	}
}

class TDChannel {
	// 多实例供用，多线程调用会出现数据错乱
	private static TDMessage msg;

	public TDChannel setMsg(TDMessage msg) {
		TDChannel.msg = msg;
		return this;
	}

	public void send() {
		System.out.println("Send Message " + Thread.currentThread().getName() + "-" + msg.getMsg());
	}
}

class TDMessage {
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public TDMessage(String ms) {
		msg = ms;
	}
}