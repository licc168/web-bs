package com.licc.web.user;

import com.licc.common.constant.Const;
import com.licc.common.constant.EResultCode;
import com.licc.common.util.ResultJson;
import com.licc.common.util.ResultJsonUtil;
import com.licc.common.util.TranslatorHelper;
import com.licc.dao.po.User;
import com.licc.service.user.IUserService;
import com.licc.vo.UserVO;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiOperation;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;

/**
 * <strong>登陆</strong>
 *
 * @author lichangchao
 */
@Controller
@ResponseBody
@RequestMapping("api")
public class LoginController {
    @Resource
    IUserService userService;
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ApiOperation(value = "根据用户名密码登陆接口", httpMethod = "POST", response = ResultJson.class, notes = "根据用户名密码登陆接口")
    public ResultJson login(@RequestParam(value = "username", required = true) String email,
                            @RequestParam(value = "password", required = true) String password) {
        UserVO user = userService.getByNameAndPassword(email, password);
        if (user == null) {
            return ResultJsonUtil.failResult(TranslatorHelper.get("user.password.error"));
        }
        String jwtToken = Jwts.builder().setSubject(email).claim("roles", "user").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, Const.SECRETKEY).compact();
        return ResultJsonUtil.successResult(EResultCode.SUCCESS.getValue(), jwtToken);
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    @ApiOperation(value = "注册用户", httpMethod = "POST", response = ResultJson.class, notes = "注册接口（昵称/邮箱/密码）")

    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    public ResultJson register(@RequestBody @Valid  User user , BindingResult result) {
        boolean isExists = userService.isExistsEmail(user.getEmail());
            if (isExists) {
            return ResultJsonUtil.failResult(TranslatorHelper.get("email.repeat"));
        }

        return ResultJsonUtil.successResult(EResultCode.SUCCESS.getValue(), "");
    }

}
