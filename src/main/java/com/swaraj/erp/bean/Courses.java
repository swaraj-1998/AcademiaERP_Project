package com.swaraj.erp.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="course" )
public class Courses implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int course_id;

    @Column
    private String name;

    @Column
    private String professor;

    @Column
    private int credits;

    @Column
    private int capacity;

    @Column
    private String schedule;

    @Column
    private String specialization;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Courses> prerequisites;

    public Courses() {
    }

    public Courses(String name, String professor, int credits, int capacity, String schedule, String specialization, List<Courses> prerequisites) {
        this.name = name;
        this.professor = professor;
        this.credits = credits;
        this.capacity = capacity;
        this.schedule = schedule;
        this.specialization = specialization;
        this.prerequisites = prerequisites;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public List<Courses> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(List<Courses> prerequisites) {
        this.prerequisites = prerequisites;
    }
}