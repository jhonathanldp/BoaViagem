package com.example.jhona.boaviagem;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jhona on 10/11/2016.
 */

public class GastoListActivity extends ListActivity implements AdapterView.OnItemClickListener {

    private List<Map<String, Object>> gastos;
    private String dataAnterior = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] de = {
                "data", "descricao", "valor", "categoria"
        };

        int[] para = {
                R.id.data, R.id.descricao, R.id.valor, R.id.categoria
        };

        SimpleAdapter adapter = new SimpleAdapter(this, listarGastos(), R.layout.lista_gasto, de, para);
        adapter.setViewBinder(new GastoViewBinder());
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    private List<Map<String, Object>> listarGastos() {
        gastos = new ArrayList<Map<String, Object>>();

        Map<String, Object> item = new HashMap<String, Object>();
        item.put("data", "14/10/2012");
        item.put("descricao", "Diária Hotel");
        item.put("valor", "R$ 200,00");
        item.put("categoria", R.color.categoria_hospedagem);
        gastos.add(item);

        item = new HashMap<String, Object>();
        item.put("data", "14/10/2012");
        item.put("descricao", "Sanduiche de presunto");
        item.put("valor", "R$ 15,00");
        item.put("categoria", R.color.categoria_alimentacao);
        gastos.add(item);

        item = new HashMap<String, Object>();
        item.put("data", "15/11/2013");
        item.put("descricao", "Aluguel de carro");
        item.put("valor", "R$ 150,00");
        item.put("categoria", R.color.categoria_transporte);
        gastos.add(item);

        item = new HashMap<String, Object>();
        item.put("data", "15/11/2012");
        item.put("descricao", "Bungee Jump");
        item.put("valor", "R$ 200,00");
        item.put("categoria", R.color.categoria_outros);
        gastos.add(item);

        return gastos;

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Map<String, Object> map = gastos.get(position);
        String descricao = (String) map.get("descricao");
        String mensagem = "Gasto Selecionado: " + descricao;

        Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_SHORT).show();
        //startActivity(new Intent(this, GastoListActivity.class));
    }

    public class GastoViewBinder implements SimpleAdapter.ViewBinder{

        @Override
        public boolean setViewValue(View view, Object data, String textRepresentation) {

            if (view.getId() == R.id.data){
                if(!dataAnterior.equals(data)){
                    TextView textView = (TextView) view;
                    textView.setText(textRepresentation);
                    dataAnterior = textRepresentation;
                    view.setVisibility(View.VISIBLE);
                }
                else{
                    view.setVisibility(View.GONE);
                }
                return true;
            }

            if(view.getId() == R.id.categoria){
                Integer id = (Integer) data;
                view.setBackgroundColor(getResources().getColor(id));
                return true;
            }

            return false;
        }
    }

}
