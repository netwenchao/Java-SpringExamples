package com.dragon2.test;

import com.dragon2.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yanchongsheng
 * @since 2022-08-03
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user = (User) context.getBean("user");
        user.show();

        User user2 = (User) context.getBean("userCon");
        user2.show();

        User userFac = (User) context.getBean("userFac");
        userFac.show();

        User userDynamicFac = (User) context.getBean("userDynamicFac");
        userDynamicFac.show();
    }
}
