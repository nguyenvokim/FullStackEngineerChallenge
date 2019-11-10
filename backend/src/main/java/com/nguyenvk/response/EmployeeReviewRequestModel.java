package com.nguyenvk.response;

import com.nguyenvk.common.repository.entity.EmployeeReviewRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeReviewRequestModel {

    private Integer id;
    private Integer fromEmployeeId;
    private Integer toEmployeeId;
    private EmployeeModel toEmployee;
    private Integer employeeReviewId;
    private Integer state;

    private Date createdAt;
    private Date updatedAt;

    public static EmployeeReviewRequestModel createFromEmployeeReviewRequest(EmployeeReviewRequest employeeReviewRequest) {
        EmployeeReviewRequestModel employeeReviewRequestModel = EmployeeReviewRequestModel.builder()
                .id(employeeReviewRequest.getId())
                .employeeReviewId(employeeReviewRequest.getEmployeeReviewId())
                .fromEmployeeId(employeeReviewRequest.getFromEmployeeId())
                .toEmployeeId(employeeReviewRequest.getToEmployeeId())
                .state(employeeReviewRequest.getState())
                .createdAt(employeeReviewRequest.getCreatedAt())
                .updatedAt(employeeReviewRequest.getUpdatedAt())
                .build();
        if (employeeReviewRequest.getToEmployee() != null) {
            employeeReviewRequestModel.setToEmployee(EmployeeModel.createFromEmployee(employeeReviewRequest.getToEmployee()));
        }
        return employeeReviewRequestModel;
    }
}
