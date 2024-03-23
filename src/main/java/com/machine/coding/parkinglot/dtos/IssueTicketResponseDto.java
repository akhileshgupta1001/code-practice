package com.machine.coding.parkinglot.dtos;

import com.machine.coding.parkinglot.model.Ticket;

public class IssueTicketResponseDto {
    private ResponseStatus responseStatus;
    private Ticket ticket;

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
