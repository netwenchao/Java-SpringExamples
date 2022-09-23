
class Channel{
  public void connect(){
      System.out.println("Channel connecting...");
  }
}

class DatabaseChannel extends Channel{
  //保留已有方法名称进行覆写.
  public void connect(){
    //super.connect();//调用父类connect方法
      System.out.println("Database Channel connecting...");
  }
}

public class InheriteDemo2{
  public static void main(String[] args){
      DatabaseChannel c=new DatabaseChannel();
      c.connect();//Database Channel connecting...
  }
}