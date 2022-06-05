package com.example.nutrilife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {
    private Button btn_voltar;
    private TextView txt_resultado,txt_resultado2;
    private String texto,texto2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        btn_voltar = findViewById(R.id.btn_voltar);
        txt_resultado = findViewById(R.id.txt_resultado);
        txt_resultado2 = findViewById(R.id.txt_resultado2);

        Intent intent = getIntent();
        String nome = intent.getStringExtra("nome");
        double peso = intent.getDoubleExtra("peso",0);
        double altura = intent.getDoubleExtra("altura",0);
        int sexo = intent.getIntExtra("sexo",-1);
        double imc = peso / Math.pow(altura,2);

        texto = "Olá, " + nome +".\n"
                +"Seu IMC é: "+ String.format("%.1f",imc)+"\n" +
                "Classificação: ";

        texto2 = "Abaixo estão os riscos associados ao seu resultado:\n";

        if(sexo==0){
            if(imc>43){
                texto+= "Obesidade Mórbita!\n";
                texto2+="Refluxo, dificuldade para se mover, escaras, diabetes, infarto, AVC.";
            }else if(imc>30){
                texto+= "Obesidade Moderada!\n";
                texto2+="Diabetes, angina, infarto, aterosclerose, Apneia do sono, falta de ar.";
            }else if(imc>25){
                texto+= "Obesidade Leve!\n";
                texto2+="Fadiga, má circulação, varizes.";
            }else if(imc>20){
                texto+= "Normal!\n";
                texto2+="Menor risco de doenças cardíacas e vasculares.";
            }else if(imc>17){
                texto+= "Abaixo do Normal!\n";
                texto2+="Fadiga, stress, ansiedade.";
            }else{
                texto+= "Muito abaixo do Normal!\n";
                texto2+="Queda de cabelo, infertilidade.";
            }

        }
        if(sexo==1){
            if(imc>39){
                texto+= "Obesidade Mórbita!\n";
                texto2+="Refluxo, dificuldade para se mover, escaras, diabetes, infarto, AVC.";
            }else if(imc>29){
                texto+= "Obesidade Moderada!\n";
                texto2+="Diabetes, angina, infarto, aterosclerose, Apneia do sono, falta de ar.";
            }else if(imc>24){
                texto+= "Obesidade Leve!\n";
                texto2+="Fadiga, má circulação, varizes.";
            }else if(imc>19){
                texto+= "Normal!\n";
                texto2+="Menor risco de doenças cardíacas e vasculares.";
            }else if(imc>17){
                texto+= "Abaixo do Normal!\n";
                texto2+="Fadiga, stress, ansiedade.";
            }else{
                texto+= "Muito abaixo do Normal!\n";
                texto2+="Queda de cabelo, infertilidade,ausência menstrual.";
            }

        }

        txt_resultado.setText(texto);
        txt_resultado2.setText(texto2);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}