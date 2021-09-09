package com.example.testdepartment.model;

public class Department {
    private Long id;
    private DepartmentName name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DepartmentName getName() {
        return name;
    }

    public void setName(DepartmentName name) {
        this.name = name;
    }

    public enum DepartmentName {
        FINANCE,
        HR,
        TECH
    }
}
