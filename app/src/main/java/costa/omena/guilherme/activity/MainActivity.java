package costa.omena.guilherme.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import costa.omena.guilherme.adapter.MyAdapter;
import costa.omena.guilherme.lista.R;
import costa.omena.guilherme.model.MyItem;

public class MainActivity extends AppCompatActivity {

    static int NEW_ITEM_REQUEST = 1;
    List<MyItem> itens = new ArrayList<>();
    MyAdapter myAdapter;

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

        // Obtem o RecyclerView
        RecyclerView rvItens = findViewById(R.id.rvItens);

        // Cria e seta o adapter
        // Ensina o RecyclerView a construir e preenche a lista
        myAdapter = new MyAdapter(this,itens);
        rvItens.setAdapter(myAdapter);

        rvItens.setHasFixedSize(true);

        // Criando e setando gerenciador do Layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvItens.setLayoutManager(layoutManager);

        // Linha que separa os itens
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvItens.getContext(), DividerItemDecoration.VERTICAL);
        rvItens.addItemDecoration(dividerItemDecoration);
    }

    // Metodo chamado quando o resultado é retornado
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == NEW_ITEM_REQUEST){
            if(resultCode == Activity.RESULT_OK){

                // Guardando os dados do item em MyItem, classe que criamos
                MyItem myItem = new MyItem();
                myItem.title = data.getStringExtra("title");
                myItem.description = data.getStringExtra("description");
                myItem.photo = data.getData();

                // Adicionando na Array de itens
                itens.add(myItem);

                // Notifica o adapter de que a lista foi alterado
                myAdapter.notifyItemInserted(itens.size()-1);
            }
        }


    }
}