package com.machine.coding.splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

@Entity
@Getter
@Setter
public class ExpenseUser extends BaseModel{

    @ManyToOne
    private Expense expense;

    private User user;

    private int amount;
    private ExpenseUserType expenseUserType;
}
