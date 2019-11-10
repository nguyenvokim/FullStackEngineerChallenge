package com.nguyenvk.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AddEmployeeReviewRequest {
    private Integer score;
    private String comment;
}
