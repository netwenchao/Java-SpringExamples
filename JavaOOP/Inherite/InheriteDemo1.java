class Person{
  private String name;
  public Person(String name){
    this.name=name;
    System.out.println("Person Constructor!");
  }
}

class Student extends Person{
  public Student(){
    //super("NoneName");//如果父类没有明确的无参构造，则子类需要明确调用父类有参构造
    System.out.println("Student Constructor!");
  }
}

public class InheriteDemo1 {
  public static void main(String[] args){
    Student std=new Student();
  }
}
