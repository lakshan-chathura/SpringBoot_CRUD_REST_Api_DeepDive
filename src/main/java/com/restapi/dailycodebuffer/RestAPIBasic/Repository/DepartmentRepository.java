package com.restapi.dailycodebuffer.RestAPIBasic.Repository;

import com.restapi.dailycodebuffer.RestAPIBasic.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    public Department findDepartmentByDepartmentName(String departmentName);
}
