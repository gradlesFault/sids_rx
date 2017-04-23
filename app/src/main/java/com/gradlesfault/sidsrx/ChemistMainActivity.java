package com.gradlesfault.sidsrx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class ChemistMainActivity extends AppCompatActivity implements View.OnClickListener{
    Toolbar toolbar;
    EditText patientId;
    EditText presID;
    Button checkRxButton;
    Chemist chemist;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemist_main);
        connectDB();
        toolbar = (Toolbar)findViewById(R.id.chemist_main_activity_toolbar);
        setSupportActionBar(toolbar);
        chemist = MyDB.chemists.get(1);
        patientId = (EditText)findViewById(R.id.patient_id_edittext_chemist);
        presID = (EditText)findViewById(R.id.prescription_id_edittext_chemist);
        checkRxButton = (Button)findViewById(R.id.check_rx_button);

    }
    @Override
    public void onClick(View v) {
        if(patientId.getText().toString()==""){
            Toast.makeText(getApplicationContext(),"Enter patient ID",Toast.LENGTH_SHORT).show();
            return;
        }
        if (presID.getText().toString() == "") {
            Toast.makeText(getApplicationContext(),"Enter prescription ID",Toast.LENGTH_SHORT).show();
            return;
        }
        else if(chemist.checkPrescription(Integer.parseInt(presID.getText().toString()))){
            startActivity(new Intent(this, ChemistVerificationActivity.class));
        }
    }
    public void connectDB(){
        MyDB.prescriptions = new ArrayList<Prescription>();
        MyDB.doctors = MyDB.fetchDoctors();
        MyDB.chemists = MyDB.fetchChemists();
    }
}