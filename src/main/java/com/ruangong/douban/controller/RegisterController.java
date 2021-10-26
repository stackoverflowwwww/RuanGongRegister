package com.ruangong.douban.controller;

import com.ruangong.douban.bean.User;
import com.ruangong.douban.dao.UserDao;
import com.ruangong.douban.result.ResultCodeEnum;
import com.ruangong.douban.result.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version v1.0
 * @ClassName RegisterController
 * @Description TODO
 * @Author bong
 * @Date 2021/10/26 0:14
 **/
@RestController
public class RegisterController {
    @Autowired
    UserDao userDao;
    @PostMapping("/register")
    public ReturnResult register(@RequestBody User user){
        ReturnResult r=ReturnResult.getState(ResultCodeEnum.REGISTER_SUCCESS);
        if(userDao.checkRegisterUsername(user.getUsername())>0){
            r=ReturnResult.getState(ResultCodeEnum.REGISTER_USERNAME_ERROR);
        }
        if(userDao.checkRegisterEmail(user.getEmail())>0){
            r=ReturnResult.getState(ResultCodeEnum.REGISTER_EMAIL_ERROR);
        }
        if(r.getSuccess()){
            userDao.addUser(user);
        }
        return r;

    }
}
