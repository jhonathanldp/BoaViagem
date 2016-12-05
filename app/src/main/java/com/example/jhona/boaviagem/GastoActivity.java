package com.example.jhona.boaviagem;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;

import com.example.jhona.boaviagem.domains.DialogoCalendario;

import java.util.Calendar;

/**
 * Created by jhona on 01/11/2016.
 */

public class GastoActivity extends Activity implements DatePickerDialog.OnDateSetListener {
    private int ano, mes, dia;
    private String data;
    private Button dataGasto;
    private Spinner categoria;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gasto);
        Calendar calendar = Calendar.getInstance();
        ano = calendar.get(Calendar.YEAR);
        mes = calendar.get(Calendar.MONTH);
        dia = calendar.get(Calendar.DAY_OF_MONTH);

        dataGasto = (Button) findViewById(R.id.data);
        data = dia + "/" + mes + "/" + ano;
        dataGasto.setText(data);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categoria_gasto,
                android.R.layout.simple_spinner_dropdown_item);
        categoria = (Spinner) findViewById(R.id.categoria);
        categoria.setAdapter(adapter);

    }



    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        data = dayOfMonth + "/" + month + "/" + year;
        dataGasto.setText(data);
    }

    public void selecionarDate(View view){
        DialogFragment dialogFragment = new DialogoCalendario();
        dialogFragment.show(getFragmentManager(), "datePicker");
    }


}
