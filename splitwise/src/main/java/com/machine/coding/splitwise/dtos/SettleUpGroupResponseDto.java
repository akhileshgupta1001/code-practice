package com.machine.coding.splitwise.dtos;

import com.machine.coding.splitwise.model.Expense;
import lombok.Data;

import java.util.List;

@Data
public class SettleUpGroupResponseDto {
    private List<Expense>
            expenses;
}
