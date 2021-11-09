package com.ruangong.douban.controller;
import com.ruangong.douban.bean.User;
import com.ruangong.douban.dao.UserDao;
import com.ruangong.douban.result.ResultCodeEnum;
import com.ruangong.douban.result.ReturnResult;
import com.ruangong.douban.utils.UserUtils;
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

        //检测邮箱，用户名，密码完整性
        if(UserUtils.isPasswordValid(user.getPassword())==0){
            r=ReturnResult.getState(ResultCodeEnum.PASSWORD_INVALID_ERROR);
        }
        if(UserUtils.isUsernameValid(user.getUsername())==0){
            r=ReturnResult.getState(ResultCodeEnum.USERNAME_INVALID_ERROR);
        }
        if(UserUtils.isEmailValid(user.getEmail())==0){
            r=ReturnResult.getState(ResultCodeEnum.EMAIL_INVALID_ERROR);
        }
        if(!r.getSuccess()){
            return r;
        }

        boolean emailExit=false,usernameExit=false;
        if(userDao.checkRegisterUsername(user.getUsername())>0){
            r=ReturnResult.getState(ResultCodeEnum.REGISTER_USERNAME_ERROR);
            usernameExit=true;
        }
        if(userDao.checkRegisterEmail(user.getEmail())>0){
            r=ReturnResult.getState(ResultCodeEnum.REGISTER_EMAIL_ERROR);
            emailExit=true;
        }
        if(emailExit&&usernameExit){ //用户名和邮箱同时存在在数据库中
            r=ReturnResult.getState(ResultCodeEnum.REGISTER_EMAIL_USERNAME_ERROR);
        }
        if(r.getSuccess()){
            userDao.addUser(user);
        }
        return r;

    }

}
