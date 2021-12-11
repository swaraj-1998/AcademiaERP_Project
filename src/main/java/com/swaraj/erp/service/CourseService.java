package com.swaraj.erp.service;

import com.swaraj.erp.bean.Courses;
import com.swaraj.erp.dao.impl.CourseDAOImpl;

import java.util.List;

public class CourseService {
    CourseDAOImpl courseDAO = new CourseDAOImpl(); //in DAO impl
    public boolean addCourse(Courses course){ //called from controller
        return courseDAO.addCourse(course); //calls the DAO method
    }
    public List<Courses> getCourses(){return courseDAO.getCourses();}
}
