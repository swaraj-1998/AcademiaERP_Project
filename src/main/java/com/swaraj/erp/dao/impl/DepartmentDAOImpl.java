
package com.swaraj.erp.dao.impl;

import com.swaraj.erp.bean.Departments;
import com.swaraj.erp.dao.DepartmentsDAO;
import com.swaraj.erp.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DepartmentDAOImpl implements DepartmentsDAO {
    @Override
    public boolean addDepartment(Departments dept) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(dept);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }
}