package com.restapi.dailycodebuffer.RestAPIBasic.Service;

import com.restapi.dailycodebuffer.RestAPIBasic.Entity.Department;
import com.restapi.dailycodebuffer.RestAPIBasic.Repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;

//    @MockBean
//    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
//        Department department=Department.builder()
//                                .departmentId(1L)
//                                .departmentName("SE")
//                                .departmentCode("SE-06")
//                                .departmentAddress("Malabe-SLIIT")
//                                .build();
//        Mockito.when(departmentRepository.findDepartmentByDepartmentName("SE"))
//                    .thenReturn(department);
    }

    @Test
    @DisplayName("Get the data according to pass the departname")
    public void departmentNameValidation(){
        String departName="SE";
        Department department1=departmentService.findDepartmentName(departName);
        assertEquals(departName,department1.getDepartmentName());

    }
}