package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "application_status")
public class ApplicationStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "app_status_seq")
	@SequenceGenerator(name = "app_status_seq", sequenceName = "APPLICATION_STATUS_SEQ", allocationSize = 1)
	private int applicationId;


    @Column(length = 40)
    private String customerName;

    @Column(length = 50)
    private String email;

    @Column(length = 15)
    private String phone;

    @Column(length = 10)
    private String panNumber;

    @Column(length = 14)
    private String aadharNo;

    @Column(length = 20)
    private String bankAccountNo;

    @Column(length = 20)
    private String employmentType;

    private double monthlyIncome;
    private double loanAmount;
    private double interestRate;
    private int tenureMonths;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "application_date")
    private Date applicationDate;

    public Date getApplicationDate() { return applicationDate; }
    public void setApplicationDate(Date applicationDate) { this.applicationDate = applicationDate; }


    @Column(length = 20)
    private String vehicleType;

    @Column(length = 10)
    private String salarySlip;

    @Column(length = 25)
    private String applicationStatus;

    @Column(length = 5)
    private String adminVerified;

    // --- Getters & Setters for ALL fields ---

    public int getApplicationId() { return applicationId; }
    public void setApplicationId(int applicationId) { this.applicationId = applicationId; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getPanNumber() { return panNumber; }
    public void setPanNumber(String panNumber) { this.panNumber = panNumber; }

    public String getAadharNo() { return aadharNo; }
    public void setAadharNo(String aadharNo) { this.aadharNo = aadharNo; }

    public String getBankAccountNo() { return bankAccountNo; }
    public void setBankAccountNo(String bankAccountNo) { this.bankAccountNo = bankAccountNo; }

    public String getEmploymentType() { return employmentType; }
    public void setEmploymentType(String employmentType) { this.employmentType = employmentType; }

    public double getMonthlyIncome() { return monthlyIncome; }
    public void setMonthlyIncome(double monthlyIncome) { this.monthlyIncome = monthlyIncome; }

    public double getLoanAmount() { return loanAmount; }
    public void setLoanAmount(double loanAmount) { this.loanAmount = loanAmount; }

    public double getInterestRate() { return interestRate; }
    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }

    public int getTenureMonths() { return tenureMonths; }
    public void setTenureMonths(int tenureMonths) { this.tenureMonths = tenureMonths; }

    public String getVehicleType() { return vehicleType; }
    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }

    public String getSalarySlip() { return salarySlip; }
    public void setSalarySlip(String salarySlip) { this.salarySlip = salarySlip; }

    public String getApplicationStatus() { return applicationStatus; }
    public void setApplicationStatus(String applicationStatus) { this.applicationStatus = applicationStatus; }

    public String getAdminVerified() { return adminVerified; }
    public void setAdminVerified(String adminVerified) { this.adminVerified = adminVerified; }
}
