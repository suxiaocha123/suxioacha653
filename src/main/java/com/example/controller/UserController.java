package com.example.controller;

import com.example.beans.HttpResponseEntity;
import com.example.dao.entity.UserEntity;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class UserController {
    @Autowired
    private UserService userService;
    /*
    用户登录
     */
    @RequestMapping(value = "/userLogin",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity  userLogin(@RequestBody UserEntity userEntity){
   HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
  try {
      List<UserEntity> hasUser = userService.selectUserInfo(userEntity);
       if (CollectionUtils.isEmpty(hasUser)){
           httpResponseEntity.setCode("10");
           httpResponseEntity.setData(hasUser.get(0));
           httpResponseEntity.setMessage("用户名或者密码错");
       }else {
           httpResponseEntity.setCode("666");
           httpResponseEntity.setData(hasUser);
           httpResponseEntity.setMessage("成功");
       }

  }catch (Exception e){
      System.out.println(e.getMessage());
      e.printStackTrace();
  }

   return httpResponseEntity;

    }
    /*
    用户列表查询
     */
    @RequestMapping(value = "/queryUserList",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity  queryUserList(@RequestBody UserEntity userEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            List<UserEntity> hasUser = userService. queryUserList(userEntity);
            if (CollectionUtils.isEmpty(hasUser)){
                httpResponseEntity.setCode("10");
                httpResponseEntity.setData(hasUser.get(0));
                httpResponseEntity.setMessage("无用户信息");
            }else {
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(hasUser);
                httpResponseEntity.setMessage("查询成功");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return httpResponseEntity;

    }
    /*
        用户添加
         */
    @RequestMapping(value = "/addUserInfo",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity  addUser(@RequestBody UserEntity userEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
           int result = userService.addUserInfo(userEntity);
            if (result != 0){
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("创建成功");
            }else {
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("创建失败");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return httpResponseEntity;

    }
    /*
           用户修改
            */
    @RequestMapping(value = "/modifyUserInfo",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity  modifyUser(@RequestBody UserEntity userEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            int result = userService.modifyUserInfo(userEntity);
            if (result != 0){
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("修改成功");
            }else {
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("修改失败");
            }

        }catch (Exception e){

        }

        return httpResponseEntity;

    }
    /*
               用户删除
                */
    @RequestMapping(value = "/deleteUserInfo",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity  deleteUser(@RequestBody UserEntity userEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        System.out.println(userEntity);
        System.out.println("111");
        try {
            int result = userService.deleteUserByName(userEntity);
            if (result != 0){
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("删除成功");
            }else {
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("删除失败");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return httpResponseEntity;

    }
}
