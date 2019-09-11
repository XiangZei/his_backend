package com.neu.t1.controller;

import com.neu.t1.Service.LoginService;
import com.neu.t1.component.CommonResult;
import com.neu.t1.po.User;
import com.neu.t1.vo.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 *用户登录的api的实现
 */
@Controller
@Api(tags = "login",description = "用户登陆")
@RequestMapping("/admin")
public class Login {

    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    LoginService loginService;

    @ApiOperation(value="登录以后返回token")
    @RequestMapping(value = "/login",method= RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody UserInfo userInfo){
        String token = loginService.login(userInfo.getUsername(),userInfo.getPassword(),userInfo.getType());
        if(token==null){
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation(value="刷新token")
    @RequestMapping(value = "/token/refresh",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult refreshToken(HttpServletRequest request){
        String token = request.getHeader(tokenHead);
        String refreshToken = loginService.refreshToken(token);
        if(refreshToken==null){
            return CommonResult.failed();
        }
        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("token",refreshToken);
        tokenMap.put("tokenHead",tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation(value="获取用户信息")
    @RequestMapping(value = "/getInfo",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getInfo(@RequestParam(value = "username",required = true) String username){
        User u = loginService.getUserInfo(username);
        Map<String,Object> m = new HashMap<>();
        m.put("msg",new String[]{"1","2"});
        m.put("avatar","未设置头像");
        return  CommonResult.success(m);
    }

    @ApiOperation(value = "用户退出")
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult logOut(HttpServletResponse response){
        /*
        Token 的弊端在这里，由于token真正的废除是在超时之后，只要不超时，一旦别人获取了token就可以进行与后台操作，这也是token实现单点登录不足之处。

        但是可以通过修改密钥进行实现，由于本次工程重点不在这里，所以仅仅模拟退出。
        所以要实现真正的单点登陆，必须将token的密钥随着用户名和用户登录
         */
        response.setHeader("Access-Control-Allow-Origin", "*");//* or origin as u prefer
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "PUT, POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "content-type, authorization");

        System.out.println("跨域");
        return CommonResult.success(null);
    }

}
