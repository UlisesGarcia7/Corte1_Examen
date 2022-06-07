package com.example.appexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

public class RectanguloActivity extends AppCompatActivity {
    private TextView lblNombre;
    private TextView lblBase;
    private TextView lblAltura;
    private RadioButton rbtnArea;
    private RadioButton rbtnPerimetro;
    private TextView lblResultado;
    private Button btnCalcular;
    private Button btnRegresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo);
        lblNombre = (TextView) findViewById(R.id.lblNombre);
        lblBase = (TextView) findViewById(R.id.lblBase);
        lblAltura = (TextView) findViewById(R.id.lblAltura);
        rbtnArea = (RadioButton) findViewById(R.id.rbtnArea);
        rbtnPerimetro = (RadioButton) findViewById(R.id.rbtnPerimetro);
        lblResultado = (TextView) findViewById(R.id.lblResultado);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);

        Rectangulo rectangulo = new Rectangulo();

        Bundle bundle = getIntent().getExtras();
        String nombre = bundle.getString("Nombre");
        String base = bundle.getString("Base");
        String altura = bundle.getString("Altura");
        lblNombre.setText("Nombre: " + nombre);
        lblBase.setText("Base: " + base);
        lblAltura.setText("Altura: " + altura);

        float numBase = Float.parseFloat(base);
        rectangulo.setBase(numBase);
        float numAltura = Float.parseFloat(altura);
        rectangulo.setAltura(numAltura);
        RadioButton radioArea = (RadioButton) findViewById(R.id.rbtnArea);
        RadioButton radioPerimetro = (RadioButton) findViewById(R.id.rbtnPerimetro);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioArea.isChecked()){
                    lblResultado.setText("El Area es: " + rectangulo.calcularArea());
                } else if(radioPerimetro.isChecked()){
                    lblResultado.setText("El Perimetro es: " + rectangulo.calcularPerimetro());
                } else {
                    Toast.makeText(RectanguloActivity.this, "Debe seleccinar un tipo de calculo", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }


}