package com.gradlesfault.sidsrx;

/**
 * Created by Sziraqui on 25-03-2017.
 */

public class Prescription {
    private int ID;
    private boolean EXPIRED = true;
    private int commision = 0;
    private int doctorID;
    private int patientID;
    Prescription(int ID, int doctorID, int patientID){
        this.ID = ID;
        this.doctorID = doctorID;
        this.patientID = patientID;
        EXPIRED = false;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCommision() {
        return commision;
    }

    public void setCommision(int commision) {
        this.commision = commision;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }
    public boolean isEXPIRED(){
        return this.EXPIRED;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }
}
