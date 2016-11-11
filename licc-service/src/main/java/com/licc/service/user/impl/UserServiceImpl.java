package com.licc.service.user.impl;

import com.licc.dao.base.IEntityMapper;
import com.licc.dao.persist.UserMapper;
import com.licc.dao.po.User;
import com.licc.service.base.AbstractEntityService;
import com.licc.vo.UserVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lichangchao on 2016/11/5.
 */
@Service
public class UserServiceImpl  extends AbstractEntityService<UserVO,User,Integer>{
    @Resource
    UserMapper userMapper;
    @Override
    protected IEntityMapper<User, Integer> getEntityMapper() {
        return userMapper;
    }
}
