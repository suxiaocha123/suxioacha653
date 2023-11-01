package com.example.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class QuestionnaireEntity implements Serializable {
    private String id;
    private String userName;
    private String projectName;
    private String surveyName;
    private String surveyContent;
    private String surveyType;
    private Date creationDate;
    private Date endDate;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getSurveyContent() {
        return surveyContent;
    }

    public void setSurveyContent(String surveyContent) {
        this.surveyContent = surveyContent;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getSurveyType() {
        return surveyType;
    }

    public void setSurveyType(String surveyType) {
        this.surveyType = surveyType;
    }

    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    @Override
    public String toString() {
        return "QuestionnaireEntity{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", projectName='" + projectName + '\'' +
                ", surveyName='" + surveyName + '\'' +
                ", surveyContent='" + surveyContent + '\'' +
                ", creationDate=" + creationDate +
                ", endDate=" + endDate +
                ", surveyType='" + surveyType + '\'' +
                '}';
    }
}
