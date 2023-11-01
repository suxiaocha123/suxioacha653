package com.example.service;

import com.example.common.utils.UUIDUtils;
import com.example.dao.entity.UserEntity;
import com.example.dao.UserEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

@Autowired
    private UserEntityMapper userEntityMapper;
   /*
   登录
    */
   public  List<UserEntity> selectUserInfo(UserEntity userEntity){
       List<UserEntity> result = userEntityMapper.selectUserInfo(userEntity);
       return  result;
   }
   /*
    查询用户列表
     */
    public List<UserEntity> queryUserList(UserEntity userEntity){
       List<UserEntity> result = userEntityMapper.queryUserList(userEntity);
       return  result;
   }
/*
创建用户
 */
    public  int addUserInfo(UserEntity userEntity){
        userEntity.setId(UUIDUtils.getOneUUID());
        userEntity.setStatus("1");
        int userResult = userEntityMapper.insert(userEntity);
        if (userResult != 0){
            return 3;//代表用户存在
        }else {
            return  userResult;
        }
    }
/*
修改
 */
    public int modifyUserInfo(UserEntity userEntity){
    int userResult = userEntityMapper.updateByPrimaryKeySelective(userEntity);
    return  userResult;
    }
    /*
    删除用户信息
     */
    public int deleteUserByName(UserEntity userEntity){
        int userResult = userEntityMapper.deleteUserByName(userEntity);
        return userResult;
    }
}
