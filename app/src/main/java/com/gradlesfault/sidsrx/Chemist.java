package com.gradlesfault.sidsrx;
import com.gradlesfault.sidsrx.Prescription;

import java.util.ArrayList;

/**
 * Created by Sziraqui on 25-03-2017.
 */

public class Chemist {
    private int ID;
    private String name;
    private String email;
    private int storeID;
    ArrayList<Prescription> prescriptions;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    Chemist(int ID, String name,/* String email,*/ int storeId){
        this.ID = ID;
       // this.email = email;
        this.name = name;
        this.storeID = storeId;
    }
    public boolean checkPrescription(int presID){
        return Prescription.verify(presID);
    }
    public boolean invalidatePrescription(int presID){
        boolean success = false;
        Prescription prescription = Prescription.getPrescriptionById(presID); //fetches prescription from database
        if(!prescription.isEXPIRED()){
            success = prescription.invalidate(); //returns true if database operation was successful
        }
        return success;
    }
}
