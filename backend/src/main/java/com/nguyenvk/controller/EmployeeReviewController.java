package com.nguyenvk.controller;

import com.nguyenvk.request.AddEmployeeRequest;
import com.nguyenvk.request.AddEmployeeReviewRequest;
import com.nguyenvk.request.UpdateEmployeeRequest;
import com.nguyenvk.response.EmployeeReviewModel;
import com.nguyenvk.response.EmployeeReviewRequestModel;
import com.nguyenvk.response.PaginationModel;
import com.nguyenvk.response.SuccessModel;
import com.nguyenvk.service.EmployeeReviewService;
import com.nguyenvk.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@Slf4j
public class EmployeeReviewController {

    private EmployeeService employeeService;
    private EmployeeReviewService employeeReviewService;

    @GetMapping(path = "/api/admin/employeeReviews")
    public PaginationModel<EmployeeReviewModel> getList(@RequestParam(defaultValue = "1") Integer page) {
        return employeeReviewService.getListEmployeeReviewPaging(page);
    }

    @GetMapping(path = "/api/admin/employeeReviews/{id}")
    public EmployeeReviewModel getOne(@PathVariable Integer id) {
        return employeeReviewService.getEmployeeReview(id);
    }

    @GetMapping(path = "/api/employees/{id}/reviewRequests")
    public List<EmployeeReviewRequestModel> getEmployeeReviewRequest(@PathVariable("id") Integer id) {
        return employeeReviewService.getEmployeeReviewReqeuests(id);
    }

    @DeleteMapping(path = "/api/employees/{id}/reviewRequests/{reviewRequestId}")
    public SuccessModel getEmployeeReviewRequest(@PathVariable("id") Integer id, @PathVariable("reviewRequestId") Integer reviewRequestId) {
        employeeReviewService.rejectReviewRequest(reviewRequestId);
        return SuccessModel.builder().build();
    }

    @PostMapping(path = "/api/employees/{id}/reviewRequests/{reviewRequestId}")
    public SuccessModel addEmployeeReview(@PathVariable("id") Integer id, @PathVariable("reviewRequestId") Integer reviewRequestId, @RequestBody AddEmployeeReviewRequest addEmployeeReviewRequest) {
        employeeReviewService.addEmployeeReviewFromRequest(reviewRequestId, addEmployeeReviewRequest);
        return SuccessModel.builder().build();
    }

//    @PostMapping(path = "/api/admin/employees")
//    public EmployeeModel addEmployee(@RequestBody AddEmployeeRequest addEmployeeRequest) {
//        return employeeService.addEmployee(addEmployeeRequest);
//    }
//
//    @PutMapping(path = "/api/admin/employees/{id}")
//    public EmployeeModel addEmployee(@PathVariable("id") Integer id, @RequestBody UpdateEmployeeRequest updateEmployeeRequest) {
//        return employeeService.updateEmployee(id, updateEmployeeRequest);
//    }
//
//    @DeleteMapping(path = "/api/admin/employees/{id}")
//    public SuccessModel deleteEmployee(@PathVariable("id") Integer id) {
//        employeeService.deleteEmployee(id);
//        return SuccessModel.builder().build();
//    }
}
