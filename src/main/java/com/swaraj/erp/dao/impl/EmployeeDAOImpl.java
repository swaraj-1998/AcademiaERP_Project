package com.swaraj.erp.dao.impl;

import com.swaraj.erp.bean.Employees;
import com.swaraj.erp.dao.EmployeesDAO;
import com.swaraj.erp.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeesDAO {
    @Override
    public boolean addEmployee(Employees emp) {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction t = session.beginTransaction();
            session.save(emp);
            t.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public boolean verifyEmployee(Employees e) {
        String email = e.getEmailId();
        try (Session session = HibernateSessionUtil.getSession();){

            for (final Object employee : session.createQuery("from Employees where emailId=:email").setParameter("email", email).list()) {
                Employees emp = (Employees)employee;
                String p1 = emp.getPassword();
                String p2 = e.getPassword();
                if( p1.equals(p2)){
                    return true;
                }
                else{
                    System.out.println("Pass 1" +  p1);
                    System.out.println("Pass 2" + p2);
                }
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return false;
    }
}