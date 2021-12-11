package com.swaraj.erp.dao;

import com.swaraj.erp.bean.Employees;

import java.util.List;

public interface EmployeesDAO {
    boolean addEmployee(Employees emp);
    boolean verifyEmployee(Employees e);
}
