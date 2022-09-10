package cn.dragon2.BasicLib;

interface IMessage extends AutoCloseable {
	void send();
}

class NetMessage implements IMessage {
	private String messsage;

	public NetMessage(String msg) {
		this.messsage = msg;
	}

	public Boolean open() {
		System.out.println("打开连接，准备发送...");
		return true;
	}

	@Override
	public void close() {
		System.out.println("关闭连接");
	}

	@Override
	public void send() {
		if (this.open()) {
			System.out.println("发送数据：" + this.messsage);
		}
	}
}

public class AutoCloseableDemo {

	public static void main(String[] args) throws Exception {
		try (IMessage msg = new NetMessage("待发送的消息...")) {
			msg.send();
		}
	}

}
