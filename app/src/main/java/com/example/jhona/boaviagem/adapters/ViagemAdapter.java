package com.example.jhona.boaviagem.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jhona.boaviagem.R;
import com.example.jhona.boaviagem.domains.Viagem;
import com.example.jhona.boaviagem.interfaces.RecyclerOnClickListenerHack;

import java.util.List;

/**
 * Created by jhona on 11/11/2016.
 */

public class ViagemAdapter extends RecyclerView.Adapter<ViagemAdapter.MinhaViewHolder> {

    private List<Viagem> mLista;
    private LayoutInflater layoutInflater;
    private RecyclerOnClickListenerHack recyclerOnClickListenerHack;

    public ViagemAdapter(Context c, List<Viagem> l){
        mLista = l;
        layoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    // chamado sempre que a view for criada
    @Override
    public MinhaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.lista_viagem, parent, false);
        MinhaViewHolder minhaViewHolder = new MinhaViewHolder(v);
        return minhaViewHolder;
    }
    // Vincula dados da lista a view
    @Override
    public void onBindViewHolder(MinhaViewHolder holder, int position) {
        holder.imagemCategoria.setImageResource(mLista.get(position).getFoto());
        holder.destino.setText(mLista.get(position).getDestino());
        holder.custoTotal.setText(mLista.get(position).getValor());
        holder.data.setText(mLista.get(position).getData());


    }
    // tamanho da lista
    @Override
    public int getItemCount() {
        return mLista.size();
    }

    public void addItemList(Viagem v, int position){
        mLista.add(v);
        notifyItemInserted(position);
    }

    public void setRecyclerOnClickListenerHack(RecyclerOnClickListenerHack r) {
        this.recyclerOnClickListenerHack = r;
    }

    /*Isso aqui armazena as views da lista como se fosse um cache para
        ser acessado mais rapidamente
         */
    public class MinhaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView imagemCategoria;
        public TextView destino, data, custoTotal;



        public MinhaViewHolder(View itemView) {
            super(itemView);

            imagemCategoria = (ImageView) itemView.findViewById(R.id.tipoViagemImagem);
            data = (TextView) itemView.findViewById(R.id.dataListViagem);
            destino = (TextView) itemView.findViewById(R.id.destinoListViagem);
            custoTotal = (TextView) itemView.findViewById(R.id.valorListViagem);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(recyclerOnClickListenerHack != null){
                recyclerOnClickListenerHack.onClickListener(v, getAdapterPosition());
            }
        }
    }
}
