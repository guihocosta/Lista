package activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import costa.omena.guilherme.lista.R;

public class NewItemActivity extends AppCompatActivity {

    static int PHOTO_PICKER_REQUEST = 1;

    // Uri vai guardar o endereco da imagem, nao a imagem em si
    Uri photoSelected = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);

        ImageButton imgCI = findViewById(R.id.imbCl);
        imgCI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Intenção de abrir um documento
                Intent photoPickerIntent = new Intent(Intent.ACTION_OPEN_DOCUMENT);

                // Selecionando somente as imagens
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, PHOTO_PICKER_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Verifica a chamada do StartActivityForResult, se e a mesma
        if (requestCode == PHOTO_PICKER_REQUEST) {

            // Verifica se a Activity de destino retornou com sucesso ou nao
            if (resultCode == Activity.RESULT_OK){

                // Recebe os dados retornados pela Activity
                photoSelected = data.getData();
                ImageView imvfotoPreview = findViewById(R.id.imvPhotoPreview);
                imvfotoPreview.setImageURI(photoSelected);

            }
        }
    }
}