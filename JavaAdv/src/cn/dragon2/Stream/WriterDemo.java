package cn.dragon2.Stream;

import java.io.File;
import java.io.FileWriter;

public class WriterDemo {
  public static void main(String[] args) {
    String filePath = "E:\\WorkSpace\\Java\\Java-SpringExamples\\JavaAdv\\res\\Sample.txt";
    File file = new File(filePath);

    if (!file.getParentFile().exists()) {
      file.getParentFile().mkdirs();
    }

    // 覆盖模式
    // try (FileWriter fw = new FileWriter(file,true)) {//追加模式
    try (FileWriter fw = new FileWriter(file)) {
      fw.write("FirstLine" + File.separator);
      fw.append("\r\nTest");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
