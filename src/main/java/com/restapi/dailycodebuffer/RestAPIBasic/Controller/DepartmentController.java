package com.restapi.dailycodebuffer.RestAPIBasic.Controller;

import com.restapi.dailycodebuffer.RestAPIBasic.Entity.Department;
import com.restapi.dailycodebuffer.RestAPIBasic.Service.DepartmentService;
import error.DepartmentNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    private final Logger LOGGER= LoggerFactory.getLogger(DepartmentController.class);
    @Value("${welcome.message}")
    private String welcomeMessage;

    @GetMapping("/index")
    public String getWelcomeMessage(){
        return welcomeMessage;
    }

    //Ok Tested
    @PostMapping("/saveDepartment")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("This is savedepartment method");
        return departmentService.saveDepartment(department);
    }
    //Ok Tested
    @GetMapping("/getDepartments")
    public List<Department> getDepartments(){
        return departmentService.getAllDepartments();
    }

    //Ok Tested
    @GetMapping("/getDepartment/{id}")
    public Department getDepartment(@PathVariable("id") Long id) throws DepartmentNotFoundException {

        return departmentService.getDepartment(id);
    }

    //Ok Tested
    @PutMapping("/updateDepartment/{id}")
    public Department updateDepartment(@PathVariable("id") Long id,@RequestBody Department department){
        return departmentService.updateDepartment(id,department);
    }

    //Ok Tested
    @DeleteMapping("/deleteDepartment/{id}")
    public String deleteDepartment(@PathVariable("id") Long id){
        departmentService.deleteDepartment(id);
        return "Department Deleted Sucessfully!!";
    }

    @GetMapping("/findDepartName/name/{name}")
    public Department findDepartmentName(@PathVariable("name") String departmentName){
        return departmentService.findDepartmentName(departmentName);

    }
}
