package com.machine.coding.splitwise.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

import java.util.List;

@Entity
@Getter
@Setter
public class Expense extends BaseModel {

    private String description;

    private int amount ;

    @ManyToOne
    private User createdBy;

    @Enumerated(EnumType.ORDINAL)
    private  ExpenseType expenseType;

    @ManyToOne
    private Group group;

    @OneToMany
    private List<ExpenseUser> expenseUsers;
}
