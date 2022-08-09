package com.dragon2;

/**
 * @author yanchongsheng
 * @since 2022-08-03
 */
public class UserStaticFactory {
    public static User newInstance(String name)
    {
        return new User(name);
    }
}
