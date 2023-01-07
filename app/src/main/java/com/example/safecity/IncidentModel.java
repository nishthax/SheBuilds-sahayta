package com.example.safecity;

public class IncidentModel {
    String incidentType, incidentDate, incidentDesc, incidentST, incidentSrc;

    public IncidentModel(String incidentType, String incidentDate, String incidentDesc, String incidentST, String incidentSrc) {
        this.incidentType = incidentType;
        this.incidentDate = incidentDate;
        this.incidentDesc = incidentDesc;
        this.incidentST = incidentST;
        this.incidentSrc = incidentSrc;
    }

    public String getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(String incidentType) {
        this.incidentType = incidentType;
    }

    public String getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(String incidentDate) {
        this.incidentDate = incidentDate;
    }

    public String getIncidentDesc() {
        return incidentDesc;
    }

    public void setIncidentDesc(String incidentDesc) {
        this.incidentDesc = incidentDesc;
    }

    public String getIncidentST() {
        return incidentST;
    }

    public void setIncidentST(String incidentST) {
        this.incidentST = incidentST;
    }

    public String getIncidentSrc() {
        return incidentSrc;
    }

    public void setIncidentSrc(String incidentSrc) {
        this.incidentSrc = incidentSrc;
    }
}
