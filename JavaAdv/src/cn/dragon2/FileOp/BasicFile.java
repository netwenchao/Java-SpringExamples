package cn.dragon2.FileOp;

import java.io.File;
import java.io.IOException;

public class BasicFile {
  static String filePath = "E:" + File.separator + "WorkSpace" + File.separator + "Java" + File.separator
      + "Java-SpringExamples" + File.separator + "JavaAdv" + File.separator + "res";

  public static void main(String[] args) {
    String fileName = filePath + File.separator + "Sample.txt";
    File f = new File(fileName);

    System.out.println(f.getParent());

    if (f.exists()) {
      System.out.println("File (" + filePath + ") is exists.");
    } else {
      try {
        System.out.println("File (" + filePath + ") is not exists. Creating...");
        boolean r = f.createNewFile();
        System.out.println("File (" + filePath + ") is " + (r ? "created" : " exists.") + ".");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    f.renameTo(new File(filePath + File.separator + "Sample1.txt"));

    showFileInfo(f);
    ShowFiles(f.getParentFile(), "");
    System.out.println(f.delete());
  }

  static void ShowFiles(File f, String t) {
    if (f.isFile()) {
      System.out.println(t + "-f " + f.getName());
      return;
    }
    System.out.println(t + "-d " + f.getName());

    File[] files = f.listFiles();
    if (files.length > 0) {
      for (File file : files) {
        ShowFiles(file, t + "\t");
      }
    }
  }

  static void showFileInfo(File f) {
    System.out.println(f.getAbsolutePath());
    System.out.println(f.canWrite() ? "w" : "" + (f.canRead() ? "r" : "") + (f.canExecute() ? "x" : ""));
    System.out.println("FreeSpace:" + f.getFreeSpace() + "/" + f.getTotalSpace());
    System.out.println("Last Modify:" + f.lastModified());
    System.out.println("Length:" + f.length());
  }
}
