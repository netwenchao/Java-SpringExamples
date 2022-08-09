import com.dragon2.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yanchongsheng
 * @since 2022-07-26
 */
public class MyTestSpring {
    public static void main(String[] args)
    {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");

        UserService servcie = (UserService)ctx.getBean("userService");
        servcie.getUser();
    }
}
