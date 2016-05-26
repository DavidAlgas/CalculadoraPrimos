package com.example.david.calculadoraprimos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity implements View.OnClickListener {

    //Referencia a los widgets añadidos
    Button btncalcular;
    EditText txtnumero;
    TextView area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btncalcular = (Button) findViewById(R.id.btnCalcular);

        if (btncalcular != null) {
            btncalcular.setOnClickListener(this);
        }
    }

    public void onClick(View view) {

        //Responde al evento de pulsar el boton
        txtnumero = (EditText) findViewById(R.id.txtNum);
        area = (TextView) findViewById(R.id.areaTexto);
        int num;


        if (txtnumero.getText().toString().trim().length() == 0) {

            //Comprobamos que no este vacio el EditText
            Toast.makeText(Principal.this, "Introduzca Valor Numérico", Toast.LENGTH_SHORT).show();
        } else {
            num = Integer.parseInt(txtnumero.getText().toString());
            area.setText(Calcular(num));
        }
    }

    //Clase para Calcular la posicion del numero Primo
    public String Calcular(int numero) {

        String resultado = "";
        int ultimoPrimo = 0, c = 1, p = 2, d = 2;

        if (numero >= 2) {
            while (c < numero) {
                if (p % d == 0) {
                    if (p == d) {
                        ultimoPrimo = p;
                        c++;
                    }
                    d = 2;
                    p++;
                } else {
                    d++;
                }
            }
            resultado = "El Primo Numero " + numero + " es el " + ultimoPrimo;
        } else {
            if (numero == 0) {
                Toast.makeText(Principal.this, "Introduzca Valor mayor a 0", Toast.LENGTH_SHORT).show();
            }
            if (numero == 1) {
                resultado = "El Primo Numero " + numero + " es el 1";
            }
        }

        return resultado;
    }
}
