package cn.dragon2.IOInDeep;

import java.io.IOException;
import java.io.InputStream;

public class SystemDemo {
  public static void main(String[] args) throws IOException {
    InputStream in = System.in;

    byte[] buffer = new byte[1024];
    int len = in.read(buffer);
    System.out.println(new String(buffer));

  }
}
