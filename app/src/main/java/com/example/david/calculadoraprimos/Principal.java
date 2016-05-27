package com.example.david.calculadoraprimos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Principal extends AppCompatActivity {

    //Referencia a los widgets añadidos
    @BindView(R.id.txtNum)
    EditText txtnumero;

    @BindView(R.id.areaTexto)
    TextView area;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnCalcular)
    public void calculamos() {

        if (txtnumero.getText().toString().isEmpty()) {
            //Comprobamos que no este vacio el EditText
            txtnumero.setError("Rellene el Campo");
        } else {
            int num = Integer.parseInt(txtnumero.getText().toString());
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
                txtnumero.setError("Valor > 0");
            }
            if (numero == 1) {
                resultado = "El Primo Numero " + numero + " es el 1";
            }
        }
        return resultado;
    }
}
