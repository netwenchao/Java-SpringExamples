package cn.dragon2.Serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String gender;
	private transient int age;

	public Person(String n, String g, int a) {
		this.name = n;
		this.gender = g;
		this.age = a;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "姓名" + name + " 性别" + gender + "年龄" + age;
	}
}

public class SerializeTest {
	private static File objFile = new File("E:\\WorkSpace\\Java\\Person.data");

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Person p1 = new Person("Test", "F", 3);
		System.out.println(p1);
		saveObject(p1);
		Person p2 = (Person) loadObject();
		System.out.println(p2);

	}

	static Object loadObject() throws ClassNotFoundException, IOException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(objFile));
		return ois.readObject();
	}

	static void saveObject(Object o) throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(objFile));
		oos.writeObject(o);
		oos.close();
	}
}
