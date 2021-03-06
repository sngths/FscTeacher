package com.tianxing.pojo.transfer.receive;

import com.tianxing.deprecated.entity.http.json.ImageFile;

import java.util.List;

/**
 * Created by tianxing on 16/7/15.
 * 网络获取的一条作业数据
 */
public class AssignmentDownload {


    private String id;
    private String teacherName;
    private String className;

    private String classID;



    //作业信息
    private String title;
    private String date;
    private String content;

    private List<ImageFile> images;

    public String getId() {
        return id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getClassName() {
        return className;
    }

    public String getClassID() {
        return classID;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public List<ImageFile> getImages() {
        return images;
    }


}
