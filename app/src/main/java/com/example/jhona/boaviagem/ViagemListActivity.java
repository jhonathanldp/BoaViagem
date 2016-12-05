package com.example.jhona.boaviagem;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.jhona.boaviagem.adapters.ViagemAdapter;
import com.example.jhona.boaviagem.domains.Viagem;
import com.example.jhona.boaviagem.interfaces.RecyclerOnClickListenerHack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jhona on 10/11/2016.
 */

public class ViagemListActivity extends Activity implements RecyclerOnClickListenerHack{
    private RecyclerView recyclerView;
    private List<Viagem> mLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_viagem_recycler);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViagem);
        recyclerView.setHasFixedSize(true);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) { // permite adicionar ações caso chegue ao fim da tela
                super.onScrolled(recyclerView, dx, dy);

               /* LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                ViagemAdapter viagemAdapter = (ViagemAdapter) recyclerView.getAdapter();

                if(mLista.size() == linearLayoutManager.findLastCompletelyVisibleItemPosition()+ 1){
                    List<Viagem> listAux = preencherLista();
                    for(int i = 0; i <  listAux.size(); i++){
                        viagemAdapter.addItemList(listAux.get(i), listAux.size());
                    }
                }*/


            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.addOnItemTouchListener(new RecyclerViewOnClickListener(this, recyclerView, this));

        mLista = preencherLista();
        ViagemAdapter viagemAdapter = new ViagemAdapter(this, mLista);
        //viagemAdapter.setRecyclerOnClickListenerHack(this);
        recyclerView.setAdapter(viagemAdapter);

    }

    public List<Viagem> preencherLista(){
        List<Viagem> l = new ArrayList<Viagem>();
        Viagem v = new Viagem();
        v.setData("14/10/2012 à 15/10/2012");
        v.setDestino("São Paulo");
        v.setValor("R$ 4400");
        v.setFoto(R.mipmap.logo);

        l.add(v);

        v.setData("14/11/2012 à 18/11/2012");
        v.setDestino("Telêmaco Borba");
        v.setValor("R$ 25'485,86");
        v.setFoto(R.mipmap.logo);

        l.add(v);

        v.setData("14/10/2013 à 18/11/2013");
        v.setDestino("Salvador");
        v.setValor("R$ 254'458,85");
        v.setFoto(R.mipmap.logo);

        l.add(v);

        return l;

    }

    @Override
    public void onClickListener(View v, int position) {
        Toast.makeText(this, "Posição " + position, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, GastoListActivity.class));
    }

    @Override
    public void onLongClickListener(View v, int position) {
        Toast.makeText(this, "Usando Long, Posição " + position, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, GastoListActivity.class));
    }

    public static class RecyclerViewOnClickListener implements RecyclerView.OnItemTouchListener{
        private Context context;
        private GestureDetector gestureDetector;
        private RecyclerOnClickListenerHack recyclerOnClickListenerHack;

        public RecyclerViewOnClickListener(Context c, final RecyclerView rv, RecyclerOnClickListenerHack roclh){
            context = c;
            recyclerOnClickListenerHack = roclh;

            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
                @Override
                public void onLongPress(MotionEvent e) {
                    super.onLongPress(e);

                    View cv = rv.findChildViewUnder(e.getX(), e.getY());

                    if(cv != null && recyclerOnClickListenerHack != null){
                        //acessa o filho do layout pressionado
                        recyclerOnClickListenerHack.onLongClickListener(cv, rv.getChildLayoutPosition(cv));
                    }
                }

                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    View cv = rv.findChildViewUnder(e.getX(), e.getY());

                    if (cv != null && recyclerOnClickListenerHack != null) {
                        //acessa o filho do layout pressionado
                        recyclerOnClickListenerHack.onClickListener(cv, rv.getChildLayoutPosition(cv));

                    }
                    return (true);
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            gestureDetector.onTouchEvent(e); // verifica se foi um click comum ou um click longo;
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }


}
