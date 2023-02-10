package cn.dragon2.Stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamDemo {
  public static void main(String[] args) throws IOException {
    String filePath = "E:\\WorkSpace\\Java\\Java-SpringExamples\\JavaAdv\\res\\Sample.txt";
    File file = new File(filePath);

    if (!file.getParentFile().exists()) {
      file.getParentFile().mkdirs();
    }

    // AutoCloseable接口，简化Close
    // 创建模式
    try (FileOutputStream fs = new FileOutputStream(file)) {
      fs.write("123456".getBytes());
    } catch (Exception e) {
      e.printStackTrace();
    }

    // AutoCloseable接口，简化Close
    // 追加模式
    try (FileOutputStream fsa = new FileOutputStream(file, true)) {
      fsa.write("abced".getBytes());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
