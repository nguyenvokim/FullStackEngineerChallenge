package com.nguyenvk.service;

import com.nguyenvk.common.repository.EmployeeRepository;
import com.nguyenvk.common.repository.EmployeeReviewRequestRepository;
import com.nguyenvk.common.repository.entity.Employee;
import com.nguyenvk.common.repository.entity.EmployeeReviewRequest;
import com.nguyenvk.request.AddEmployeeRequest;
import com.nguyenvk.request.UpdateEmployeeRequest;
import com.nguyenvk.response.EmployeeModel;
import com.nguyenvk.response.EmployeeReviewRequestModel;
import com.nguyenvk.response.PaginationModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@Slf4j
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private EmployeeReviewRequestRepository employeeReviewRequestRepository;

    public EmployeeModel getEmployee(Integer id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            return EmployeeModel.createFromEmployee(optionalEmployee.get());
        }
        return EmployeeModel.builder().build();
    }

    public List<EmployeeModel> getListEmployees() {
        List<Employee> employeePage = employeeRepository.findAll();
        return employeePage.stream()
                .map(EmployeeModel::createFromEmployee)
                .collect(Collectors.toList());
    }

    public EmployeeModel addEmployee(AddEmployeeRequest addEmployeeRequest) {
        Employee employee = new Employee();
        employee.setName(addEmployeeRequest.getName());
        employee.setPosition(addEmployeeRequest.getPosition());
        employeeRepository.save(employee);
        return EmployeeModel.createFromEmployee(employee);
    }

    public EmployeeModel updateEmployee(Integer id, UpdateEmployeeRequest updateEmployeeRequest) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setPosition(updateEmployeeRequest.getPosition());
            employee.setName(updateEmployeeRequest.getName());
            employeeRepository.save(employee);
            return EmployeeModel.createFromEmployee(employee);
        }
        return EmployeeModel.builder().build();
    }

    public void deleteEmployee(Integer id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        optionalEmployee.ifPresent(employee -> employeeRepository.delete(employee));
    }

    public Boolean checkHadPendingRequestReview(Integer fromEmployeeId, Integer toEmployeeId) {
        EmployeeReviewRequest employeeReviewRequest = employeeReviewRequestRepository.findByFromEmployeeIdAndToEmployeeIdAndState(fromEmployeeId, toEmployeeId, EmployeeReviewRequest.STATE_WAIT_FOR_REVIEW);
        return employeeReviewRequest != null;
    }

    public EmployeeReviewRequestModel addReviewRequest(Integer fromEmployeeId, Integer toEmployeeId) {
        EmployeeReviewRequest employeeReviewRequest = EmployeeReviewRequest.builder()
                .fromEmployeeId(fromEmployeeId)
                .toEmployeeId(toEmployeeId)
                .state(EmployeeReviewRequest.STATE_WAIT_FOR_REVIEW)
                .build();
        employeeReviewRequestRepository.save(employeeReviewRequest);
        return EmployeeReviewRequestModel.createFromEmployeeReviewRequest(employeeReviewRequest);
    }
}
