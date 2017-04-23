package com.gradlesfault.sidsrx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class ChemistVerificationActivity extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemist_verification);
        toolbar = (Toolbar)findViewById(R.id.chemist_main_activty_toolbar);
        setSupportActionBar(toolbar);
        TextView statusText = (TextView)findViewById(R.id.status_text);
        connectDB();
        //todo : check if prescription exists

        //temp for showing UI
        if(new Random().nextBoolean())
            statusText.setText("Verified!");
        else statusText.setText("Invalid Rx!");
    }
    public void connectDB(){
        MyDB.prescriptions = new ArrayList<Prescription>();
        MyDB.doctors = MyDB.fetchDoctors();
        MyDB.chemists = MyDB.fetchChemists();
    }
}


