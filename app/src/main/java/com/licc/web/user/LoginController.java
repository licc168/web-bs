package com.licc.web.user;

import com.licc.common.util.ResultJson;
import com.licc.common.util.ResultJsonUtil;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <strong>登陆</strong>
 * @author lichangchao
 */
@Controller
@ResponseBody
public class LoginController {
    @RequestMapping("login")
    @ApiOperation(value = "根据用户名密码登陆接口", httpMethod = "GET", response = ResultJson.class, notes = "根据用户名密码登陆接口")

    public ResultJson  login(@RequestParam("name") String name,@RequestParam("password") String password){
        return ResultJsonUtil.failResult("哈哈哈哈");
    }

}
