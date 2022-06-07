package com.example.appexamen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtNombre;
    private EditText txtBase;
    private EditText txtAltura;
    private Button btnLimpiar;
    private Button btnSiguiente;
    private Button btnSalir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtBase = (EditText) findViewById(R.id.txtBase);
        txtAltura = (EditText) findViewById(R.id.txtAltura);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        btnSalir = (Button) findViewById(R.id.btnSalir);

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtNombre.getText().toString().matches("") &&
                    txtBase.getText().toString().matches("") &&
                    txtAltura.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this, "No Hay Campos Llenos", Toast.LENGTH_SHORT).show();
                } else {
                    txtNombre.setText("");
                    txtAltura.setText("");
                    txtBase.setText("");
                    Toast.makeText(MainActivity.this, "Campos Vaciados", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtNombre.getText().toString().matches("") ||
                        txtBase.getText().toString().matches("") ||
                        txtAltura.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this, "Faltan rellenar campos", Toast.LENGTH_SHORT).show();
                } else {
                    String nombre = txtNombre.getText().toString();
                    String base = txtBase.getText().toString();
                    String altura = txtAltura.getText().toString();
                    //float base = Float.valueOf(txtBase.getText().toString());
                    //  float altura = Float.valueOf(txtBase.getText().toString());
                    Intent intent = new Intent(MainActivity.this, RectanguloActivity.class);
                    intent.putExtra("Nombre",nombre);
                    intent.putExtra("Base",base);
                    intent.putExtra("Altura",altura);
                    startActivity(intent);
                }
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder confirmar = new AlertDialog.Builder(MainActivity.this);
                confirmar.setTitle("¿Cerrar Aplicacion?");
                confirmar.setMessage("Se Descartaran Cualquier Dato Que Haya Ingresado");
                confirmar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Nada
                    }
                });
                confirmar.show();
            }
        });


    }
}