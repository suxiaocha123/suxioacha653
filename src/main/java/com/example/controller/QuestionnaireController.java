package com.example.controller;

import com.example.beans.HttpResponseEntity;
import com.example.dao.entity.QuestionnaireEntity;
import com.example.dao.entity.UserEntity;
import com.example.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class QuestionnaireController {
    @Autowired
    private QuestionnaireService questionnaireService;
    /*
    问卷新建
     */
    @RequestMapping(value = "/addSurvey",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity addSurvey(@RequestBody QuestionnaireEntity questionnaireEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            int result = questionnaireService.addSurvey(questionnaireEntity);
            if (result != 0){
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("创建成功");
                System.out.println(questionnaireEntity);
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
    问卷修改
     */
    @RequestMapping(value = "/modifySurveyInfo",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity  modifySurvey(@RequestBody QuestionnaireEntity questionnaireEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        System.out.println(questionnaireEntity);
        try {
            int result = questionnaireService.modifySurveyInfo(questionnaireEntity);
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
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return httpResponseEntity;

    }
    /*
    问卷删除
     */
    @RequestMapping(value = "/deleteSurveyInfo",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity  deleteSurvey(@RequestBody QuestionnaireEntity questionnaireEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        System.out.println(questionnaireEntity);
        System.out.println("111");
        try {
            int result = questionnaireService.deleteSurveyByName(questionnaireEntity);
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
