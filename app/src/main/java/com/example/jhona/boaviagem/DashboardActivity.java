package com.example.jhona.boaviagem;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by jhona on 28/10/2016.
 */

public class DashboardActivity extends Activity{


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

    }

    public void selecionarOpcao(View view){

        TextView textView = (TextView) view;
        String opcao = "Opçao: " + textView.getText().toString();
        Toast.makeText(this, opcao, Toast.LENGTH_LONG).show();
    }
}
