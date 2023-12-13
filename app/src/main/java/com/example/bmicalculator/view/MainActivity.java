package com.example.bmicalculator.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bmicalculator.R;
import com.example.bmicalculator.controller.Controller;

public class MainActivity extends AppCompatActivity {

    // Les attributs de classe MainActivity
    private static final int CODE = 1;
    private EditText etWeight, etHeight;
    private Button btnCalculer;
    private Controller controller = Controller.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btnCalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double weight =0, height = 0;

                boolean verifWeight = false , verifHeight = false;

                if (!etWeight.getText().toString().isEmpty())
                    weight = Double.valueOf(etWeight.getText().toString());
                else
                    Toast.makeText(MainActivity.this, "Veuillez saisir votre poids (en kg)", Toast.LENGTH_SHORT).show();

                if (weight <= 0)
                    Toast.makeText(MainActivity.this, "Le poids ne peut pas etre négatif", Toast.LENGTH_LONG).show();
                else
                    verifWeight = true;

                if (!etHeight.getText().toString().isEmpty())
                    height = Double.valueOf(etHeight.getText().toString());
                else
                    Toast.makeText(MainActivity.this, "Veuillez saisir votre taille (en m)", Toast.LENGTH_SHORT).show();

                if (height <= 0)
                    Toast.makeText(MainActivity.this, "La taille ne peut pas etre négatif", Toast.LENGTH_LONG).show();
                else
                    verifHeight = true;

                if (verifWeight && verifHeight) {
                    controller.createBMI(weight, height);
                    double imc = controller.getIMC();
                    String intrepretation = controller.getIntrepretation();
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("imc",imc);
                    intent.putExtra("interpretation", intrepretation);
                    //noinspection deprecation
                    startActivityForResult(intent,CODE);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CODE)
            if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(MainActivity.this, "ERROR : RESULT_CANCELED", Toast.LENGTH_SHORT).show();
            }
    }

    private void init() {
        etWeight = findViewById(R.id.etWeight);
        etHeight = findViewById(R.id.etHeight);
        btnCalculer = findViewById(R.id.btnCalculer);
    }
}

