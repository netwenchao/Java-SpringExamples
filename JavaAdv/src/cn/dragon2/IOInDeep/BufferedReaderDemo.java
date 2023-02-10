package cn.dragon2.IOInDeep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderDemo {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Pls input somethine");
    String data = reader.readLine();
    System.out.println(data);
  }
}
