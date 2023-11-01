package com.example.service;
import com.example.common.utils.UUIDUtils;
import com.example.dao.QuestionnaireEntityMapper;
import com.example.dao.entity.QuestionnaireEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionnaireService {

@Autowired
private QuestionnaireEntityMapper questionnaireEntityMapper;
    /*
    创建项目
     */
    public int addSurvey(QuestionnaireEntity questionnaireEntity){
       questionnaireEntity.setId(UUIDUtils.getOneUUID());
        int surveyResult = questionnaireEntityMapper.insertSurvey(questionnaireEntity);
        if (surveyResult != 0){
            return 3;//代表用户存在
        }else {
            return surveyResult;
        }
    }

    /*
    修改项目
 */
    public int modifySurveyInfo(QuestionnaireEntity questionnaireEntity){
        int surveyResult = questionnaireEntityMapper.updateSurvey(questionnaireEntity);
        return  surveyResult;
    }
    /*
    删除项目
     */
    public int deleteSurveyByName(QuestionnaireEntity questionnaireEntity){
        int surveyResult = questionnaireEntityMapper.deleteSurvey(questionnaireEntity);
        return surveyResult;
    }

}
