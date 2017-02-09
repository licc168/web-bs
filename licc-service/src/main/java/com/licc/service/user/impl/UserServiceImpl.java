package com.licc.service.user.impl;

import com.licc.common.util.QueryParametersUtil;
import com.licc.dao.base.IEntityMapper;
import com.licc.dao.persist.UserMapper;
import com.licc.dao.po.User;
import com.licc.param.UserParam;
import com.licc.service.base.AbstractEntityService;
import com.licc.service.user.IUserService;
import com.licc.vo.UserVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractEntityService<UserVO, User, Integer> implements IUserService {
    @Resource
    UserMapper userMapper;

    @Override
    protected IEntityMapper<User, Integer> getEntityMapper() {
        return userMapper;
    }

    @Override
    public UserVO getByNameAndPassword(String email, String password) {
        UserParam param = new UserParam();
        param.setEmail(email);
        param.setPswd(password);
        return this.getByParam(param);
    }

    @Override
    public boolean isExistsEmail(String email) {
        UserParam param = new UserParam();
        param.setEmail(email);
        UserVO vo = getByParam(param);
        if (vo == null) return false;
        return true;
    }

}
