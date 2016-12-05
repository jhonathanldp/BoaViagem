package com.example.jhona.boaviagem;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.jhona.boaviagem.domains.DialogoCalendario;
import com.example.jhona.boaviagem.domains.DialogoCalendarioViagem;

import java.util.Calendar;

/**
 * Created by jhona on 01/11/2016.
 */

public class NovaViagemActivity extends Activity implements DatePickerDialog.OnDateSetListener{
    private int ano, mes, dia;
    private String dataDeSaida, dataDeChegada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.novaviagem);

        Calendar calendar = Calendar.getInstance();
        ano = calendar.get(Calendar.YEAR);
        mes = calendar.get(Calendar.MONTH);
        dia = calendar.get(Calendar.DAY_OF_MONTH);

        dataDeChegada = dia + "/" + mes + "/" + ano;
        dataDeSaida = dia + "/" + mes + "/" + ano;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.viagem_menu, menu);
        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch (item.getItemId()){
            case R.id.novo_gasto:
                startActivity(new Intent(this,GastoActivity.class));
                return true;
            case R.id.remover:
                //Remove viagem do banco de dados
                return true;
            default:
                return super.onMenuItemSelected(featureId, item);
        }

    }

    public void selecionarData(View view){
        DialogFragment dialogFragment = new DialogoCalendarioViagem();
        if(view.getId() == findViewById(R.id.dataChegada).getId()){
            dialogFragment.show(getFragmentManager(), "dataChegada");

        }
        else if(view.getId() == findViewById(R.id.dataSaida).getId()){
            dialogFragment.show(getFragmentManager(), "dataSaida");
        }


    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        FragmentManager fragmentManager = getFragmentManager();

        if(fragmentManager.findFragmentByTag("dataChegada")!= null){
            dataDeChegada = dayOfMonth + "/" + month + "/" + year;
            Toast.makeText(this, "Data de chegada: " + dataDeChegada, Toast.LENGTH_SHORT).show();

        }
        else if (fragmentManager.findFragmentByTag("dataSaida") != null){
            dataDeSaida = dayOfMonth + "/" + month + "/" + year;
            Toast.makeText(this, "Data de saida: " + dataDeSaida, Toast.LENGTH_SHORT).show();
        }
    }

}

