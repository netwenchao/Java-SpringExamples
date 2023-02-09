package cn.dragon2.ReflactorAndClass;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@FunctionalInterface
@Deprecated(since = "1.0")
interface IMessage{
  public void send(String msg);
}

@SuppressWarnings("serial")//无法在程序执行时获取
class AnnoMessage implements IMessage,Serializable
{
  @Override
  public void send(String msg) {
  }
}

public class AnnotationDemo {
  public static void main(String[] args) throws NoSuchMethodException, SecurityException {
    Annotation[] annos = IMessage.class.getAnnotations();
    for (Annotation annotation : annos) {
      System.out.println(annotation);
    }

    System.out.println("------------------");
    Annotation[] clsAnnos = AnnoMessage.class.getAnnotations();
    for (Annotation annotation : clsAnnos) {
      System.out.println(annotation);
    }

    System.out.println("------------------");
    Method sendMethod = AnnoMessage.class.getDeclaredMethod("send",String.class);
    Annotation[] mAnnos= sendMethod.getAnnotations();
    for (Annotation annotation : mAnnos) {
      System.out.println(annotation);
    }
  }
}
