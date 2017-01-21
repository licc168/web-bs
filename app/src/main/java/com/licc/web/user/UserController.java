package com.licc.web.user;

import com.licc.common.util.*;
import com.licc.dao.po.User;
import com.licc.service.user.IUserService;
import com.licc.vo.UserVO;
import com.licc.web.demo.Mobile;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * <strong>用户信息操作类</strong>
 *
 * @author lichangchao
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Resource
    IUserService userService;
    /**
     * 获取用户信息
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取用户信息", httpMethod = "GET", response = ResultJson.class, notes = "用户信息")
    public List<UserVO> list() throws Exception {
        return userService.list(null);
    }

    

}
