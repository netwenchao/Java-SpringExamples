package com.dragon2.service;

import com.dragon2.dao.UserDao;
import com.dragon2.dao.UserDaoMySqlImpl;

/**
 * @author yanchongsheng
 * @since 2022-07-26
 */
public class UserServiceImpl implements UserService {
    private UserDao dao = null;

    public void setUserDao(UserDao dao){
        this.dao=dao;
    }
    public void getUser() {
        dao.getUser();
    }
}
