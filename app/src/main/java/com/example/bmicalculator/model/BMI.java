package com.example.bmicalculator.model;

import java.text.DecimalFormat;

public class BMI {

    private double weight;
    private double height;
    private double imc;
    private String interpretation;

    // constructeur de la classe
    public BMI(double weight, double height){
        this.weight = weight;
        this.height = height;
        calculer();
    }


    // getters nécessaires
    public double getWeight(){
        return this.weight;
    }

    public double getHeight() {
        return height;
    }

    public double getIMC() {
        return imc;
    }
    public String getInterpretation(){
        return interpretation;
    }
    // Methode de calcule et interpretation du BMI
    public void calculer(){
        imc = weight / (height * height);
        DecimalFormat dtime = new DecimalFormat("#.###");
        imc = Double.valueOf(dtime.format(imc));
        if (imc >= 30){
            interpretation = "Obésité";
            }
            else if (imc >= 25) {
                interpretation = "Surpoids";
                }
                else if (imc >18.5) {
                    interpretation = "Poids normal";
                }
                    else {
                        interpretation = "Insuffisance pondérale";
                    }
    }

}