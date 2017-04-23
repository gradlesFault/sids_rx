package com.gradlesfault.sidsrx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.Random;
import java.lang.*;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DoctorMainActivity extends AppCompatActivity {
    Toolbar toolbar;
    Button generate_rx_id_button;
    Button save_button;
    TextView random_rx;
    EditText patient_id_edittext_doctor;
    Random myRandom;
    SQLiteDatabase db;
    String paid; //PAtient ID
    String result2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_main);
        toolbar = (Toolbar) findViewById(R.id.doctor_main_activty_toolbar);
        setSupportActionBar(toolbar);
        connectDB();
        patient_id_edittext_doctor = (EditText) findViewById(R.id.patient_id_edittext_doctor);
        paid =  patient_id_edittext_doctor.getText().toString();
        Log.d("patID",paid);

        generate_rx_id_button = (Button) findViewById(R.id.generate_rx_id_button);
        random_rx = (TextView) findViewById(R.id.random_rx);

        generate_rx_id_button.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Random myRandom = new Random();
                Integer result2 = myRandom.nextInt();
                random_rx.setText(result2.toString());
                CardView cardView = (CardView)findViewById(R.id.generated_rxid_card);
                cardView.setVisibility(View.VISIBLE);
                if(MyDB.doctors == null){
                    MyDB.doctors = MyDB.fetchDoctors();
                }
                Prescription prescription = new Prescription(result2,MyDB.fetchDoctors().get(0).getID(),123);
                prescription.setExpiredStatus(false);
                if(MyDB.prescriptions == null){
                    MyDB.prescriptions = new ArrayList<Prescription>();
                }
                MyDB.prescriptions.add(prescription);
            }
        });

    }
    public void connectDB(){
        MyDB.prescriptions = new ArrayList<Prescription>();
        MyDB.doctors = MyDB.fetchDoctors();
        MyDB.chemists = MyDB.fetchChemists();
    }

}
