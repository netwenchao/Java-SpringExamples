package cn.dragon2.IOInDeep;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class EncodingDemo {
  public static void main(String[] args) throws UnsupportedEncodingException, IOException {
    // System.getProperties().list(System.out);
    OutputStream os = new FileOutputStream("E:\\WorkSpace\\Java\\Java-SpringExamples\\JavaAdv\\res\\Sample.txt", true);
    os.write("测试".getBytes("UTF-8"));
    os.close();
  }
}
