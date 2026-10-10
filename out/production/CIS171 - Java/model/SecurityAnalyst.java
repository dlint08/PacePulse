package model;

/**
 * Course: CIS171 Java
 * File: SecurityAnalyst.java
 * Description: Model class representing a Security Analyst POJO.
 */
public class SecurityAnalyst {
    private String analystName;
    private String certification;
    private int yearsExperience;
    private boolean activeIncident;

    public SecurityAnalyst() {
        this.analystName = "Unknown";
        this.certification = "None";
        this.yearsExperience = 0;
        this.activeIncident = false;
    }

    public SecurityAnalyst(String analystName, String certification, int yearsExperience, boolean activeIncident) {
        this.analystName = analystName;
        this.certification = certification;
        this.yearsExperience = yearsExperience;
        this.activeIncident = activeIncident;
    }

    public String getAnalystName() {
        return analystName;
    }

    public void setAnalystName(String analystName) {
        this.analystName = analystName;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(int yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    public boolean isActiveIncident() {
        return activeIncident;
    }

    public void setActiveIncident(boolean activeIncident) {
        this.activeIncident = activeIncident;
    }

    public String investigate() {
        return analystName + " is investigating a potential security incident.";
    }

    @Override
    public String toString() {
        return "SecurityAnalyst{" +
                "analystName='" + analystName + '\'' +
                ", certification='" + certification + '\'' +
                ", yearsExperience=" + yearsExperience +
                ", activeIncident=" + activeIncident +
                '}';
    }
}
