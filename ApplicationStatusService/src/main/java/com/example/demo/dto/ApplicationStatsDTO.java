package com.example.demo.dto;

public class ApplicationStatsDTO {
    private long totalUsers;
    private long totalApplications;
    private long approvedLoans;
    private double totalDisbursed;
	public long getTotalUsers() {
		return totalUsers;
	}
	public void setTotalUsers(long totalUsers) {
		this.totalUsers = totalUsers;
	}
	public long getTotalApplications() {
		return totalApplications;
	}
	public void setTotalApplications(long totalApplications) {
		this.totalApplications = totalApplications;
	}
	public long getApprovedLoans() {
		return approvedLoans;
	}
	public void setApprovedLoans(long approvedLoans) {
		this.approvedLoans = approvedLoans;
	}
	public double getTotalDisbursed() {
		return totalDisbursed;
	}
	public void setTotalDisbursed(double totalDisbursed) {
		this.totalDisbursed = totalDisbursed;
	}

    // Getters and Setters
}