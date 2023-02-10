package cn.dragon2.Stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class InputStreamDemo {
  public static void main(String[] args) {
    String filePath = "E:\\WorkSpace\\Java\\Java-SpringExamples\\JavaAdv\\res\\Sample.txt";
    File file = new File(filePath);

    try (InputStream fin = new FileInputStream(file)) {
      byte[] buffer = new byte[1024];
      // read len
      int len = fin.read(buffer);
      // byte[] buffer = fin.AllBytes(); //JDK 1.9+

      if (len != -1) {
        System.out.println("Read Length:" + len);
        System.out.println(new String(buffer, 0, len));
      } else {
        System.out.println("No data is readed.");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
