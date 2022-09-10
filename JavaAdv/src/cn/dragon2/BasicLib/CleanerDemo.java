package cn.dragon2.BasicLib;

import java.lang.ref.Cleaner;

class Member implements Runnable {
	public Member() {
		System.out.println("创建...");
	}

	@Override
	public void run() {
		System.out.println("消亡...");
	}
}

class MemberCleaner implements AutoCloseable {
	private static final Cleaner cleaner = Cleaner.create();
	private final Member member;
	private Cleaner.Cleanable cleanable;

	public MemberCleaner() {
		this.member = new Member();
		this.cleanable = cleaner.register(this, this.member);
	}
	
	@Override
	public void close() throws Exception {
		this.cleanable.clean();
	}
}

public class CleanerDemo {
	public static void main(String[] args) {
		try(MemberCleaner cls = new MemberCleaner()){
			//Todo
		}catch(Exception e){
			
		}
	}
}
