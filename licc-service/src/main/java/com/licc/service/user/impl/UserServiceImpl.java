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
 * Created by lichangchao on 2016/11/5.
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
    public UserVO getByNameAndPassword(String name, String password) {
        UserParam param = new UserParam();
        param.setNickname(name);
        param.setPswd(password);
        List<UserVO> list = this.list(QueryParametersUtil.addParam(param));
        if (CollectionUtils.isEmpty(list)) return null;
        return list.get(0);

    }
}
