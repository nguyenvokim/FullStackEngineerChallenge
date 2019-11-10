package com.nguyenvk.response;

import com.nguyenvk.common.repository.entity.EmployeeReview;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeReviewModel {

    private Integer id;
    private Integer score;
    private String comment;
    private Integer employeeId;
    private Integer reviewerId;
    private EmployeeModel reviewer;
    private EmployeeModel employee;

    private Date createdAt;
    private Date updatedAt;

    public static EmployeeReviewModel createFromEmployeeReview(EmployeeReview employeeReview) {
        EmployeeReviewModel employeeReviewModel = EmployeeReviewModel.builder()
                .comment(employeeReview.getComment())
                .score(employeeReview.getScore())
                .employeeId(employeeReview.getEmployeeId())
                .reviewerId(employeeReview.getReviewerId())
                .id(employeeReview.getId())
                .createdAt(employeeReview.getCreatedAt())
                .updatedAt(employeeReview.getUpdatedAt())
                .build();
        if (employeeReview.getEmployeeId() != null) {
            employeeReviewModel.setEmployee(EmployeeModel.createFromEmployee(employeeReview.getEmployee()));
        }
        if (employeeReview.getReviewerId() != null) {
            employeeReviewModel.setReviewer(EmployeeModel.createFromEmployee(employeeReview.getReviewer()));
        }
        return employeeReviewModel;
    }
}
