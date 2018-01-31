package com.example.cdsm.tp001;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Switch monSwitch;
    TextView txtFDME;
    TextView txtCDSM;
    TextView txt2017;
    TextView txtNom;
    TextView txtPrenom;
    TextView msgGetPrenom;
    TextView msgGetNom;
    TextView msgGetSexe;
    TextView msgPrenom;
    TextView msgNom;
    TextView msgSexe;
    EditText edtNom;
    EditText edtPrenom;

    RadioGroup myRadioGroup;
    RadioButton radioHomme;
    RadioButton radioFemme;
    Button btnAfficher;
    Button btnRaz;

    StringBuilder errorMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initControle();

        onAfficherClickListener();

        onRazClickListener();

    }

    private boolean checkFields() {
        return (!edtPrenom.getText().toString().isEmpty() && !edtNom.getText().toString().isEmpty() && (radioFemme.isChecked() || radioHomme.isChecked()));
    }

    private void handleError() {
        boolean valid = false;
        int errorNumber = -1;

        if (edtPrenom.getText().toString().isEmpty()) {
            valid = false;
            errorNumber = 1;
        }

        if (edtNom.getText().toString().isEmpty()) {

            valid = false;
            errorNumber = 0;
        }

        if(!radioHomme.isChecked() && !radioFemme.isChecked()) {
            valid = false;
            errorNumber = 2;
        }

        if (!valid) {
            switch (errorNumber) {
                case -1:
                    break;
                case 0:
                    edtPrenom.setError("Champs requis !");
                    break;
                case 1:
                    edtNom.setError("Champs requis !");
                    break;

                case 2:
                    Toast message = Toast.makeText(getApplicationContext(), "Au moins l'une des cases est requise!", Toast.LENGTH_LONG);
                    break;
            }

        }

    }

    private void onAfficherClickListener() {

        btnAfficher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (checkFields()) {
                    msgGetNom.setText(edtNom.getText());
                    msgGetPrenom.setText(edtPrenom.getText());

                    if (myRadioGroup.getCheckedRadioButtonId() > 0) {
                        msgGetSexe.setText(((RadioButton) findViewById(myRadioGroup.getCheckedRadioButtonId())).getText().toString());

                    } else {
                        msgGetSexe.setText("");
                    }
                }
            }
        });
    }

    public void onRazClickListener() {

        btnRaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // inputs reset
                edtNom.setText("");
                edtPrenom.setText("");

                // radio buttons reset
                radioFemme.setChecked(false);
                radioHomme.setChecked(false);
                myRadioGroup.clearCheck();

                // message reset
                msgGetSexe.setText("");
                msgGetPrenom.setText("");
                msgGetNom.setText("");

                // switch reset to 'ON'
                //monSwitch.setChecked(true);
            }
        });
    }

    private void initControle() {

        // init view elements
        monSwitch = (Switch) findViewById(R.id.switch1);
        txtFDME = (TextView) findViewById(R.id.ZoneFDME);
        txtCDSM = (TextView) findViewById(R.id.ZoneCDSM);
        txt2017 = (TextView) findViewById(R.id.Zone2017);
        txtNom = (TextView) findViewById(R.id.ZoneNom);
        txtPrenom = (TextView) findViewById(R.id.ZonePrenom);
        edtNom = (EditText) findViewById(R.id.EditNom);
        edtPrenom = (EditText) findViewById(R.id.EditPrenom);
        myRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        btnAfficher = (Button) findViewById(R.id.afficherBtn);

        msgGetNom = (TextView) findViewById(R.id.getNom);
        msgGetPrenom = (TextView) findViewById(R.id.getPrenom);
        msgGetSexe = (TextView) findViewById(R.id.getSexe);
        msgNom = (TextView) findViewById(R.id.Nom);
        msgPrenom = (TextView) findViewById(R.id.Prenom);
        msgSexe = (TextView) findViewById(R.id.Sexe);

        radioFemme = (RadioButton) findViewById(R.id.radioFemme);
        radioHomme = (RadioButton) findViewById(R.id.radioHomme);
        btnRaz = (Button) findViewById(R.id.razBtn);

        errorMessage = new StringBuilder();

        // init switch listener
        switchChangeListener();


        // init switch check state
        monSwitch.setChecked(true);
    }


    public void switchChangeListener() {
        monSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                changeViewVisibility(b);
            }
        });
    }


    private void changeViewVisibility(boolean b) {

        txtFDME.setVisibility((b ? View.INVISIBLE : View.VISIBLE));
        txtCDSM.setVisibility((b ? View.INVISIBLE : View.VISIBLE));
        txt2017.setVisibility((b ? View.INVISIBLE : View.VISIBLE));
        txtNom.setVisibility((b ? View.INVISIBLE : View.VISIBLE));
        txtPrenom.setVisibility((b ? View.INVISIBLE : View.VISIBLE));
        edtNom.setVisibility((b ? View.INVISIBLE : View.VISIBLE));
        edtPrenom.setVisibility((b ? View.INVISIBLE : View.VISIBLE));
        myRadioGroup.setVisibility((b ? View.INVISIBLE : View.VISIBLE));
        btnAfficher.setVisibility((b ? View.INVISIBLE : View.VISIBLE));
        btnRaz.setVisibility((b ? View.INVISIBLE : View.VISIBLE));
        msgGetPrenom.setVisibility((b ? View.INVISIBLE : View.VISIBLE));
        msgGetNom.setVisibility((b ? View.INVISIBLE : View.VISIBLE));
        msgGetSexe.setVisibility((b ? View.INVISIBLE : View.VISIBLE));
        msgNom.setVisibility((b ? View.INVISIBLE : View.VISIBLE));
        msgPrenom.setVisibility((b ? View.INVISIBLE : View.VISIBLE));
        msgSexe.setVisibility((b ? View.INVISIBLE : View.VISIBLE));
    }


}
