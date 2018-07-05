package com.training.service;

import com.training.dao.UserDao;
import com.training.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;

/**
 * Created by admin on 2018/7/1.
 */
public class DefaultUserService implements UserDetailsService {

    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User u = userDao.getUserByName(name);
        HashSet dbAuthsSet = new HashSet();
        dbAuthsSet.addAll(userDao.getAuthentyByName(name));
        return new org.springframework.security.core.userdetails.User(u.getName(),u.getPassword(),true,true,true,true,dbAuthsSet);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
