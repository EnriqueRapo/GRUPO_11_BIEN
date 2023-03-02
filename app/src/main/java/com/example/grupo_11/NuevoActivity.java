package com.example.grupo_11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.grupo_11.db.DbEmpleados;

public class NuevoActivity extends AppCompatActivity {

    EditText txtDni, txtNombre, txtApellidos, txtTelefono, txtDepartamento, txtLocalidad, txtDireccion, txtEmail, txtHorario;
    Button btnGuarda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        txtDni = findViewById(R.id.txtDni);
        txtNombre = findViewById(R.id.txtNombre);
        txtApellidos = findViewById(R.id.txtApellidos);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtDepartamento = findViewById(R.id.txtDepartamento);
        txtLocalidad = findViewById(R.id.txtLocalidad);
        txtDireccion = findViewById(R.id.txtDireccion);
        txtEmail = findViewById(R.id.txtEmail);
        txtHorario = findViewById(R.id.txtHorario);
        btnGuarda= findViewById(R.id.btnGuarda);

        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DbEmpleados dbEmpleados = new DbEmpleados(NuevoActivity.this);
                long id= dbEmpleados.insertarEmpleado(txtDni.getText().toString(), txtNombre.getText().toString(),txtApellidos.getText().toString(), Integer.parseInt(txtTelefono.getText().toString()),txtDepartamento.getText().toString(), txtLocalidad.getText().toString(), txtDireccion.getText().toString(), txtEmail.getText().toString(), txtHorario.getText().toString());

                if (id> 0) {
                    Toast.makeText(NuevoActivity.this,"REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                    limpiar();
                } else {
                    Toast.makeText(NuevoActivity.this,"ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private void limpiar(){

        txtDni.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
        txtTelefono.setText("");
        txtDepartamento.setText("");
        txtLocalidad.setText("");
        txtDireccion.setText("");
        txtEmail.setText("");
        txtHorario.setText("");
    }
}