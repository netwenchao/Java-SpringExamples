package cn.dragon2.ReflactorAndClass;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AnnoAndDynamicProxy {
  public static void main(String[] args) {
    MessageService service=new MessageService();
    service.send("Test Message!!!");
  }
}

@Retention(RetentionPolicy.RUNTIME)
@interface UseMessage{
  public Class<?> clazz();
}

@UseMessage(clazz = MessageImpl.class)
class MessageService
{
  IMessage message;
  public MessageService(){
    this.message = (IMessage) Factory.getInstance(this.getClass().getAnnotation(UseMessage.class).clazz());
  }

  public void send(String msg){
    message.send(msg);
  }
}

class Factory{
  private Factory(){}

  public static <T> T getInstance(Class<T> clazz){
    try {
      return (T) new MessageProxy().bind(clazz.getDeclaredConstructor().newInstance());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}


interface IMessage{
  public void send(String msg);
}

class MessageImpl implements IMessage{
  @Override
  public void send(String msg) {
    System.out.println("[Sending Message]" + msg);
  }
}

class MessageProxy implements InvocationHandler{
  private Object target;

  public Object bind(Object target){
    this.target=target;
    return Proxy.newProxyInstance(
      target.getClass().getClassLoader(), 
      target.getClass().getInterfaces(),
      this
    );
  }

  public boolean connect(){
    System.out.println("[Connection] connected.");
    return true;
  }

  public void close(){
    System.out.println("[Connection] closed.");
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    Object rslt=null;
    if(this.connect()){
      method.invoke(this.target, args);
      this.close();
    }
    return rslt;
  }
  
}