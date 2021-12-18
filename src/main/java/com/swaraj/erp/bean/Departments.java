package com.swaraj.erp.bean;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="department")
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dept_id;
    @Column
    private String address;

    @Column
    private String departmentName;

    @OneToMany(mappedBy = "department")
    private List<Employees> employeesList;

    public Departments() {}

    public Departments(String address, String departmentName, List<Employees> employeesList) {
        this.address = address;
        this.departmentName = departmentName;
        this.employeesList = employeesList;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Employees> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(List<Employees> employeesList) {
        this.employeesList = employeesList;
    }
}


