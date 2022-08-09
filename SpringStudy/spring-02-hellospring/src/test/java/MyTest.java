import com.dragon2.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yanchongsheng
 * @since 2022-07-26
 */
public class MyTest {
    public static void main(String[] args) {

        //获取Spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //对象在Spring
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello.toString());
    }
}
