package br.com.treinaweb.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    private int valor1, valor2;
    private String operador;
    private TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        display = (EditText) findViewById(R.id.editText);


    }

    public void number(View view) {
        Editable str = display.getEditableText();
        Button b = (Button) view;

        if (valor2 != 0) {
            valor2 = 0;
            display.setText("");
        }

        str.append(b.getText().toString());
    }

    public void cancelar(View view) {
        valor1 = 0;
        valor2 = 0;
        display.setText("");
    }

    public void operadores(View view) {

        try {
            Button btn = (Button) view;
            operador = btn.getText().toString();
            if (valor1 == 0) {
                valor1 = Integer.parseInt(display.getText().toString());
                display.setText("");
            } else if (valor2 != 0) {
                valor2 = 0;
                display.setText("");
            }else {
                valor2 = Integer.parseInt(display.getText().toString());
                display.setText(Integer.toString(calcular()));
            }
        } catch (Exception e) {

        }

    }

    private int calcular(){
        if(operador.equals("+")){
           valor1 = valor1 + valor2;
        }else if(operador.equals("-")){
            valor1 = valor1 - valor2;
        }else if(operador.equals("*")){
            valor1 = valor1 * valor2;
        }else if(operador.equals("/")){
            valor1 = valor1 / valor2;
        }

        return (valor1);
    }


    public void resultado(View view){

        try {
            if(!operador.equals(null)){
                if(valor2 != 0){
                    display.setText(Integer.toString(valor1));
                }else{
                    valor2 = Integer.parseInt(display.getText().toString());
                    display.setText(Integer.toString(calcular()));
                }
            }
        }catch (Exception e){

        }
    }


}
