package cn.dragon2.ReflactorAndClass;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class RACEmplee {
  private String name;
  private String job;
  private Date hireDate;
  private Integer age;
  private Float salary;

  public String getName() {
    return name;
  }

  public String getJob() {
    return job;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public void setHireDate(Date hireDate) {
    this.hireDate = hireDate;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public void setSalary(Float salary) {
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "name:" + name + " job:" + job+" hiredate:"+hireDate +" salary:"+salary;
  }
}

class StringUtil {
  public static String initCap(String str) {
    if (str == null || "".equals(str))
      return str;
    if (str.length() == 1)
      return str.toUpperCase();
    return str.substring(0, 1).toUpperCase() + str.substring(1, str.length());
  }

  public static Boolean isNullOrEmpty(String str) {
    return str == null || "".equals(str);
  }
}

class BeanUtil {
  /**
   * 实现Object的属性设置
   * 
   * @param o 待赋值对象
   * @param value
   */
  public static void setValue(Object o, String value) {
    String[] parts = value.split("\\|");
    for (String part : parts) {
      String[] sub = part.split(":");
      if (sub.length > 1 && !StringUtil.isNullOrEmpty(sub[0])) {
        try {
          Field field = o.getClass().getDeclaredField(sub[0]);
          Method setM = o.getClass().getDeclaredMethod("set" + StringUtil.initCap(field.getName()), field.getType());
          setM.invoke(o, getAttrValue(field.getType().getName(),sub[1]));
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }

  /**
   * 属性类型转换
   * @param type
   * @param value
   * @return
   */
  static Object getAttrValue(String type,String value)
  {
    if("long".equals(type) || "java.lang.Long".equals(type)) return Long.parseLong(value);
    if("float".equals(type) || "java.lang.Float".equals(type)) return Float.parseFloat(value);
    if("int".equals(type) || "java.lang.int".equals(type)) return Integer.parseInt(value);
    if("double".equals(type) || "java.lang.Double".equals(type)) return Double.parseDouble(value);
    if("java.util.Date".equals(type)){
      SimpleDateFormat smf=null;
      if(type.matches("\\d{4}-\\d{2}-\\d{2}")){
        smf = new SimpleDateFormat("yyyy-MM-dd");
      }else if(type.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")){
        smf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      }
      else{
        return new Date();
      }
      try {
        return smf.parse(value);
      } catch (ParseException e) {
        return new Date();
      }
    }
    return value;
  }
}

class RACClassInstanceFactory {
  private RACClassInstanceFactory() {
  }

  /**
   * 实例化对象的创建方法，该对象根据传入的字符串结构“属性:内容|属性内容”
   * 
   * @param clazz 要进行反射实例化
   * @param value
   * @return
   * @throws ClassNotFoundException
   * @throws SecurityException
   * @throws NoSuchMethodException
   * @throws InvocationTargetException
   * @throws IllegalArgumentException
   * @throws IllegalAccessException
   * @throws InstantiationException
   */
  public static <T> T create(Class<?> clazz, String value)
      throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
      InvocationTargetException, NoSuchMethodException, SecurityException {
    Class<?> type = Class.forName(value);
    Object obj = type.getDeclaredConstructor().newInstance();
    Field[] fields = type.getDeclaredFields();

    for (Field f : fields) {
      System.out.println(f.getName());
    }

    return (T) obj;
  }
}

public class RACDemo {
  public static void main(String[] args) {
    System.out.println(StringUtil.initCap("A"));
    System.out.println(StringUtil.initCap("ab"));

    try {
      RACEmplee o = RACClassInstanceFactory.create(RACEmplee.class, "cn.dragon2.ReflactorAndClass.RACEmplee");
      BeanUtil.setValue(o, "name:ZS|job:CEO|salary:33.01|hireDate:2009-01-01");
      System.out.println(o);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
