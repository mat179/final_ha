package ru.lanit.utils;

public class RxDTO {
    private String patientId;
    private String patientName;
    private String symptoms;
    private String medicine;

    public RxDTO() {
    }

    public RxDTO(String patientName, String symptoms, String medicine) {
        this.patientName = patientName;
        this.symptoms = symptoms;
        this.medicine = medicine;
    }

    public RxDTO(String patientId, String patientName, String symptoms, String medicine) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.symptoms = symptoms;
        this.medicine = medicine;
    }

    public String getMedicine() {
        return medicine;
    }
    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }
    public String getSymptoms() {
        return symptoms;
    }
    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }
    public String getPatientName() {
        return patientName;
    }
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    public String getPatientId() {
        return patientId;
    }
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
}
