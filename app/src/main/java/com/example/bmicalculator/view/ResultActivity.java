package com.example.bmicalculator.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.bmicalculator.R;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ResultActivity extends AppCompatActivity {

    // attributs de classe ResultActivity
    private TextView tvBMI,tvInterpretation;
    private Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        init();

        // affichage de la valeur de l'IMC et de l'interprétation obtenue
        tvBMI.setText("Valeur IMC = " + getIntent().getDoubleExtra("imc",0));
        tvInterpretation.setText(getIntent().getStringExtra("interpretation"));

        btnReturn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void init()
    {
        tvBMI = findViewById(R.id.tvBMI);
        tvInterpretation = findViewById(R.id.tvInterpretation);
        btnReturn = findViewById(R.id.btnReturn);
    }
}