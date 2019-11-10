package com.nguyenvk.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PaginationModel<T> {
    private List<T> items;
    private Long total;
    private Integer totalPage;
    private Integer itemPerPage;
}
