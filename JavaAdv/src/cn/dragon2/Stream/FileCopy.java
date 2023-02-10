package cn.dragon2.Stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {
  public static void main(String[] args) throws IOException {
    String dir = "E:\\WorkSpace\\Java\\Java-SpringExamples\\JavaAdv\\res\\";
    FileUtil.Copy(dir + "Sample.txt", dir + "SampleBak.txt");
    System.out.println("Copy Finish.");
  }
}

class FileUtil {
  static void Copy(String src, String des) throws IOException {
    File sFile = new File(src);
    File tFile = new File(des);
    if (!sFile.exists()) {
      throw new FileNotFoundException("Source file is not exists.");
    }

    byte[] buffer = new byte[1024];
    int len = -1;
    InputStream fin = null;
    OutputStream fout = null;

    try {
      fin = new FileInputStream(sFile);
      fout = new FileOutputStream(tFile);
      while ((len = fin.read(buffer)) != -1) {
        fout.write(buffer, 0, len);
      }
      fout.close();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (fin != null)
        fin.close();
      if (fout != null)
        fout.close();
    }

  }

  static void CopyWithTransferTo(String src, String des) throws IOException {
    File sFile = new File(src);
    File tFile = new File(des);
    if (!sFile.exists()) {
      throw new FileNotFoundException("Source file is not exists.");
    }

    InputStream fin = null;
    OutputStream fout = null;

    try {
      fin = new FileInputStream(sFile);
      fout = new FileOutputStream(tFile);
      // using transfer to 1.9+
      fin.transferTo(fout);
      fout.close();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (fin != null)
        fin.close();
      if (fout != null)
        fout.close();
    }
  }
}
