package cn.dragon2.BasicLib.Samples;

/**
 * StringBufferDemo
 */
public class StringBufferDemo {

  public static void main(String[] args) {
    StringBuffer sb = new StringBuffer();
    for (int i = 'a'; i < 'z'; i++) {
      sb.append((char) i);
    }
    System.out.println(sb.toString());
    sb.delete(0, 5);
    System.out.println(sb.toString());
  }
}