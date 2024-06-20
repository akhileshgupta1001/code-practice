package com.machine.coding.splitwise.model;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

public class Group extends BaseModel {
    private String
            name;
    @ManyToMany
    private List<User>
            members;
    @ManyToOne
    private User
            createdBy;
    @OneToMany(mappedBy = "group")
    private List<Expense>
            expenses;
}