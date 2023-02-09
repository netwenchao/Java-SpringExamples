package cn.dragon2.ReflactorAndClass;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
  public String title();

  public String url() default "xxx.xxx";
}

@MyAnnotation(title = "Title", url = "Url")
public class CustomAnnotationDemo {
  public static void main(String[] args) {
    Annotation[] annos= CustomAnnotationDemo.class.getAnnotations();
    for (Annotation annotation : annos) {
      System.out.println(annotation);
    }

    System.out.println("-----------------");
    Annotation [] ano=CustomAnnotationDemo.class.getAnnotationsByType(MyAnnotation.class);
    for (Annotation annotation : ano) {
      System.out.println(annotation);
    }
  }
}
