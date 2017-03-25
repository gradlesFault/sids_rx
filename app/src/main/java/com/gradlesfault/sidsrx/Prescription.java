package com.gradlesfault.sidsrx;

/**
 * Created by Sziraqui on 25-03-2017.
 */

public class Prescription {
    private int ID;
    private boolean EXPIRED = true;
    private int doctorID;
    private int patientID;
    Prescription(int ID, int doctorID, int patientID){
        this.ID = ID;
        this.doctorID = doctorID;
        this.patientID = patientID;
        EXPIRED = false;
    }

    public static boolean verify(int presID){
        //todo: check if prescription exists on database
        return true;
    }
    //method to create a local copy of Prescription from remote server
    public static Prescription getPrescriptionById(int presID){
        // todo: fetch prescription details from server for Prescription ID presID

        Prescription prescription;
        int ID = 0;
        int patientID = 0;
        int doctorID = 0;

        boolean EXPIRED = false;

        prescription = new Prescription(ID,doctorID,patientID);
        prescription.EXPIRED =  EXPIRED;
        return prescription;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
    public boolean invalidate(){
        //todo : set EXPIRE status to false on database and update database;
        boolean success = true;
        //todo: set success to false if database operation was not successful
        if(success){
            this.EXPIRED = true; //update local copy
        }
        return success;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }
}
