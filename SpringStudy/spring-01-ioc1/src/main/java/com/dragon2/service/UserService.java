package com.dragon2.service;

import com.dragon2.dao.UserDao;

/**
 * @author yanchongsheng
 * @since 2022-07-26
 */
public interface UserService {
    void getUser();
    void setUserDao(UserDao dao);
}
