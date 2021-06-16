package com.example.calculadora_aula1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private EditText et1,et2;
    private TextView tvRes;
    private ImageView limpar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        et1 = findViewById(R.id.editTextNumero1);
        et2 = findViewById(R.id.editTextNumero2);
        tvRes = findViewById(R.id.tvResultado);
        limpar = findViewById(R.id.imageView);

        ArrayAdapter<String> adaptadorSpinner = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1
        );

        spinner.setAdapter(adaptadorSpinner);
        adaptadorSpinner.add("Selecione a operação:");
        adaptadorSpinner.add("Soma");
        adaptadorSpinner.add("Subtração");
        adaptadorSpinner.add("Multiplicação");
        adaptadorSpinner.add("Divisão");

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int opNumber = spinner.getSelectedItemPosition();
                String op = (String) spinner.getSelectedItem();

                String etString1 = et1.getText().toString();
                String etString2 = et2.getText().toString();

                Double et1Convert,et2Convert;

                if(etString1.isEmpty()){
                    et1.setError("Campo obrigatório");
                    return;
                }else{
                    et1Convert = Double.valueOf(etString1);
                }

                if(etString2.isEmpty()){
                    et2.setError("Campo obrigatório");
                    return;
                }else{
                    et2Convert = Double.valueOf(etString2);
                }

                Double res;

                if(op.equals("Soma")){
                    res = et1Convert + et2Convert;
                    tvRes.setText("Resultado da Soma: "+ res.toString());
                }else if(op.equals("Subtração")){
                    res = et1Convert - et2Convert;
                    tvRes.setText("Resultado da Subtração: "+ res.toString());
                }else if(op.equals("Multiplicação")){
                    res = et1Convert * et2Convert;
                    tvRes.setText("Resultado da Multiplicação: "+ res.toString());
                }else if(op.equals("Divisão")){
                    res = et1Convert / et2Convert;
                    tvRes.setText("Resultado da Divisão: "+ res.toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.getText().clear();
                et2.getText().clear();
            }
        });


    }
}