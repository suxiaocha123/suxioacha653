package com.example.dao;

import com.example.dao.entity.ProjectEntity;
import com.example.dao.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProjectEntityMapper {
    /*
    查询项目列表
     */
     List<ProjectEntity> queryProjectList(ProjectEntity projectEntity);

     int insert(ProjectEntity projectEntity);
     int updateByPrimaryKeySelective(ProjectEntity projectEntity);
     int deleteProjectById(ProjectEntity projectEntity);
}
