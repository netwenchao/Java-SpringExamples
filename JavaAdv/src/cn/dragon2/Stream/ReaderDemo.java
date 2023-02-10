package cn.dragon2.Stream;

import java.io.File;
import java.io.FileReader;

public class ReaderDemo {
  public static void main(String[] args) {
    String filePath = "E:\\WorkSpace\\Java\\Java-SpringExamples\\JavaAdv\\res\\Sample.txt";
    File file = new File(filePath);

    if (!file.getParentFile().exists()) {
      file.getParentFile().mkdirs();
    }

    try (FileReader fr = new FileReader(file)) {
      char[] buffer = new char[1024];
      int len = fr.read(buffer);
      System.out.println("Len:" + len);
      System.out.println(new String(buffer, 0, len));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
