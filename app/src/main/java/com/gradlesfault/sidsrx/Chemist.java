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
    Chemist(int ID, String name, String email, int storeId){
        this.ID = ID;
        this.email = email;
        this.name = name;
        this.storeID = storeId;
    }

}
