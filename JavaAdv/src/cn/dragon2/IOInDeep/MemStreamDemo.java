package cn.dragon2.IOInDeep;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class MemStreamDemo {
  public static void main(String[] args) {
    String source = "This is test messsage.";
    ByteArrayInputStream in = new ByteArrayInputStream(source.getBytes());
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    int data = 0;
    while ((data = in.read()) != -1) {
      out.write(Character.toUpperCase(data));
    }
    System.out.println(out.toString());
    System.out.println(new String(out.toByteArray()));
  }
}