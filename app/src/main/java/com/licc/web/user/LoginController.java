package com.licc.web.user;

import com.licc.common.constant.Const;
import com.licc.common.constant.EResultCode;
import com.licc.common.util.ResultJson;
import com.licc.common.util.ResultJsonUtil;
import com.licc.common.util.TranslatorHelper;
import com.licc.service.user.IUserService;
import com.licc.vo.UserVO;
import com.wordnik.swagger.annotations.ApiOperation;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <strong>登陆</strong>
 * @author lichangchao
 */
@Controller
@ResponseBody
@RequestMapping("api")
public class LoginController {
    @Resource
    IUserService userService;
    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ApiOperation(value = "根据用户名密码登陆接口", httpMethod = "POST", response = ResultJson.class, notes = "根据用户名密码登陆接口")
    public ResultJson  login(@RequestParam(value = "username",required = true) String username ,
                              @RequestParam(value = "password",required = true) String password){
        UserVO user = userService.getByNameAndPassword(username,password);
        if(user==null){
            return ResultJsonUtil.failResult(TranslatorHelper.get("user.password.error"));
        }
        String jwtToken = Jwts.builder().setSubject(username).claim("roles", "user").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, Const.SECRETKEY).compact();
        return ResultJsonUtil.successResult(EResultCode.SUCCESS.getValue(),jwtToken);
    }

}
