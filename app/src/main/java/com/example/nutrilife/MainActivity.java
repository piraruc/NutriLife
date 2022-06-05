package com.example.nutrilife;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn_calcular;
    private RadioGroup rbg_sexo;
    private RadioButton rb_masculino,rb_feminino;
    private EditText edt_name,edt_peso,edt_altura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_calcular= findViewById(R.id.btn_calcular);
        rbg_sexo = findViewById(R.id.rbg_sexo);
        edt_name = findViewById(R.id.editTextTextPersonName);
        edt_altura = findViewById(R.id.edt_altura);
        edt_peso = findViewById(R.id.edt_peso);
        rb_masculino = findViewById(R.id.rb_masculino);
        rb_feminino = findViewById(R.id.rb_feminino);

        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_name.getText().toString().isEmpty()||edt_altura.getText().toString().isEmpty()||edt_peso.getText().toString().isEmpty()||rbg_sexo.getCheckedRadioButtonId()==-1){
                    AlertDialog.Builder jan = new AlertDialog.Builder(MainActivity.this);
                    jan.setMessage("Todos os campos devem ser preenchidos!");
                    jan.setTitle("Erro");
                    jan.show();
                }else{
                    AlertDialog.Builder jan_confirma = new AlertDialog.Builder(MainActivity.this);
                    jan_confirma.setTitle("NutriLife");
                    jan_confirma.setMessage("Todos os dados estão corretos?");
                    jan_confirma.setPositiveButton("sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String nome=edt_name.getText().toString();
                            int sexo;
                            double peso= Double.parseDouble(edt_peso.getText().toString());
                            double altura = Double.parseDouble(edt_altura.getText().toString());
                            if(rb_feminino.isChecked()){
                                sexo=1;
                            }
                            if(rb_masculino.isChecked()){
                                sexo=0;
                            }

                            Intent intent = new Intent(getApplicationContext(),Resultado.class);
                            intent.putExtra("nome",nome);
                            intent.putExtra("peso",peso);
                            intent.putExtra("altura",altura);
                            intent.putExtra("sexo",sexo);

                            startActivity(intent);
                            edt_name.setText("");
                            edt_peso.setText("");
                            edt_altura.setText("");
                            rbg_sexo.clearCheck();
                        }
                    });
                    jan_confirma.setNegativeButton("não", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            edt_name.setText("");
                            edt_peso.setText("");
                            edt_altura.setText("");
                            rbg_sexo.clearCheck();
                            dialog.cancel();
                        }
                    });
                    jan_confirma.show();


                }
            }
        });



    }
}