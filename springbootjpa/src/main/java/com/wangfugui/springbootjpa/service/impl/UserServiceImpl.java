package com.wangfugui.springbootjpa.service.impl;

import com.wangfugui.springbootjpa.dao.UserDao;
import com.wangfugui.springbootjpa.dao.domain.User;
import com.wangfugui.springbootjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MaSiyi
 * @version 1.0.0 2021/12/11
 * @since JDK 1.8.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 增
     *
     * @param user
     * @Param: [user]
     * @return: java.lang.String
     * @Author: MaSiyi
     * @Date: 2021/12/11
     */
    @Override
    public String insert(User user) {
        userDao.save(user);
        return "ok";
    }

    /**
     * 改
     *
     * @param user
     * @Param: [user]
     * @return: java.lang.String
     * @Author: MaSiyi
     * @Date: 2021/12/11
     */
    @Override
    public String update(User user) {
        userDao.save(user);
        return "ok";
    }

    /**
     * 查
     *
     * @param id
     * @Param: [id]
     * @return: java.lang.String
     * @Author: MaSiyi
     * @Date: 2021/12/11
     */
    @Override
    public User getOne(Integer id) {
        return userDao.getOne(id);
    }

    /**
     * 删
     *
     * @param id
     * @Param: [id]
     * @return: java.lang.String
     * @Author: MaSiyi
     * @Date: 2021/12/11
     */
    @Override
    public String delete(Integer id) {
        userDao.deleteById(id);
        return "ok";
    }
}
