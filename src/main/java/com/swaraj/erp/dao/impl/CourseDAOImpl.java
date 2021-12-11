package com.swaraj.erp.dao.impl;

import com.swaraj.erp.bean.Courses;
import com.swaraj.erp.dao.CoursesDAO;
import com.swaraj.erp.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CoursesDAO {
    @Override
    public boolean addCourse(Courses course) {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction t = session.beginTransaction();
            session.save(course);
            t.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public List<Courses> getCourses() {
        List<Courses> coursesList = new ArrayList<>();
        try (Session session = HibernateSessionUtil.getSession();){
            for (final Object course : session.createQuery("from Courses ").list()) {
                coursesList.add((Courses) course);
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return coursesList;
    }
}