package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "application_details")
public class ApplicationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Foreign key reference to User entity
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "aadhar_no", length = 12, nullable = false)
    private String aadharNo;

    @Column(name = "pan_no", length = 10, nullable = false)
    private String panNo;

    // --- Getters and Setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(String aadharNo) {
        this.aadharNo = aadharNo;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }
}
