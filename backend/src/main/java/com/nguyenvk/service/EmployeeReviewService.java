package com.nguyenvk.service;

import com.nguyenvk.common.repository.EmployeeReviewRepository;
import com.nguyenvk.common.repository.EmployeeReviewRequestRepository;
import com.nguyenvk.common.repository.entity.Employee;
import com.nguyenvk.common.repository.entity.EmployeeReview;
import com.nguyenvk.common.repository.entity.EmployeeReviewRequest;
import com.nguyenvk.request.AddEmployeeRequest;
import com.nguyenvk.request.AddEmployeeReviewRequest;
import com.nguyenvk.response.EmployeeModel;
import com.nguyenvk.response.EmployeeReviewModel;
import com.nguyenvk.response.EmployeeReviewRequestModel;
import com.nguyenvk.response.PaginationModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeeReviewService {

    private EmployeeReviewRepository employeeReviewRepository;
    private EmployeeReviewRequestRepository employeeReviewRequestRepository;

    public EmployeeReviewModel getEmployeeReview(Integer id) {
        Optional<EmployeeReview> optionalEmployeeReview = employeeReviewRepository.findById(id);
        if (optionalEmployeeReview.isPresent()) {
            return EmployeeReviewModel.createFromEmployeeReview(optionalEmployeeReview.get());
        }
        return EmployeeReviewModel.builder().build();
    }

    public PaginationModel<EmployeeReviewModel> getListEmployeeReviewPaging(Integer page) {
        Page<EmployeeReview> employeeReviewPage = employeeReviewRepository.findAll(PageRequest.of(page - 1, 10, Sort.Direction.DESC, "id"));
        return PaginationModel.<EmployeeReviewModel>builder()
                .total(employeeReviewPage.getTotalElements())
                .totalPage(employeeReviewPage.getTotalPages())
                .itemPerPage(10)
                .items(employeeReviewPage
                        .getContent()
                        .stream()
                        .map(EmployeeReviewModel::createFromEmployeeReview)
                        .collect(Collectors.toList()))
                .build();
    }

    public List<EmployeeReviewRequestModel> getEmployeeReviewReqeuests(Integer employeeId) {
        List<EmployeeReviewRequest> employeeReviewRequests = employeeReviewRequestRepository.findAllByFromEmployeeIdAndState(employeeId, EmployeeReviewRequest.STATE_WAIT_FOR_REVIEW);
        return employeeReviewRequests.stream()
                .map(EmployeeReviewRequestModel::createFromEmployeeReviewRequest)
                .collect(Collectors.toList());
    }

    public void rejectReviewRequest(Integer id) {
        Optional<EmployeeReviewRequest> employeeReviewRequestOptional = employeeReviewRequestRepository.findById(id);
        if (employeeReviewRequestOptional.isPresent()) {
            EmployeeReviewRequest employeeReviewRequest = employeeReviewRequestOptional.get();
            if (employeeReviewRequest.getState().equals(EmployeeReviewRequest.STATE_WAIT_FOR_REVIEW)) {
                employeeReviewRequest.setState(EmployeeReviewRequest.STATE_REJECTED_REVIEW);
                employeeReviewRequestRepository.save(employeeReviewRequest);
            }
        }
    }

    public void addEmployeeReviewFromRequest(Integer requestId, AddEmployeeReviewRequest addEmployeeReviewRequest) {
        Optional<EmployeeReviewRequest> employeeReviewRequestOptional = employeeReviewRequestRepository.findById(requestId);
        if (!employeeReviewRequestOptional.isPresent()) {
            return;
        }
        EmployeeReviewRequest employeeReviewRequest = employeeReviewRequestOptional.get();
        if (employeeReviewRequest.getState() != EmployeeReviewRequest.STATE_WAIT_FOR_REVIEW) {
            return;
        }
        EmployeeReview employeeReview = EmployeeReview.builder()
                .score(addEmployeeReviewRequest.getScore())
                .comment(addEmployeeReviewRequest.getComment())
                .reviewerId(employeeReviewRequest.getFromEmployeeId())
                .employeeId(employeeReviewRequest.getToEmployeeId())
                .build();
        employeeReviewRepository.save(employeeReview);

        employeeReviewRequest.setState(EmployeeReviewRequest.STATE_FINISHED_REVIEW);
        employeeReviewRequest.setEmployeeReviewId(employeeReview.getId());
        employeeReviewRequestRepository.save(employeeReviewRequest);
    }
}
