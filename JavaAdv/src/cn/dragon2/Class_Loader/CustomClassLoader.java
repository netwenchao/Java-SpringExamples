package cn.dragon2.Class_Loader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

class CustomeClassLoader extends ClassLoader {
  private static final String NETMSG_CLASS_PATH = "D:\\WorkSpace\\java\\Java-SpringExamples\\JavaAdv\\bin\\cn\\dragon2\\BasicLib\\NetMessage";

  /**
   * 
   * @param className
   * @return
   * @throws Exception
   */
  public Class<?> loadData(String className) throws Exception {
    byte[] classFileData = loadClassData();
    if (classFileData != null) {
      return super.defineClass(className, classFileData, 0, classFileData.length);
    }
    return null;
  }

  private byte[] loadClassData() throws Exception {
    InputStream input = null;
    ByteArrayOutputStream out = null;
    byte data[] = null;
    try {
      input = new FileInputStream(new File(NETMSG_CLASS_PATH));
      out=new ByteArrayOutputStream();
      input.transferTo(out);
      data = out.toByteArray();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (input != null)
        input.close();
      if (out != null)
        out.close();
    }

    return data;
  }
}

public class CustomClassLoader {
  public static void main(String[] args) throws ClassNotFoundException {
    CustomeClassLoader ld = new CustomeClassLoader();
    Class<?> cls = ld.loadClass("cn.dragon2.BasicLib.NetMessage");
    System.out.println(cls);
  }
}