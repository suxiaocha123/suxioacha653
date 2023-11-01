package com.example.dao;

import com.example.dao.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface UserEntityMapper {
    /*
    查询用户列表
     */

    List<UserEntity> queryUserList(UserEntity userEntity);
    /*
    创建用户基本信息
 */
    int insert(UserEntity userEntity);
    /*
    根据id删除用户信息
    */
    int deleteUserByName(UserEntity userEntity);
    /*
    编辑用户信息
     */
    int updateByPrimaryKeySelective(UserEntity userEntity);

    List<UserEntity> selectUserInfo(UserEntity userEntity);


}
