package com.example.controller;

import com.example.beans.HttpResponseEntity;
import com.example.dao.entity.ProjectEntity;
import com.example.dao.entity.UserEntity;
import com.example.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController

public class ProjectController {
    @Autowired
     private ProjectService projectService;
    /*
    项目列表（展示）
     */
    @RequestMapping(value = "/queryProjectList",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity queryProjectList(@RequestBody ProjectEntity projectEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            List<ProjectEntity> hasProject = projectService. queryProjectList(projectEntity);
            if (CollectionUtils.isEmpty(hasProject)){
                httpResponseEntity.setCode("10");
                httpResponseEntity.setData(hasProject.get(0));
                httpResponseEntity.setMessage("无项目信息");
            }else {
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(hasProject);
                httpResponseEntity.setMessage("查询成功");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return httpResponseEntity;
    }

    /*
    新增项目
     */
    @RequestMapping(value = "/addProjectInfo",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity addProjectInfo(@RequestBody ProjectEntity projectEntity){
            HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
            try {
                int result = projectService.addProjectInfo(projectEntity);
                if (result != 0){
                    httpResponseEntity.setCode("666");
                    httpResponseEntity.setData(result);
                    httpResponseEntity.setMessage("创建成功");
                    System.out.println(projectEntity);
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
      项目修改
       */
    @RequestMapping(value = "/modifyProjectInfo",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity  modifyProject(@RequestBody ProjectEntity projectEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        System.out.println(projectEntity);
        try {
            int result = projectService.modifyProjectInfo(projectEntity);
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
       项目删除
     */
    @RequestMapping(value = "/deleteProjectById" ,method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity  deleteProject(@RequestBody ProjectEntity projectEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        System.out.println(projectEntity);
        System.out.println("111");
        try {
            if (projectEntity == null) {
                httpResponseEntity.setCode("000");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("删除失败，未传递有效数据");
                return httpResponseEntity;
            }
            String  id = projectEntity.getId();
            if (id == null) {
                httpResponseEntity.setCode("00");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("删除失败，未传递有效的项目 ID");
                return httpResponseEntity;
            }
            // 执行删除操作
            int result = projectService.deleteProjectById(projectEntity);
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
            httpResponseEntity.setCode("0");
            httpResponseEntity.setData(0);
            httpResponseEntity.setMessage("删除失败，产生异常：" + e.getMessage());
        }

        return httpResponseEntity;

    }
}
