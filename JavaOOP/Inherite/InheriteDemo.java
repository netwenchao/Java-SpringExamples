class Person{
  public Person(){
    System.out.println("Person Constructor!");
  }
}

class Student extends Person{
  public Student(){
    System.out.println("Student Constructor!");
  }
}

public class InheriteDemo{
  public static void main(String[] args){
    /*
     * Person Constructor!
     * Student Constructor!
    */
    Student std=new Student();
  }
}