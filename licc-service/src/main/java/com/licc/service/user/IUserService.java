package com.licc.service.user;

import com.licc.common.util.QueryParameters;
import com.licc.vo.UserVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;

import java.util.List;

/**
 * @author  lichangchao
 * @Time 2017/01/02
 * 用户信息处理类
 */
public interface IUserService {
    /**
     * 查询用户列表信息
     */
    public List<UserVO>  list(QueryParameters queryParameters);
    /**
     * 根據用戶名和密碼查詢用戶信息
     */
    public UserVO getByNameAndPassword(String name, String password);
    /**
     * 判断邮箱是否存在
     */
    public boolean isExistsEmail(String email);
    /**
     * 注册接口
     */


}
