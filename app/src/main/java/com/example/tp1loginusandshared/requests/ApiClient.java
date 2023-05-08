package com.example.tp1loginusandshared.requests;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.tp1loginusandshared.models.Persona;


public class ApiClient {
    private static SharedPreferences sp;

    private static SharedPreferences conectar(Context context) {
        if (sp == null) {
            sp = context.getSharedPreferences("datos", 0);
        }

        return sp;
    }

    public static void guardar(Context context, Persona usuario){
        SharedPreferences sp = conectar(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("dni", usuario.getDni());
        editor.putString("nombre", usuario.getNombre());
        editor.putString("apellido", usuario.getApellido());
        editor.putString("email", usuario.getMail());
        editor.putString("password", usuario.getPassword());

        editor.commit();
    }

    public static Persona leer(Context context){
        SharedPreferences sp = conectar(context);
        String dni = sp.getString("dni", "-1");
        String nombre = sp.getString("nombre","-1");
        String apellido = sp.getString("apellido","-1");
        String email = sp.getString("email","-1");
        String password = sp.getString("password","-1");

        Persona usuario = new Persona(nombre,dni,apellido,password,email);
        return usuario;
    }

    public static Persona login(Context context, String mail, String password){
        Persona usuario = null;
        SharedPreferences sp = conectar(context);

        String dni = sp.getString("dni", "-1");
        String nombre = sp.getString("nombre","-1");
        String apellido = sp.getString("apellido","-1");
        String email = sp.getString("email","-1");
        String pass = sp.getString("password","-1");

        if(mail.equals(email) && password.equals(pass)){
            usuario = new Persona(nombre,dni,apellido,password,mail);
        }
        return usuario;
    }
}
