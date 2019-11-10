package com.nguyenvk.response;

import com.nguyenvk.common.repository.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeModel {
    private Integer id;
    private String position;
    private String name;

    private Date createdAt;
    private Date updatedAt;

    public static EmployeeModel createFromEmployee(Employee employee) {
        return EmployeeModel.builder()
                .id(employee.getId())
                .name(employee.getName())
                .position(employee.getPosition())
                .createdAt(employee.getCreatedAt())
                .updatedAt(employee.getUpdatedAt())
                .build();
    }
}
