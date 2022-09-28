package cn.dragon2.Comp;

import java.util.Arrays;

public class SortDemo {

	public static void main(String[] args) {
		String[] arr = new String[] { "B", "C", "A", "Q", "F" };
		Arrays.sort(arr);

		// A,B,C,F,Q
		System.out.println(String.join(",", arr));

		PersonCompareable[] psoncs = new PersonCompareable[] { 
				new PersonCompareable("B", 99),
				new PersonCompareable("A", 10), 
				new PersonCompareable("F", 22) 
		};
		
		Arrays.sort(psoncs);
		

		Person[] psons = new Person[] { new Person("B", 99), new Person("A", 10), new Person("F", 22) };
		// java.lang.ClassCastException: class cn.dragon2.Comp.Person cannot be cast to
		// class java.lang.Comparable
		Arrays.sort(psons);
		System.out.println(psoncs);
		
	}

}

//如果需要实现对象的比较需要实现Compareable接口
class Person {
	private String name;
	private Integer age;

	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name:" + this.name + ",Age=" + this.age;
	}
}

class PersonCompareable implements Comparable<PersonCompareable> {
	private String name;
	private Integer age;

	public PersonCompareable(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(PersonCompareable o) {
		// TODO Auto-generated method stub
		return this.name.compareTo(o.name);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name:" + this.name + ",Age=" + this.age;
	}

}