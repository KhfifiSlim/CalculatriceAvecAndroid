package com.dev_mobile.calculatriceandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;



public class MainActivity extends AppCompatActivity {

    TextView Expression;
    TextView Resultat;
    String Calcul = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Expression = (TextView) findViewById(R.id.ExpressionTextView);
        Resultat = (TextView) findViewById(R.id.resultTextView);


    }


    private void setCalcul(String ValeurSaisi) {
        Calcul = Calcul + ValeurSaisi;
        Expression.setText(Calcul);
    }

  

    public void ResultatOnClick(View view) {
        Double result = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");


        try {
            result = (double) engine.eval(Calcul);

        } catch (ScriptException e) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }

        if (result != null)
            Resultat.setText(String.valueOf(result.doubleValue()));


    }


    boolean leftBracket = true;

    public void ParantheseOnClick(View view) {
        if (leftBracket) {
            setCalcul("(");
            leftBracket = false;
        } else {
            setCalcul(")");
            leftBracket = true;
        }
    }


    public void ClearOnClick(View view) {
        Expression.setText("");
        Calcul = "";
        Resultat.setText("");
        leftBracket = true;

    }


    public void divisionOnClick(View view) {
        setCalcul("/");
    }

    public void sevenOnClick(View view) {
        setCalcul("7");
    }

    public void eightOnClick(View view) {
        setCalcul("8");
    }

    public void nineOnClick(View view) {
        setCalcul("9");
    }

    public void timesOnClick(View view) {
        setCalcul("*");
    }

    public void fourOnClick(View view) {
        setCalcul("4");
    }

    public void fiveOnClick(View view) {
        setCalcul("5");
    }

    public void sixOnClick(View view) {
        setCalcul("6");
    }

    public void minusOnClick(View view) {
        setCalcul("-");
    }

    public void oneOnClick(View view) {
        setCalcul("1");
    }

    public void twoOnClick(View view) {
        setCalcul("2");
    }

    public void threeOnClick(View view) {
        setCalcul("3");
    }

    public void plusOnClick(View view) {
        setCalcul("+");
    }

    public void decimalOnClick(View view) {
        setCalcul(".");
    }

    public void zeroOnClick(View view) {
        setCalcul("0");
    }





    @Override
    protected void onResume() {

        super.onResume();
        Toast.makeText(getApplicationContext(), "onResumed called", Toast.LENGTH_LONG).show();


    }

    @Override
    protected void onPause() {

        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause called", Toast.LENGTH_LONG).show();


    }



}