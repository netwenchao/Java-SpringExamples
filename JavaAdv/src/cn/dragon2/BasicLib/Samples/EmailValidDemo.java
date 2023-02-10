package cn.dragon2.BasicLib.Samples;

import java.util.ArrayList;
import java.util.List;

public class EmailValidDemo {
  public static void main(String[] args) {
    String email = "test@aa.com";
    String email1 = "testaa.com";

    System.out.println(email + " is email." + Validator.IsEmail(email));
    System.out.println(email1 + " is email." + Validator.IsEmail(email1));

    List<String> ipAddr = new ArrayList<String>();
    ipAddr.add("192.168.2");
    ipAddr.add("192.168.2.");
    ipAddr.add("192.168.2.122");
    ipAddr.add("192.168.2.1222");
    ipAddr.add("256.168.2.1");

    for (String ip : ipAddr) {
      System.out.println(ip + " is valid." + Validator.IsIp(ip));
    }
  }
}

class Validator {

  public static boolean IsEmpty(String str) {
    return (null == str || "".equals(str));
  }

  public static boolean IsEmail(String str) {
    if (IsEmpty(str))
      return false;
    return str.matches("^[a-z0-9_.]+@[a-z0-9_.]+\\.[a-z0-9_.]+$");
  }

  public static boolean IsIp(String str) {
    if (IsEmpty(str))
      return false;
    return str.matches("((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)");
  }
}
