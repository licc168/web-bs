package com.licc.dao.persist;

import com.licc.common.util.QueryParameters;
import com.licc.dao.base.IEntityMapper;
import com.licc.dao.po.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends IEntityMapper<User,Integer> {

}