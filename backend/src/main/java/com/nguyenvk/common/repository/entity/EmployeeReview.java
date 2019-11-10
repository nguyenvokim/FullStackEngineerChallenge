package com.nguyenvk.common.repository.entity;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "employee_reviews")
public class EmployeeReview extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer score;

    @Column(name = "reviewer_id")
    private Integer reviewerId;

    @Column(name = "employee_id")
    private Integer employeeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", updatable = false, insertable = false,
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @Setter(AccessLevel.NONE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reviewer_id", updatable = false, insertable = false,
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @Setter(AccessLevel.NONE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Employee reviewer;

    private String comment;
}
