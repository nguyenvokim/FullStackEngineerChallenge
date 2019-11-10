package com.nguyenvk.common.repository;

import com.nguyenvk.common.repository.entity.EmployeeReviewRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeReviewRequestRepository extends BaseRepository<EmployeeReviewRequest, Integer> {
    EmployeeReviewRequest findByFromEmployeeIdAndToEmployeeIdAndState(Integer fromEmployeeId, Integer toEmployeeId, Integer state);
    List<EmployeeReviewRequest> findAllByFromEmployeeIdAndState(Integer fromEmployeeId, Integer state);
}
