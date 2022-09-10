package cn.dragon2.BasicLib;

class MemberCloneable implements Cloneable {
	private String name;
	private int age;

	public MemberCloneable(String nm, int age) {
		this.name = nm;
		this.age = age;
	}

	@Override
	public String toString() {
		return "[" + super.toString() + "]name=" + this.name + " age=" + this.age;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

public class CloneableDemo {

	public static void main(String[] args) throws CloneNotSupportedException {
		MemberCloneable m = new MemberCloneable("Test", 99);
		System.out.println(m);
		MemberCloneable c = (MemberCloneable) m.clone();
		System.out.println(c);
	}

}
