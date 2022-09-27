/*
 * Comparator接口 主要用于解决那些设计时未使用Comparable接口的类的排序问题
 * */
package cn.dragon2.Comp;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorDemo {

	public static void main(String[] args) {
		PersonWithoutComparable[] data = new PersonWithoutComparable[] { new PersonWithoutComparable("C", 99),
				new PersonWithoutComparable("B", 9),
				new PersonWithoutComparable("A", 19)};

		Arrays.sort(data, new PersonComparator());

		System.out.println(Arrays.toString(data));
	}
}

class PersonComparator implements Comparator<PersonWithoutComparable> {

	@Override
	public int compare(PersonWithoutComparable o1, PersonWithoutComparable o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}

}

class PersonWithoutComparable {
	private String name;
	private Integer age;

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public PersonWithoutComparable(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Name:" + this.name + " Age:" + this.age;
	}
}