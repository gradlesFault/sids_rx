package com.gradlesfault.sidsrx;

import java.util.ArrayList;

/**
 * Created by Sziraqui on 26-03-2017.
 */

public class MyDB {
    static ArrayList<Doctor> doctors = new ArrayList<Doctor>();
    static ArrayList<Chemist> chemists = new ArrayList<Chemist>();
    static ArrayList<Prescription> prescriptions;
    public static ArrayList<Doctor> fetchDoctors(){
        doctors.add(new Doctor(101,"Dr. Darsh",201));
        doctors.add(new Doctor(102,"Dr. Sarfaraz",201));
        doctors.add(new Doctor(103,"Dr. Sharma",202));
        doctors.add(new Doctor(104,"Dr. Bhatra",202));
        doctors.add(new Doctor(105,"Dr. Khanna",202));
        return doctors;
    }
    public static ArrayList<Chemist> fetchChemists(){
        chemists.add(new Chemist(301,"Dr. Darsh",401));
        chemists.add(new Chemist(302,"Dr. Darsh",401));
        chemists.add(new Chemist(303,"Dr. Darsh",402));
        chemists.add(new Chemist(304,"Dr. Darsh",402));
        chemists.add(new Chemist(305,"Dr. Darsh",403));
        return chemists;
    }
    public static ArrayList<Prescription> fetchPrescription(){
        return prescriptions;
    }
    public static boolean addPrescription(Prescription prescription){
        prescriptions.add(prescription);
        return true;
    }
    public boolean exists(Object object) {
        if (object instanceof Doctor) {
            for (Doctor each : doctors) {
                if (each.getID() == ((Doctor) object).getID())
                    return true;
            }
        } else {
            for (Chemist each : chemists) {
                if (each.getID() == ((Chemist) object).getID())
                    return true;
            }
        }
        return false;
    }
}
