package com.apro.main.entity;

public enum LoanStatus {
    APPROVED("Approved"),
    REJECTED("Rejected"),
    APPLIED("Applied");

    private final String status;


    LoanStatus(String status) {
        this.status = status;
    }


    public String getStatus() {
        return status;
    }

    public static LoanStatus getStatus(String status) {
        for (LoanStatus loanStatus : LoanStatus.values()) {
            if (loanStatus.status.equalsIgnoreCase(status)) {
                return loanStatus;
            }
        }
		return null;
        
    }
}