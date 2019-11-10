package com.nguyenvk.common.repository;

import com.nguyenvk.common.repository.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends BaseRepository<Employee, Integer> {
}
