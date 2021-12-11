package com.swaraj.erp.dao;

import com.swaraj.erp.bean.Courses;

import java.util.List;

public interface CoursesDAO {
    boolean addCourse(Courses course);
    List<Courses> getCourses();
}
