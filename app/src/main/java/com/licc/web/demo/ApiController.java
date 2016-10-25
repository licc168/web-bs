package com.licc.web.demo;

import com.licc.common.exception.BusinessException;
import com.licc.common.util.ResultJson;
import com.licc.common.util.ResultJsonUtil;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016/10/9.
 */
@Controller
@RequestMapping("swagger")
public class ApiController {

    /**
     * 根据用户名获取用户对象
     * @param name
     * @return
     */
    @RequestMapping(value="/name/{name}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据用户名获取用户对象", httpMethod = "GET", response = ResultJson.class, notes = "根据用户名获取用户对象")
    public ResultJson getUserByName(@ApiParam(required = true, name = "name", value = "用户名") @PathVariable String name) throws Exception{
        Mobile mobile = new Mobile();
        mobile.setId(1);
        mobile.setName("1111");
        return ResultJsonUtil.successResult(name,mobile);

    }

}
