package com.restapi.dailycodebuffer.RestAPIBasic.Service;

import com.restapi.dailycodebuffer.RestAPIBasic.Entity.Department;
import error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> getAllDepartments();

    public Department getDepartment(Long id) throws DepartmentNotFoundException;

    public void deleteDepartment(Long id);

    public Department updateDepartment(Long id, Department department);

    public Department findDepartmentName(String departmentName);
}
