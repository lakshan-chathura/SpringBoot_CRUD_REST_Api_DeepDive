package com.restapi.dailycodebuffer.RestAPIBasic.Service;

import com.restapi.dailycodebuffer.RestAPIBasic.Entity.Department;
import com.restapi.dailycodebuffer.RestAPIBasic.Repository.DepartmentRepository;
import error.DepartmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findDepartmentName(String departmentName) {
        return departmentRepository.findDepartmentByDepartmentName(departmentName);
    }

    @Override
    public Department getDepartment(Long id) throws DepartmentNotFoundException {
        Optional<Department> optionalDepartment=departmentRepository.findById(id);
        if(!optionalDepartment.isPresent()){
            throw new DepartmentNotFoundException("Department Not Found");
        }
        return  optionalDepartment.get();
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
            Department dep1=departmentRepository.findById(id).get();
            if(Objects.nonNull(department.getDepartmentName())&& !department.getDepartmentName().equalsIgnoreCase("")){
                dep1.setDepartmentName(department.getDepartmentName());
            }
            if(Objects.nonNull(department.getDepartmentAddress())&& !department.getDepartmentAddress().equalsIgnoreCase("")){
                dep1.setDepartmentAddress(department.getDepartmentAddress());
            }
            if(Objects.nonNull(department.getDepartmentCode())&& !department.getDepartmentCode().equalsIgnoreCase("")){
                dep1.setDepartmentCode(department.getDepartmentCode());
            }
            return departmentRepository.save(dep1);
    }
}
