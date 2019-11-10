package com.nguyenvk.common.repository.entity;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "employee_review_requests")
public class EmployeeReviewRequest extends BaseEntity {

    public static final Integer STATE_WAIT_FOR_REVIEW = 0;
    public static final Integer STATE_FINISHED_REVIEW = 1;
    public static final Integer STATE_REJECTED_REVIEW = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "from_employee_id")
    private Integer fromEmployeeId;

    @Column(name = "to_employee_id")
    private Integer toEmployeeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_employee_id", updatable = false, insertable = false,
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @Setter(AccessLevel.NONE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Employee toEmployee;

    @Column(name = "employee_review_id")
    private Integer employeeReviewId;

    @Column(name = "state")
    private Integer state;
}
