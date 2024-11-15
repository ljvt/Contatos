package com.lazaro.contatos;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private EditText nome, telefone, email;
    private Button salvar;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        AppDatabase ap = AppDatabase.getInstancia(this);
        nome = findViewById(R.id.editTextNome);
        telefone = findViewById(R.id.editTextTelefone);
        email = findViewById(R.id.editTextEmail);
        salvar = findViewById(R.id.button);
        floatingActionButton = findViewById(R.id.floatingActionButton);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nome.length() > 0 && telefone.length() > 0 && email.length() > 0) {
                    Contato contato = new Contato(null, nome.getText().toString(), telefone.getText().toString(), email.getText().toString());
                    Log.i(TAG, "onClick: " + contato);

                } else {
                    Toast.makeText(MainActivity.this, "Campo vazio!", Toast.LENGTH_LONG).show();
                }
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ContatoListaActivity.class));
            }
        });
    }
}