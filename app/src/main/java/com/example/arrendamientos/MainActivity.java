package com.example.arrendamientos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText jethabitaciones;
    TextView jtvalquiler,jtvconparqueadero,jtvsinparqueadero,jtvtotal;
    RadioButton jrbcasa,jrbapartamento,jrbfinca;
    CheckBox jcbconparqueadero,jcbsinparqueadero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ocultar barra de titulo
        getSupportActionBar().hide();

        //Asociar objetos Java y Xml
        jethabitaciones=findViewById(R.id.ethabitaciones);
        jtvalquiler=findViewById(R.id.tvalquiler);
        jtvconparqueadero=findViewById(R.id.tvconparqueadero);
        jtvsinparqueadero=findViewById(R.id.tvsinparqueadero);
        jtvtotal=findViewById(R.id.tvtotal);
        jrbcasa=findViewById(R.id.rbcasa);
        jrbapartamento=findViewById(R.id.rbapartamento);
        jrbfinca=findViewById(R.id.rbfinca);
        jcbconparqueadero=findViewById(R.id.cbconparqueadero);
        jcbsinparqueadero=findViewById(R.id.cbsinparqueadero);
    }

    public void Calcular_valor_arriendo(View view){
        String cantidad_habitaciones=jethabitaciones.getText().toString();
        if (cantidad_habitaciones.isEmpty()){
            Toast.makeText(this, "La cantidad de habitaciones es requerida", Toast.LENGTH_SHORT).show();
            jethabitaciones.requestFocus();
        }
        else{
            int cantidad,valor_alquiler,valor_conparqueadero,valor_sinparqueadero,valor_total,valor_adicional;
            cantidad=Integer.parseInt(cantidad_habitaciones);
            if (cantidad < 1){
                Toast.makeText(this, "La cantidad de habitaciones debe ser mayor o igual a 1", Toast.LENGTH_SHORT).show();
            }
            /*
            else{
                if (cantidad <= 3){
                    valor_adicional=100000;
                }
                else{
                    if (cantidad <= 4){
                        valor_adicional=200000;
                    }
                    else{
                        valor_adicional=300000;
                    }
                }
            }
            */
            else{
                if (jrbcasa.isChecked()){
                    jtvalquiler.setText("400000");
                    valor_alquiler=400000;
                }
                else{
                    if (jrbapartamento.isChecked()){
                        jtvalquiler.setText("300000");
                        valor_alquiler=300000;
                    }
                    else{
                        jtvalquiler.setText("600000");
                        valor_alquiler=600000;
                    }
                }
                if (jcbconparqueadero.isChecked()){
                    jtvconparqueadero.setText("100000");
                    valor_conparqueadero=100000;
                }
                else{
                    jtvconparqueadero.setText("0");
                    valor_conparqueadero=0;
                }

                if (jcbsinparqueadero.isChecked()){
                    jtvsinparqueadero.setText("0");
                    valor_sinparqueadero=0;
                }
                else{
                    jtvsinparqueadero.setText("0");
                    valor_sinparqueadero=0;
                }

                valor_total= cantidad * valor_alquiler + valor_conparqueadero + valor_sinparqueadero;
                jtvtotal.setText(String.valueOf(valor_total));
            }
        }
    }

    public void Limpiar(View view){
        jrbapartamento.setChecked(true);
        jcbconparqueadero.setChecked(false);
        jcbsinparqueadero.setChecked(false);
        jtvalquiler.setText("400000");
        jtvconparqueadero.setText("0");
        jtvsinparqueadero.setText("0");
        jtvtotal.setText("0");
        jethabitaciones.setText("");
        jethabitaciones.requestFocus();
    }
}