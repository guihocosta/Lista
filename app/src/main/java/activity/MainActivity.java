package activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import costa.omena.guilherme.lista.R;

public class MainActivity extends AppCompatActivity {

    static int NEW_ITEM_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtem botao flutuante
        FloatingActionButton fabAddItem = findViewById(R.id.fabAddNewItem);
        fabAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, NewItemActivity.class);

                // Inicia a outra tela esperando um retorno
                startActivityForResult(i, NEW_ITEM_REQUEST);

            }
        });
    }
}