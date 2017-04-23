package com.gradlesfault.sidsrx;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Login extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolbar;
    Button signIn;
    //EditText ID;
    RadioButton doctorRadioButton;
    RadioButton chemistRadioButton;
    boolean SIGN_IN_AS_DOCTOR = true;
    //String url = "https://gradlesfault.ml/get_doctors_list";
    private ProgressDialog pDialog;
   // JSONParser jsonParser = new JSONParser();
   // ArrayList<HashMap<String,String>> hashMapArrayList;
    private static final String DocID = "doctorID";
    private static final String ChemID = "chemistID";
   // ArrayList<Doctor> doctors;
    //ArrayList<Chemist> chemists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        toolbar = (Toolbar)findViewById(R.id.login_toolbar);
        setSupportActionBar(toolbar);

        doctorRadioButton = (RadioButton)findViewById(R.id.doctor_radio_button);
        doctorRadioButton.setChecked(true);
        chemistRadioButton = (RadioButton)findViewById(R.id.chemist_radio_button);
        chemistRadioButton.setChecked(false);
        chemistRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(doctorRadioButton.isChecked()){
                    SIGN_IN_AS_DOCTOR = false;
                    doctorRadioButton.setChecked(false);
                }
            }
        });
        doctorRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(doctorRadioButton.isChecked()){
                    SIGN_IN_AS_DOCTOR = true;
                    chemistRadioButton.setChecked(false);
                }
            }
        });
        signIn = (Button)findViewById(R.id.sign_in_button);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.sign_in_button :
                if(!doctorRadioButton.isChecked()) startActivity(new Intent(this, ChemistMainActivity.class));
                if(doctorRadioButton.isChecked()){
                    //if((new Doctor(Integer.parseInt(ID.getText()),"xyz",200))
                    startActivity(new Intent(this, DoctorMainActivity.class));
                }
                break;
        }
    }
   /* private class FetchDoctorChemistDB extends AsyncTask<Void,Void,Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(Login.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }
        @Override
        protected Void doInBackground(Void... arg0) {
            com.gradlesfault.sidsrx.HttpHandler sh = new com.gradlesfault.sidsrx.HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);

        }*/
}
