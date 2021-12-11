package com.swaraj.erp.util;

import com.swaraj.erp.bean.Courses;
import com.swaraj.erp.bean.Departments;
import com.swaraj.erp.bean.Employees;
import com.swaraj.erp.dao.impl.CourseDAOImpl;
import com.swaraj.erp.dao.impl.DepartmentDAOImpl;
import com.swaraj.erp.dao.impl.EmployeeDAOImpl;

public class Helper {
    public static void main(String args[]){
//        Courses c = new Courses("Javascript Course","SUMIT",4,100,"MONDAY : 5PM, SUNDAY : 6PM","CY",null);
//        CourseDAOImpl cdi = new CourseDAOImpl();
//        System.out.println(cdi.addCourse(c));
//        Departments d = new Departments("Bangalore , Karnataka","ADMIN",null);
//        DepartmentDAOImpl dai = new DepartmentDAOImpl();
//        System.out.println(dai.addDepartment(d));

        Employees e = new Employees(null,null,"swaraj@gmail.com","swaraj",null,null);
        EmployeeDAOImpl edi = new EmployeeDAOImpl();
        System.out.println(edi.verifyEmployee(e));
    }
}
