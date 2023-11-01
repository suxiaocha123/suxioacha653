package com.example.dao;
import com.example.dao.entity.QuestionnaireEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface QuestionnaireEntityMapper {
    /*
     新建
      */
    int insertSurvey(QuestionnaireEntity questionnaireEntity);
    /*
    更新
     */
    int updateSurvey(QuestionnaireEntity questionnaireEntity);
    /*
    删除
     */
    int deleteSurvey(QuestionnaireEntity questionnaireEntity);

}
