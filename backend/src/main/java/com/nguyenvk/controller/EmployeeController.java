package com.nguyenvk.controller;

import com.nguyenvk.request.AddEmployeeRequest;
import com.nguyenvk.request.UpdateEmployeeRequest;
import com.nguyenvk.response.EmployeeModel;
import com.nguyenvk.response.ErrorModel;
import com.nguyenvk.response.SuccessModel;
import com.nguyenvk.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@Slf4j
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping(path = "/api/admin/employees")
    public List<EmployeeModel> getList() {
        return employeeService.getListEmployees();
    }

    @GetMapping(path = "/api/admin/employees/{id}")
    public EmployeeModel getOne(@PathVariable Integer id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping(path = "/api/admin/employees")
    public EmployeeModel addEmployee(@RequestBody AddEmployeeRequest addEmployeeRequest) {
        return employeeService.addEmployee(addEmployeeRequest);
    }

    @PutMapping(path = "/api/admin/employees/{id}")
    public EmployeeModel addEmployee(@PathVariable("id") Integer id, @RequestBody UpdateEmployeeRequest updateEmployeeRequest) {
        return employeeService.updateEmployee(id, updateEmployeeRequest);
    }

    @DeleteMapping(path = "/api/admin/employees/{id}")
    public SuccessModel deleteEmployee(@PathVariable("id") Integer id) {
        employeeService.deleteEmployee(id);
        return SuccessModel.builder().build();
    }

    @PostMapping(path = "/api/admin/employees/{id}/assignReview/{assignerId}")
    public Object assignEmployeeReview(@PathVariable("id") Integer id, @PathVariable("assignerId") Integer assignerId) {
        if (employeeService.checkHadPendingRequestReview(assignerId, id)) {
            return ErrorModel.builder()
                    .message("Employee already assign review")
                    .build();
        }
        return employeeService.addReviewRequest(assignerId, id);
    }
}
