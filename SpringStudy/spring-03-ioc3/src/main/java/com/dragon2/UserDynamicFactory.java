package com.dragon2;

/**
 * @author yanchongsheng
 * @since 2022-08-03
 */
public class UserDynamicFactory {
    public User newInstance(String name) {
        return new User(name);
    }
}
