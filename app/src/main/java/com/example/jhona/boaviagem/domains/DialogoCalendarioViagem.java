package com.example.jhona.boaviagem.domains;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

import com.example.jhona.boaviagem.NovaViagemActivity;

import java.util.Calendar;

/**
 * Created by jhona on 09/11/2016.
 */

public class DialogoCalendarioViagem extends DialogFragment {
    private int ano, mes, dia;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar calendar = Calendar.getInstance();
        ano = calendar.get(Calendar.YEAR);
        mes = calendar.get(Calendar.MONTH);
        dia = calendar.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), (NovaViagemActivity)getActivity(), ano, mes, dia);
    }
}
