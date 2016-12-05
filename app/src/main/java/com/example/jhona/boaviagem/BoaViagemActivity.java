package com.example.jhona.boaviagem;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by jhona on 28/10/2016.
 */

public class BoaViagemActivity extends Activity {

    private EditText usuario;
    private EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        setContentView(R.layout.login);

        usuario = (EditText) findViewById(R.id.usuario);
        senha = (EditText) findViewById(R.id.senha);
    }

    public void entrarOnClick(View v){
        getWindow().setExitTransition(new Explode());
        String usuarioInformado = usuario.getText().toString();
        String senhaInformada = senha.getText().toString();

        if("Jhonathan".equals(usuarioInformado) && "123".equals(senhaInformada)){
            startActivity(new Intent(this, DashboardActivity.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());

        }
        else {
            String mensagemErro = getString(R.string.erro_autenticacao);
            Toast toast = Toast.makeText(this, mensagemErro, Toast.LENGTH_SHORT);

            toast.show();
        }
    }
}
