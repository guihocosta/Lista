package costa.omena.guilherme.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import costa.omena.guilherme.activity.MainActivity;
import costa.omena.guilherme.lista.R;
import costa.omena.guilherme.model.MyItem;

public class MyAdapter extends RecyclerView.Adapter {
    MainActivity mainActivity;
    List<MyItem> itens;

    public MyAdapter(MainActivity mainActivity, List<MyItem> itens){
        this.mainActivity = mainActivity;
        this.itens = itens;
    }

    // Cria o layout
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Inflador serve para ler arquivo xml do item e criar os elementos de interface
        LayoutInflater inflater = LayoutInflater.from(mainActivity);

        // Recebe o constraint layout
        View v = inflater.inflate(R.layout.item_list, parent, false);
        return new MyViewHolder(v);
    }

    // Preenche o layout
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        // Indica qual elemento da lista deve ser usado para preencher o item
        MyItem myItem = itens.get(position);

        // Guarda os itens da interface
        View v = holder.itemView;

        // Setando os dados
        ImageView imvfoto = v.findViewById(R.id.imvfoto);
        imvfoto.setImageURI(myItem.photo);

        TextView tvTitle = v.findViewById(R.id.tvTitle);
        tvTitle.setText(myItem.title);

        TextView tvdesc = v.findViewById(R.id.tvDesc);
        tvdesc.setText(myItem.description);


    }

    @Override
    public int getItemCount() {
        return itens.size();
    }

}
