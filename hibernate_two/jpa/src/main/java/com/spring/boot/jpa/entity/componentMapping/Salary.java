package com.spring.boot.jpa.entity.componentMapping;

// this particular salary class cannot be an entity because i dont want to
//have a different table for it i want to use this particular properties for my
//employee table only
// we can embed this salary class inside our employee class
// for employee class to embed this class it should be embeddable

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Salary {

    private Double basicSalary;
    private Double bonusSalary;
    private Double taxAmount;
    private Double specialAllowanceSalary;

}
