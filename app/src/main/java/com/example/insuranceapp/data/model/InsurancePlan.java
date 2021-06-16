package com.example.insuranceapp.data.model;

public class InsurancePlan {
    private  String planName;
    private  String planDescription;
    private String planTenure;
    private String planPrice;

    public InsurancePlan() {
    }

    public InsurancePlan(String planName, String planDescription, String planTenure, String planPrice) {
        this.planName = planName;
        this.planDescription = planDescription;
        this.planTenure = planTenure;
        this.planPrice = planPrice;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanDescription() {
        return planDescription;
    }

    public void setPlanDescription(String planDescription) {
        this.planDescription = planDescription;
    }

    public String getPlanTenure() {
        return planTenure;
    }

    public void setPlanTenure(String planTenure) {
        this.planTenure = planTenure;
    }

    public String getPlanPrice() {
        return planPrice;
    }

    public void setPlanPrice(String planPrice) {
        this.planPrice = planPrice;
    }
}
