package com.swaraj.erp.service;

import com.swaraj.erp.bean.Departments;
import com.swaraj.erp.dao.DepartmentsDAO;
import com.swaraj.erp.dao.impl.DepartmentDAOImpl;

public class DepartmentsService {
    DepartmentsDAO departmentDao= new DepartmentDAOImpl();
    public boolean addDepartment(Departments departments){
        return departmentDao.addDepartment(departments);
    }
}
