package com.hms.diagnosis;

public class Diagnosis {
    private String diagnosisId;
    private String diagnosisName;

    public Diagnosis(String diagnosisId, String diagnosisName) {
        this.diagnosisId = diagnosisId;
        this.diagnosisName = diagnosisName;
    }

    public String getDiagnosisId() {
        return diagnosisId;
    }

    public String getDiagnosisName() {
        return diagnosisName;
    }

    @Override
    public String toString() {
        return "Diagnosis ID: " + diagnosisId + ", Diagnosis Name: " + diagnosisName;
    }
}
