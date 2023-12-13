package com.example.bmicalculator.controller;


import com.example.bmicalculator.model.BMI;

public class Controller {

    // Les attributs du classes Controller
    private static Controller instance = null;
    private Controller(){super();}
    private static BMI bmi;

    // Instanciation du Contrôleur suivant le pattern Singleton
    public static final Controller getInstance(){
        if(Controller.instance == null){
            Controller.instance = new Controller();
        }
        return Controller.instance;
    }


    public void createBMI(double weight, double height){
        bmi = new BMI(weight,height);
    }

    // Les getters nécessaires
    public String getIntrepretation(){
        return bmi.getInterpretation();
    }
    public double getIMC(){
        return bmi.getIMC();
    }

}
