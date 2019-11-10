package com.nguyenvk.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorModel {
    private final Boolean hasError = true;
    private Integer code;
    private String message;
}
