package com.example.tp1loginusandshared;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.tp1loginusandshared.models.Persona;
import com.example.tp1loginusandshared.requests.ApiClient;

public class MainActivityViewModel extends AndroidViewModel {

    private ApiClient API;
    private Context context;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public void guardar(Persona usuario){

    }
    public void login(String mail, String pass){
        //llamar api
        Persona user = ApiClient.login(context,mail,pass);
        //si tengo usuario quiere decir que existe
        if(user == null){
            //advertencia tipo mutable
            Toast.makeText(context, "Usuario incorrecto", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent = new Intent(context,RegistroActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //avisar que va logged in
            intent.putExtra("logueado",true);
            context.startActivity(intent);
        }

    }
}
