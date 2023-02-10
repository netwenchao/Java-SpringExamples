package cn.dragon2.Stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

public class TransferDemo {
  public static void main(String[] args) throws IOException {
    String filePath = "E:\\WorkSpace\\Java\\Java-SpringExamples\\JavaAdv\\res\\Sample.txt";
    File file = new File(filePath);

    if (!file.getParentFile().exists()) {
      file.getParentFile().mkdirs();
    }

    OutputStream os = new FileOutputStream(file);
    Writer w = new OutputStreamWriter(os);// 字节流变字符流
    w.write("This is test string using'OutputStreamWriter'");
    w.flush();
    w.close();

    FileWriter fw = new FileWriter(file, Charset.forName("UTF-8"), true);
    fw.write("\r\nThis is string using FileWriter.");
    fw.append("结束");
    fw.close();
  }
}
