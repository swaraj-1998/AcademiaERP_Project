package com.swaraj.erp.service;

import com.swaraj.erp.bean.Employees;
import com.swaraj.erp.dao.EmployeesDAO;
import com.swaraj.erp.dao.impl.EmployeeDAOImpl;

import java.util.List;

public class EmployeesService {
    EmployeesDAO employeesDao = new EmployeeDAOImpl();
    public boolean addEmployee(Employees employees){
        return employeesDao.addEmployee(employees);
    }
    public boolean verifyEmployee(Employees e){
        return employeesDao.verifyEmployee(e);
    }
}
